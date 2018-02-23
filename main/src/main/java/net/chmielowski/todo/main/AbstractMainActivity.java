package net.chmielowski.todo.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.hannesdorfmann.mosby3.mvi.MviActivity;
import com.jakewharton.rxbinding2.widget.RxTextView;

import net.chmielowski.todo.main.databinding.ActivityMainBinding;

import javax.inject.Inject;

import io.reactivex.Observable;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;

abstract class AbstractMainActivity extends MviActivity<MainView, MainPresenter>
        implements MainView {

    @Inject
    ListsAdapter adapter;

    @Inject
    MainPresenterFactory presenterFactory;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.listsPager.setAdapter(adapter);
        binding.listsPager.setClipToPadding(false);
        int dp = 16; // TODO: get from res
        int paddingFactor = 2;
        binding.listsPager.setPadding(dpToPx(dp * paddingFactor), 0, dpToPx(dp * paddingFactor), 0);
        binding.listsPager.setPageMargin(dpToPx(dp));
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return presenterFactory.create();
    }

    @NonNull
    public Observable<NoValue> addNewClicked() {
        return RxUtils.clicks(binding.addNew);
    }

    @NonNull
    public Observable<String> textChanged() {
        return RxTextView.textChanges(binding.newListName)
                .map(CharSequence::toString)
                .doOnNext(v -> Log.d("pchm", "AbstractMainActivity::textChanged " + v));
    }

    @NonNull
    public Observable<NoValue> confirmAddingClicked() {
        return RxUtils.clicks(binding.confirmAdding)
                .doOnNext(noValue -> Log.d("pchm", "confirmAddingClicked"));
    }


    public void render(final MainViewState viewState) {
        binding.newListName
                .setVisibility(toVisibility(viewState.enterNameVisible));
        binding.addNew
                .setVisibility(toVisibility(viewState.addNewVisible));
        binding.confirmAdding
                .setVisibility(toVisibility(viewState.confirmVisible));
        adapter.bind(viewState.lists);
    }

    private int toVisibility(final boolean asBoolean) {
        return asBoolean ? View.VISIBLE : View.GONE;
    }

    int dpToPx(final int dp) {
        return (int) TypedValue.applyDimension(
                COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }
}

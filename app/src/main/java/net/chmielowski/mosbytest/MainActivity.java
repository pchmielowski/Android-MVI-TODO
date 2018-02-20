package net.chmielowski.mosbytest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.hannesdorfmann.mosby3.mvi.MviActivity;
import com.jakewharton.rxbinding2.widget.RxTextView;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MainActivity extends MviActivity<MainView, MainPresenter> implements MainView {

    @Inject
    MainPresenterFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.INSTANCE.appComponent().inject(this);
        setContentView(R.layout.activity_main);
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return factory.create();
    }

    @NonNull
    @Override
    public Observable<NoValue> addNewClicked() {
        return RxUtils.clicks(findViewById(R.id.add_new));
    }

    @NonNull
    @Override
    public Observable<String> textChanged() {
        return RxTextView.textChanges(findViewById(R.id.new_list_name))
                .map(CharSequence::toString);
    }

    @NonNull
    @Override
    public Observable<NoValue> confirmAddingClicked() {
        return RxUtils.clicks(findViewById(R.id.confirm_adding));
    }

    @Override
    public void render(final MainViewState viewState) {
        findViewById(R.id.new_list_name)
                .setVisibility(toVisibility(viewState.enterNameVisible));
        findViewById(R.id.add_new)
                .setVisibility(toVisibility(viewState.addNewVisible));
        ((TextView) findViewById(R.id.result))
                .setText(viewState.allLists);
        findViewById(R.id.confirm_adding)
                .setVisibility(toVisibility(viewState.confirmVisible));
    }

    private int toVisibility(final boolean asBoolean) {
        return asBoolean ? View.VISIBLE : View.GONE;
    }
}

package net.chmielowski.mosbytest;

import android.os.Bundle;
import android.support.annotation.NonNull;
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

    @Override
    public Observable<String> queryChanged() {
        return RxTextView.textChanges(findViewById(R.id.query))
                .map(CharSequence::toString);
    }

    @Override
    public void render(final MainViewState viewState) {
        ((TextView) findViewById(R.id.result))
                .setText(viewState.query);
    }
}

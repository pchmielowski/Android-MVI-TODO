package net.chmielowski.mosbytest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.hannesdorfmann.mosby3.mvi.MviActivity;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MainActivity extends MviActivity<MainView, MainPresenter> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
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

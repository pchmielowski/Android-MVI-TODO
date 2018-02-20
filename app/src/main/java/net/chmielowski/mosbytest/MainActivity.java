package net.chmielowski.mosbytest;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvi.MviActivity;

import javax.inject.Inject;

public class MainActivity extends MviActivity<MainView, MainPresenter> implements MainView {

    @Inject
    MainPresenterFactory presenterFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.INSTANCE.appComponent().inject(this);
        setContentView(R.layout.activity_main);
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return presenterFactory.create();
    }

    @Override
    public Intents intents() {
        return new IntentsImpl(this);
    }

    @Override
    public Renderer renderer() {
        return new RendererImpl(this);
    }

}

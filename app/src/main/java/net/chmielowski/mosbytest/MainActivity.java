package net.chmielowski.mosbytest;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvi.MviActivity;

import javax.inject.Inject;

public class MainActivity extends MviActivity<MainView, MainPresenter> implements MainView {

    @Inject
    MainPresenterFactory presenterFactory;
    @Inject
    RendererImplFactory renderer;
    @Inject
    IntentsImplFactory intents;

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
        return intents.create(this);
    }


    @Override
    public Renderer renderer() {
        return renderer.create(this);
    }

}

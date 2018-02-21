package net.chmielowski.todo.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;

import com.hannesdorfmann.mosby3.mvi.MviActivity;

import javax.inject.Inject;

abstract class AbstractMainActivity extends MviActivity<MainView, MainPresenter> implements MainView {

    @Inject
    ListsAdapter adapter;

    @Inject
    MainPresenterFactory presenterFactory;

    @Inject
    Renderer renderer;

    @Inject
    Intents intents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.<ViewPager>findViewById(R.id.lists_pager).setAdapter(adapter);
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return presenterFactory.create();
    }

    @Override
    public Intents intents() {
        return intents;
    }

    @Override
    public Renderer renderer() {
        return renderer;
    }
}

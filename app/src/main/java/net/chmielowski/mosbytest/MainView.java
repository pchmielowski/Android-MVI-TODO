package net.chmielowski.mosbytest;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import io.reactivex.Observable;

interface MainView extends MvpView {
    Observable<String> queryChanged();

    void render(MainViewState viewState);
}

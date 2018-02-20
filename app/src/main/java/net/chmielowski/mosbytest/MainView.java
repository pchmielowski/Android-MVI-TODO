package net.chmielowski.mosbytest;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import io.reactivex.Observable;

interface MainView extends MvpView {
    @NonNull
    Observable<String> queryChanged();

    void render(MainViewState viewState);
}

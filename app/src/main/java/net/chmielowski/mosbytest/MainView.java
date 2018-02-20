package net.chmielowski.mosbytest;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import io.reactivex.Observable;

interface MainView extends MvpView {
    interface Intents {
        @NonNull
        Observable<NoValue> addNewClicked();

        @NonNull
        Observable<String> textChanged();

        @NonNull
        Observable<NoValue> confirmAddingClicked();

    }

    interface Renderer {
        void render(MainViewState viewState);
    }

    Intents intents();

    Renderer renderer();
}

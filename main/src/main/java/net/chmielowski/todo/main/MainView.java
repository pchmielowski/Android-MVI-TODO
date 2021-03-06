package net.chmielowski.todo.main;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import io.reactivex.Observable;

public interface MainView extends MvpView {
    @NonNull
    Observable<NoValue> addNewClicked();

    @NonNull
    Observable<String> textChanged();

    @NonNull
    Observable<NoValue> confirmAddingClicked();

    void render(MainViewState viewState);
}

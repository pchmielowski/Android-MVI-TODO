package net.chmielowski.mosbytest;

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter;

import io.reactivex.Observable;

final class MainPresenter extends MviBasePresenter<MainView, MainViewState> {
    @Override
    protected void bindIntents() {
        final Observable<MainViewState> intent = intent(MainView::queryChanged)
                .map(MainViewState::new);
        subscribeViewState(intent, MainView::render);
    }
}

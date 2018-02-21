package net.chmielowski.todo;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import io.reactivex.Observable;

public abstract class MviBasePresenterHelper<V extends MvpView, VS> extends MviBasePresenter<V, VS> {
    @Override
    final protected void bindIntents() {
        subscribeViewState(intentStream(), this::render);
    }

    protected abstract void render(final V view, final VS viewState);

    @NonNull
    protected abstract Observable<VS> intentStream();
}

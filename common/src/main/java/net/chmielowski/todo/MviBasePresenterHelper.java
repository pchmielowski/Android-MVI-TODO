package net.chmielowski.todo;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import io.reactivex.Observable;

public abstract class MviBasePresenterHelper<V extends MvpView, VS> extends MviBasePresenter<V, VS> {
    @Override
    final protected void bindIntents() {
        subscribeViewState(intentStream(), renderer());
    }

    protected abstract ViewStateConsumer<V, VS> renderer();

    @NonNull
    protected abstract Observable<VS> intentStream();
}

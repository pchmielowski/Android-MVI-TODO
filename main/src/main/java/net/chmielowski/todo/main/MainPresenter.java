package net.chmielowski.todo.main;

import android.support.annotation.NonNull;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;
import com.hannesdorfmann.mosby3.mvi.MviBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import java.util.function.Function;

import io.reactivex.Observable;

abstract class MviBasePresenterHelper<V extends MvpView, VS> extends MviBasePresenter<V, VS> {
    @Override
    final protected void bindIntents() {
        subscribeViewState(intentStream(), this::render);
    }

    abstract void render(final V view, final VS viewState);

    @NonNull
    abstract Observable<VS> intentStream();
}

@AutoFactory
final class MainPresenter extends MviBasePresenterHelper<MainView, MainViewState> {
    private final Delegate delegate;

    MainPresenter(@Provided Delegate delegate) {
        this.delegate = delegate;
    }

    private <I> Observable<I> intent(final Function<MainView.Intents, Observable<I>> function) {
        return super.intent(view -> function.apply(view.intents()));
    }

    @NonNull
    @Override
    Observable<MainViewState> intentStream() {
        return delegate.createStream(intent(MainView.Intents::textChanged), intent(MainView.Intents::addNewClicked), this.intent(MainView.Intents::textChanged));
    }

    @Override
    void render(final MainView view, final MainViewState viewState) {
        view.renderer().render(viewState);
    }

}


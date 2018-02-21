package net.chmielowski.todo.main;

import android.support.annotation.NonNull;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;

import net.chmielowski.todo.MviBasePresenterHelper;

import java.util.function.Function;

import io.reactivex.Observable;

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
    protected Observable<MainViewState> intentStream() {
        return delegate.createStream(intent(MainView.Intents::textChanged), intent(MainView.Intents::addNewClicked), this.intent(MainView.Intents::textChanged));
    }

    @Override
    protected ViewStateConsumer<MainView, MainViewState> renderer() {
        return (view, viewState) -> view.renderer().render(viewState);
    }

}


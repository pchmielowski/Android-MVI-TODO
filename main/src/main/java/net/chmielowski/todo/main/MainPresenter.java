package net.chmielowski.todo.main;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;
import com.hannesdorfmann.mosby3.mvi.MviBasePresenter;

import java.util.function.Function;

import io.reactivex.Observable;

@AutoFactory
public final class MainPresenter extends MviBasePresenter<MainView, MainViewState> {
    private final Delegate delegate;

    MainPresenter(@Provided Delegate delegate) {
        this.delegate = delegate;
    }

    private <I> Observable<I> intent(final Function<MainView.Intents, Observable<I>> function) {
        return super.intent(view -> function.apply(view.intents()));
    }

    @Override
    protected void bindIntents() {
        final Observable<MainViewState> merge = delegate.createStream(intent(MainView.Intents::textChanged), intent(MainView.Intents::addNewClicked), this.intent(MainView.Intents::textChanged));

        subscribeViewState(merge, (view, viewState) -> view.renderer().render(viewState));
    }

}


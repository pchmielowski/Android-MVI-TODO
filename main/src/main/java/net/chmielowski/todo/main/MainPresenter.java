package net.chmielowski.todo.main;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;
import com.hannesdorfmann.mosby3.mvi.MviBasePresenter;

import net.chmielowski.todo.data.Persistence;

import java.util.function.Function;
import java.util.stream.Collectors;

import io.reactivex.Observable;

@AutoFactory
public final class MainPresenter extends MviBasePresenter<MainView, MainViewState> {
    private final Persistence persistence;

    MainPresenter(@Provided Persistence persistence) {
        this.persistence = persistence;
    }

    private <I> Observable<I> intent(final Function<MainView.Intents, Observable<I>> function) {
        return super.intent(view -> function.apply(view.intents()));
    }

    @Override
    protected void bindIntents() {
        intent(MainView.Intents::textChanged)
                .withLatestFrom(intent(MainView.Intents::textChanged), (noValue, s) -> s)
                .subscribe(persistence::addList);

        final Observable<MainViewState> map = intent(MainView.Intents::addNewClicked)
                .map(__ -> new MainViewState("", false, true, true));

        final Observable<MainViewState> intent = persistence.observe()
                .map(strings -> strings.stream().collect(Collectors.joining(", ")))
                .map(allLists -> new MainViewState(allLists, true, false, false))
                .startWith(MainViewState.initial());
        subscribeViewState(Observable.merge(map, intent), (view, viewState) -> view.renderer().render(viewState));
    }
}


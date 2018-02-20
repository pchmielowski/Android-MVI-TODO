package net.chmielowski.mosbytest;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;
import com.hannesdorfmann.mosby3.mvi.MviBasePresenter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

@AutoFactory
final class MainPresenter extends MviBasePresenter<MainView, MainViewState> {
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

@Singleton
class Persistence {

    @Inject
    Persistence() {
    }

    private LinkedList<String> lists = new LinkedList<>();
    private Subject<Collection<String>> subject = PublishSubject.create();

    void addList(final String name) {
        lists.add(name);
        subject.onNext(lists);
    }

    Observable<Collection<String>> observe() {
        return subject;
    }
}
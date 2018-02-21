package net.chmielowski.todo.main;

import net.chmielowski.todo.data.IPersistence;

import java.util.Collections;

import javax.inject.Inject;

import io.reactivex.Observable;

class Delegate {

    private final IPersistence persistence;

    @Inject
    Delegate(final IPersistence persistence) {
        this.persistence = persistence;
    }

    Observable<MainViewState> createStream(final Observable<String> intent1,
                                           final Observable<NoValue> intent2,
                                           final Observable<String> intent3) {
        intent1.withLatestFrom(intent3, (noValue, s) -> s)
                .subscribe(this.persistence::addList);

        final Observable<MainViewState> map = intent2
                .map(__ -> new MainViewState(Collections.emptyList(), false, true, true));

        final Observable<MainViewState> intent = this.persistence.observe()
                .map(allLists -> new MainViewState(allLists, true, false, false))
                .startWith(MainViewState.initial());

        return Observable.merge(map, intent);
    }
}

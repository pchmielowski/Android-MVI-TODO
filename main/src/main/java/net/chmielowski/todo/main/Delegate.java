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

    Observable<MainViewState> createStream(final Observable<NoValue> confirmAddingList,
                                           final Observable<NoValue> addNewList,
                                           final Observable<String> newListName) {
        confirmAddingList.withLatestFrom(newListName, (noValue, s) -> s)
                .subscribe(persistence::addList);

        final Observable<MainViewState> map = addNewList
                .map(__ -> new MainViewState(Collections.emptyList(), false, true, true));

        final Observable<MainViewState> intent = persistence.observe()
                .map(allLists -> new MainViewState(allLists, true, false, false));

        return Observable.merge(map, intent);
    }
}

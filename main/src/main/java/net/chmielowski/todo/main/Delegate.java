package net.chmielowski.todo.main;

import android.util.Log;

import net.chmielowski.todo.data.IPersistence;

import java.util.Collections;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

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
                .doOnNext(v -> Log.d("pchm", "Delegate::createStream " + v))
                .subscribe(persistence::addList);

        final Observable<MainViewState> map = addNewList
                .map(__ -> new MainViewState(Collections.emptyList(), false, true, true));

        final Observable<MainViewState> intent = persistence.observe()
                .map(allLists -> new MainViewState(allLists, true, false, false));

        return Observable.merge(map, intent)
                .doOnNext(state -> Log.d("pchm", state.toString()));
    }
}

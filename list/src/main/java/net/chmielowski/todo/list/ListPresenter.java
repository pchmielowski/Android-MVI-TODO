package net.chmielowski.todo.list;

import com.google.auto.factory.AutoFactory;
import com.hannesdorfmann.mosby3.mvi.MviBasePresenter;

import io.reactivex.Observable;

@AutoFactory
class ListPresenter extends MviBasePresenter<ListView, ListViewState> {

    private final String name;

    ListPresenter(final long id) {
        name = "#" + id;
    }

    @Override
    protected void bindIntents() {
        final ListViewState state = new ListViewState();
        state.name = name;
        subscribeViewState(Observable.just(state), ListView::render);
    }
}

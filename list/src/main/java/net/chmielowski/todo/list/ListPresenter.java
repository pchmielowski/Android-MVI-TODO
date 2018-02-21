package net.chmielowski.todo.list;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;
import com.hannesdorfmann.mosby3.mvi.MviBasePresenter;

import net.chmielowski.todo.data.IPersistence;

@AutoFactory
class ListPresenter extends MviBasePresenter<ListView, ListViewState> {

    private final long id;
    private final IPersistence persistence;

    ListPresenter(@Provided final IPersistence persistence, final long id) {
        this.id = id;
        this.persistence = persistence;
    }

    @Override
    protected void bindIntents() {
        subscribeViewState(
                persistence.getList(id).map(ListViewState::new),
                ListView::render);
    }
}

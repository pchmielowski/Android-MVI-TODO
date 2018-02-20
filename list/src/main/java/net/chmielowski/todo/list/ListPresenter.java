package net.chmielowski.todo.list;

import com.google.auto.factory.AutoFactory;
import com.hannesdorfmann.mosby3.mvi.MviBasePresenter;

import net.chmielowski.todo.data.Persistence;

@AutoFactory
class ListPresenter extends MviBasePresenter<ListView, ListViewState> {

    private final long id;
    private final Persistence persistence;

    ListPresenter(final long id, final Persistence persistence) {
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

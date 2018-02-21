package net.chmielowski.todo.list;

import android.support.annotation.NonNull;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;

import net.chmielowski.todo.MviBasePresenterHelper;
import net.chmielowski.todo.data.IPersistence;

import io.reactivex.Observable;

@AutoFactory
class ListPresenter extends MviBasePresenterHelper<ListView, ListViewState> {

    private final long id;
    private final IPersistence persistence;

    ListPresenter(@Provided final IPersistence persistence, final long id) {
        this.id = id;
        this.persistence = persistence;
    }

    @NonNull
    @Override
    protected Observable<ListViewState> intentStream() {
        return persistence.getList(id).map(ListViewState::new);
    }

    @Override
    protected ViewStateConsumer<ListView, ListViewState> renderer() {
        return ListView::render;
    }
}

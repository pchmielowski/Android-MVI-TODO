package net.chmielowski.todo.data;

import java.util.Collection;

import io.reactivex.Observable;

public interface IPersistence {
    void addList(String name);

    Observable<Collection<Long>> observe();

    Observable<TaskList> getList(long id);
}

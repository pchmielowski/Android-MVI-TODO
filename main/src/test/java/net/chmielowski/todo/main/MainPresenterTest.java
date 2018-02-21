package net.chmielowski.todo.main;

import net.chmielowski.todo.data.IPersistence;
import net.chmielowski.todo.data.TaskList;

import org.junit.Test;

import java.util.Collection;

import io.reactivex.Observable;

public class MainPresenterTest {

    @Test
    public void name() throws Exception {
        final MainPresenter presenter = new MainPresenter(new IPersistence() {
            @Override
            public void addList(final String name) {

            }

            @Override
            public Observable<Collection<Long>> observe() {
                return null;
            }

            @Override
            public Observable<TaskList> getList(final long id) {
                return null;
            }
        }, new Delegate(persistence));

        presenter.bindIntents();


    }
}
package net.chmielowski.todo.data;

import java.util.Collection;
import java.util.LinkedList;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

@Singleton
class Persistence implements IPersistence {

    @Inject
    Persistence() {
        lists = new LinkedList<>();
        lists.add(0L);
        lists.add(2L);
        lists.add(43L);
        lists.add(543L);
    }


    private LinkedList<Long> lists;
    private Subject<Collection<Long>> subject = PublishSubject.create();

    @Override
    public void addList(final String name) {
//        lists.add(name);
//        subject.onNext(lists);
    }

    @Override
    public Observable<Collection<Long>> observe() {
        return Observable.just(lists);
    }

    @Override
    public Observable<TaskList> getList(final long id) {
        return Observable.just(new TaskList("#" + id));
    }
}

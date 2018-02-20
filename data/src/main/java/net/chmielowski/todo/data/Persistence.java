package net.chmielowski.todo.data;

import java.util.Collection;
import java.util.LinkedList;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

@Singleton
public class Persistence {

    @Inject
    Persistence() {
    }

    private LinkedList<String> lists = new LinkedList<>();
    private Subject<Collection<String>> subject = PublishSubject.create();

    public void addList(final String name) {
        lists.add(name);
        subject.onNext(lists);
    }

    public Observable<Collection<String>> observe() {
        return subject;
    }
}

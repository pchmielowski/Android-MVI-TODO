package net.chmielowski.todo.data;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

@Singleton
public class Persistence {

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

    public void addList(final String name) {
//        lists.add(name);
//        subject.onNext(lists);
    }

    public Observable<Collection<Long>> observe() {
        return Observable.just(lists);
    }
}

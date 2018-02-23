package net.chmielowski.todo.data;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
    }


    private LinkedList<TaskList> lists;
    private Subject<Collection<Long>> subject = PublishSubject.create();

    @Override
    public void addList(final String name) {
        lists.add(new TaskList(name));
        subject.onNext(indexes());
    }

    @Override
    public Observable<Collection<Long>> observe() {
        return subject
                .startWith(Collections.<Long>emptyList());
    }

    private List<Long> indexes() {
        return lists.stream().map(taskList -> taskList.id).collect(Collectors.toList());
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public Observable<TaskList> getList(final long id) {
        return Observable.just(lists.stream()
                .filter(list -> list.id == id)
                .findFirst()
                .get());
    }
}

package net.chmielowski.todo.main;

import net.chmielowski.todo.data.IPersistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collection;
import java.util.Collections;

import io.reactivex.observers.TestObserver;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DelegateTest {

    @SuppressWarnings("WeakerAccess")
    @Mock
    IPersistence persistence;

    @Test
    public void valueFromPersistence() throws Exception {
        final Subject<NoValue> confirmAddingList = PublishSubject.create();
        final Subject<NoValue> addNewList = PublishSubject.create();
        final Subject<String> newListName = PublishSubject.create();

        final Subject<Collection<Long>> persistenceSubject = PublishSubject.create();
        when(persistence.observe())
                .thenReturn(persistenceSubject);

        final TestObserver<MainViewState> test = new Delegate(persistence)
                .createStream(confirmAddingList, addNewList, newListName)
                .test();

        persistenceSubject.onNext(Collections.singletonList(123L));

        test.assertValues(MainViewState.lists(Collections.singletonList(123L)));
    }

    @Test
    public void addingNewList() throws Exception {
        final Subject<NoValue> confirmAddingList = PublishSubject.create();
        final Subject<NoValue> addNewList = PublishSubject.create();
        final Subject<String> newListName = PublishSubject.create();

        final Subject<Collection<Long>> persistenceSubject = PublishSubject.create();
        when(persistence.observe())
                .thenReturn(persistenceSubject);

        final TestObserver<MainViewState> test = new Delegate(persistence)
                .createStream(confirmAddingList, addNewList, newListName)
                .test();

        persistenceSubject.onNext(Collections.emptyList());
        addNewList.onNext(NoValue.INSTANCE);
        newListName.onNext("New list name");
        confirmAddingList.onNext(NoValue.INSTANCE);
        persistenceSubject.onNext(Collections.singletonList(123L));

        test.assertValues(
                MainViewState.lists(Collections.emptyList()),
                MainViewState.addList(),
                MainViewState.lists(Collections.singletonList(123L)));
    }

}
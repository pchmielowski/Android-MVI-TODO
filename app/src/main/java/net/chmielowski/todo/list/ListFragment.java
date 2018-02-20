package net.chmielowski.todo.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.hannesdorfmann.mosby3.mvi.MviFragment;

import net.chmielowski.todo.Injector;

import javax.inject.Inject;


public class ListFragment extends MviFragment<ListView, ListPresenter> implements ListView {

    @Inject
    ListPresenterFactory presenterFactory;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.INSTANCE
                .appComponent()
                .plusMainComponent() // TODO: cache component in Injector
                .activity((AppCompatActivity) getActivity())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    public ListPresenter createPresenter() {
        return presenterFactory.create();
    }

    public static Fragment newInstance(String id) {
        final ListFragment fragment = new ListFragment();
        final Bundle args = new Bundle();
        args.putString("TASK_LIST_ID", id);
        fragment.setArguments(args);
        return fragment;
    }
}

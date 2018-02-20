package net.chmielowski.todo.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.mosby3.mvi.MviFragment;

import net.chmielowski.todo.Injector;
import net.chmielowski.todo.main.MainActivity;

import javax.inject.Inject;


public class ListFragment extends MviFragment<ListView, ListPresenter> implements ListView {

    @Inject
    ListPresenterFactory presenterFactory;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.INSTANCE
                .mainComponent((MainActivity) getActivity())
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
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

    @Override
    public void render(final ListViewState viewState) {
        ((TextView) getView().findViewById(R.id.list_name))
                .setText(viewState.name);
    }
}

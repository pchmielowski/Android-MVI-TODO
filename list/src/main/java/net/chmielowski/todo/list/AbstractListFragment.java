package net.chmielowski.todo.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.mosby3.mvi.MviFragment;

import javax.inject.Inject;

abstract class AbstractListFragment extends MviFragment<ListView, ListPresenter> implements ListView {
    public static final String TASK_LIST_ID = "TASK_LIST_ID";
    @Inject
    ListPresenterFactory presenterFactory;

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
        return presenterFactory.create(getArguments().getLong(TASK_LIST_ID));
    }

    @Override
    public void render(final ListViewState viewState) {
        ((TextView) getView().findViewById(R.id.list_name))
                .setText(viewState.name);
    }
}

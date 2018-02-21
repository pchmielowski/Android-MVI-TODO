package net.chmielowski.todo.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.mosby3.mvi.MviFragment;

import net.chmielowski.todo.common.ViewCache;
import net.chmielowski.todo.common.ViewCacheFactory;

import javax.inject.Inject;

abstract class AbstractListFragment extends MviFragment<ListView, ListPresenter>
        implements ListView {
    static final String TASK_LIST_ID = "TASK_LIST_ID";

    @Inject
    ListPresenterFactory presenterFactory;

    @Inject
    TasksAdapter adapter;

    @Inject
    ViewCacheFactory cacheFactory;
    private ViewCache cache;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cache = cacheFactory.create(view);
    }

    @SuppressWarnings("ConstantConditions")
    @NonNull
    @Override
    public ListPresenter createPresenter() {
        return presenterFactory.create(getArguments().getLong(TASK_LIST_ID));
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void render(final ListViewState viewState) {
        adapter.replace(viewState.list.tasks);
        cache.<TextView>findViewById(R.id.list_name)
                .setText(viewState.list.name);
    }
}

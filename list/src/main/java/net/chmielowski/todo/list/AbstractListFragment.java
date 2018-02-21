package net.chmielowski.todo.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.mosby3.mvi.MviFragment;

import javax.inject.Inject;

abstract class AbstractListFragment extends MviFragment<ListView, ListPresenter>
        implements ListView {
    static final String TASK_LIST_ID = "TASK_LIST_ID";

    @Inject
    ListPresenterFactory presenterFactory;

    @Inject
    TasksAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
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
        ((TextView) cachingFindView(R.id.list_name))
                .setText(viewState.list.name);
    }

    final SparseArray<View> cache = new SparseArray<>();

    private <T extends View> T cachingFindView(final int id) {
        final T cached = (T) cache.get(id);
        if (cached != null) {
            return cached;
        }
        final T found = getView().findViewById(id);
        cache.put(id, found);
        return found;
    }

}

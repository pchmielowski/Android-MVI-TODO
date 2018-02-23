package net.chmielowski.todo.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvi.MviFragment;

import net.chmielowski.todo.list.databinding.FragmentListBinding;

import javax.inject.Inject;

abstract class AbstractListFragment extends MviFragment<ListView, ListPresenter>
        implements ListView {
    static final String TASK_LIST_ID = "TASK_LIST_ID";

    @Inject
    ListPresenterFactory presenterFactory;

    @Inject
    TasksAdapter adapter;

    private FragmentListBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
//        binding = FragmentListBinding.inflate(inflater,container,false);
        binding = FragmentListBinding.inflate(inflater);
        return binding.getRoot();
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
        binding.listName.setText(viewState.list.name);
    }
}

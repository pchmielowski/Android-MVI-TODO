package net.chmielowski.todo.main;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.chmielowski.todo.ActivityScope;

import java.util.List;

import javax.inject.Inject;

@ActivityScope
class ListsAdapter extends FragmentPagerAdapter {
    private List<MainViewState.TaskList> elements;

    @Inject
    ListsAdapter(FragmentManager manager) {
        super(manager);
    }

    @NonNull
    @Override
    public Fragment getItem(final int position) {
        final MainViewState.TaskList element = elements.get(position);
        // TODO: create Fragment
        return null;
    }

    @Override
    public int getCount() {
        return elements.size();
    }

    void bind(final List<MainViewState.TaskList> lists) {
        this.elements = lists;
        notifyDataSetChanged();
    }
}

package net.chmielowski.todo.main;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.chmielowski.todo.ActivityScope;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

@ActivityScope
class ListsAdapter extends FragmentPagerAdapter {

    private List<Long> elements = new LinkedList<>();

    private final ListFragmentFactory fragmentFactory;

    @Inject
    ListsAdapter(final FragmentManager manager, final ListFragmentFactory factory) {
        super(manager);
        this.fragmentFactory = factory;
    }

    @NonNull
    @Override
    public Fragment getItem(final int position) {
        return fragmentFactory.create(elements.get(position));
    }

    @Override
    public int getCount() {
        return elements.size();
    }

    void bind(final List<Long> lists) {
        this.elements = lists;
        notifyDataSetChanged();
    }
}

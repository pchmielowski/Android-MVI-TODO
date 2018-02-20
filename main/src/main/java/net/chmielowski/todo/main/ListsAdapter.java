package net.chmielowski.todo.main;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.chmielowski.todo.ActivityScope;

import javax.inject.Inject;

@ActivityScope
class ListsAdapter extends FragmentPagerAdapter {
    @Inject
    ListsAdapter(FragmentManager manager) {
        super(manager);
    }

    @NonNull
    @Override
    public Fragment getItem(final int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}

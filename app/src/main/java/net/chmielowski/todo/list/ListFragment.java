package net.chmielowski.todo.list;

import android.os.Bundle;

import net.chmielowski.todo.Injector;
import net.chmielowski.todo.main.ListFragmentFactory;
import net.chmielowski.todo.main.MainActivity;

import dagger.Module;
import dagger.Provides;

public final class ListFragment extends AbstractListFragment {

    @Module
    public abstract static class FactoryModule {
        @Provides
        static ListFragmentFactory provideFactory() {
            return id -> {
                final AbstractListFragment fragment = new ListFragment();
                final Bundle args = new Bundle();
                args.putLong(TASK_LIST_ID, id);
                fragment.setArguments(args);
                return fragment;
            };
        }
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        Injector.INSTANCE
                .mainComponent((MainActivity) getActivity())
                .inject(this);
        super.onCreate(savedInstanceState);
    }
}

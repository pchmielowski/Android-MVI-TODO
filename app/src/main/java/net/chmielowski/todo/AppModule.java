package net.chmielowski.todo;

import net.chmielowski.todo.list.ListFragment;
import net.chmielowski.todo.main.ListFragmentFactory;

import dagger.Module;
import dagger.Provides;

@Module
abstract class AppModule {
    @Provides
    static ListFragmentFactory provideFragmentFactory() {
        return ListFragment::newInstance;
    }
}

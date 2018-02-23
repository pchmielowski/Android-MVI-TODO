package net.chmielowski.todo.main;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;

@Module
abstract class MainModule {
    @Provides
    static FragmentManager provideFragmentManager(final AppCompatActivity activity) {
        return activity.getSupportFragmentManager();
    }
}

package net.chmielowski.todo.main;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
abstract class MainModule {
    @Binds
    abstract MainView.Intents bindIntents(IntentsImpl impl);

    @Binds
    abstract MainView.Renderer bindRenderer(RendererImpl impl);

    @Provides
    static FragmentManager provideFragmentManager(AppCompatActivity activity) {
        return activity.getSupportFragmentManager();
    }
}

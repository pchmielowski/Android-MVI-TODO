package net.chmielowski.todo.main;

import android.support.v7.app.AppCompatActivity;

import net.chmielowski.todo.ActivityScope;
import net.chmielowski.todo.list.ListFragment;

import dagger.BindsInstance;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    @Subcomponent.Builder
    interface Builder {
        MainComponent build();

        @BindsInstance
        Builder activity(AppCompatActivity activity);
    }

    void inject(MainActivity activity);

    void inject(ListFragment fragment);
}

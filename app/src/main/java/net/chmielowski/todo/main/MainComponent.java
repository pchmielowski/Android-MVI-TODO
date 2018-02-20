package net.chmielowski.todo.main;

import android.app.Activity;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    @Subcomponent.Builder
    interface Builder {
        MainComponent build();

        @BindsInstance
        Builder activity(Activity activity);
    }

    void inject(MainActivity activity);
}

package net.chmielowski.todo;

import android.support.annotation.Nullable;

import net.chmielowski.todo.main.MainActivity;
import net.chmielowski.todo.main.MainComponent;

public enum Injector {
    INSTANCE;

    private AppComponent appComponent;

    @Nullable
    private MainComponent mainComponent;

    public MainComponent mainComponent(final MainActivity activity) {
        // TODO: double check
        if (mainComponent == null) {
            mainComponent = appComponent
                    .plusMainComponent()
                    .activity(activity)
                    .build();
        }
        return mainComponent;
    }

    public void releaseMainComponent() {
        mainComponent = null;
    }

    void setAppComponent(final AppComponent component) {
        this.appComponent = component;
    }
}

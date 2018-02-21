package net.chmielowski.todo;

import android.app.Application;

public final class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Injector.INSTANCE.setAppComponent(DaggerAppComponent.create());
    }
}

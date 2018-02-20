package net.chmielowski.todo;

import android.app.Application;

import net.chmielowski.mosbytest.DaggerAppComponent;

public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Injector.INSTANCE.setAppComponent(DaggerAppComponent.create());
    }
}

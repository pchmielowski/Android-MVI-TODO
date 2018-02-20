package net.chmielowski.mosbytest;

import android.app.Application;

public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Injector.INSTANCE.setAppComponent(DaggerAppComponent.create());
    }
}

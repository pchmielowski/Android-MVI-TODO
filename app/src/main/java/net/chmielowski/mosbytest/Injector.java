package net.chmielowski.mosbytest;

public enum Injector {
    INSTANCE;
    private AppComponent appComponent;

    void setAppComponent(AppComponent component) {
        this.appComponent = component;
    }

    public AppComponent appComponent() {
        return appComponent;
    }
}

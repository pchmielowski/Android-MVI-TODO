package net.chmielowski.mosbytest;

enum Injector {
    INSTANCE;
    private AppComponent appComponent;

    void setAppComponent(AppComponent component) {
        this.appComponent = component;
    }

    AppComponent appComponent() {
        return appComponent;
    }
}

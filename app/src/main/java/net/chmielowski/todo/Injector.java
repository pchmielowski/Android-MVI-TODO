package net.chmielowski.todo;

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

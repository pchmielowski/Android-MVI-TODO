package net.chmielowski.mosbytest;

import net.chmielowski.todo.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface AppComponent {
    void inject(MainActivity activity);
}

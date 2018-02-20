package net.chmielowski.todo;

import net.chmielowski.todo.main.MainComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    MainComponent.Builder plusMainComponent();
}

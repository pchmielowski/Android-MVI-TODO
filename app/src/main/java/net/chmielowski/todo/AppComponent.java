package net.chmielowski.todo;

import net.chmielowski.todo.list.ListFragment;
import net.chmielowski.todo.main.MainComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ListFragment.FactoryModule.class)
public interface AppComponent {

    MainComponent.Builder plusMainComponent();
}

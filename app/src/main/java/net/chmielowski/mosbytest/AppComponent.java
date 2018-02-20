package net.chmielowski.mosbytest;

import net.chmielowski.lib.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface AppComponent {
    void inject(MainActivity activity);
}

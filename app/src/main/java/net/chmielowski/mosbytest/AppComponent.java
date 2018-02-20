package net.chmielowski.mosbytest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
interface AppComponent {
    void inject(MainActivity activity);
}

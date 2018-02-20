package net.chmielowski.mosbytest;

import dagger.Component;

@Component
interface AppComponent {
    void inject(MainActivity activity);
}

package net.chmielowski.todo.main;

import dagger.Binds;
import dagger.Module;

@Module
abstract class MainModule {
    @Binds
    abstract MainView.Intents bindIntents(IntentsImpl impl);

    @Binds
    abstract MainView.Renderer bindRenderer(RendererImpl impl);
}

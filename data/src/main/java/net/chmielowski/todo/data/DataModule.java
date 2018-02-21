package net.chmielowski.todo.data;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataModule {
    @Binds
    abstract IPersistence bindPersistence(Persistence impl);
}

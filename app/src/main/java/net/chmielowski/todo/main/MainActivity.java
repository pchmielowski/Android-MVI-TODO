package net.chmielowski.todo.main;

import android.os.Bundle;

import net.chmielowski.todo.Injector;

public final class MainActivity extends AbstractMainActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        Injector.INSTANCE.mainComponent(this)
                .inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Injector.INSTANCE.releaseMainComponent();
    }
}

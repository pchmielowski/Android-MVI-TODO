package net.chmielowski.todo.main;

import android.support.v4.app.Fragment;

public interface ListFragmentFactory {
    Fragment create(Long id);
}

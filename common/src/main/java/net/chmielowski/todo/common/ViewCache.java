package net.chmielowski.todo.common;

import android.util.SparseArray;
import android.view.View;

import com.google.auto.factory.AutoFactory;

@AutoFactory
public class ViewCache {
    private final SparseArray<View> cache = new SparseArray<>();
    private final View root;

    ViewCache(final View root) {
        this.root = root;
    }

    public <T extends View> T findViewById(final int id) {
        final T cached = (T) cache.get(id);
        if (cached != null) {
            return cached;
        }
        final T found = root.findViewById(id);
        cache.put(id, found);
        return found;
    }
}

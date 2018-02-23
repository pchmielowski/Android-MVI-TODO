package net.chmielowski.todo.main;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class MainViewState {
    final boolean addNewVisible;
    final boolean confirmVisible;
    final boolean enterNameVisible;

    final List<Long> lists;

    MainViewState(final Collection<Long> allLists, final boolean addNewVisible,
                  final boolean confirmVisible, final boolean enterNameVisible) {
        this.lists = new ArrayList<>(allLists);
        this.addNewVisible = addNewVisible;
        this.confirmVisible = confirmVisible;
        this.enterNameVisible = enterNameVisible;
    }

    static MainViewState initial() {
        return new MainViewState(Collections.emptyList(), true, false, false);
    }

    @NonNull
    public static MainViewState lists(List<Long> allLists) {
        return new MainViewState(allLists, true, false, false);
    }

    @NonNull
    public static MainViewState addList() {
        return new MainViewState(Collections.emptyList(), false, true, true);
    }
}

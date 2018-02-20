package net.chmielowski.todo.main;

import java.util.ArrayList;
import java.util.List;

class MainViewState {
    final String allLists;
    final boolean addNewVisible;
    final boolean confirmVisible;
    final boolean enterNameVisible;

    final List<TaskList> lists = new ArrayList<>();

    MainViewState(final String allLists, final boolean addNewVisible, final boolean confirmVisible, final boolean enterNameVisible) {

        this.allLists = allLists;
        this.addNewVisible = addNewVisible;
        this.confirmVisible = confirmVisible;
        this.enterNameVisible = enterNameVisible;
    }

    static MainViewState initial() {
        return new MainViewState("", true, false, false);
    }

    class TaskList {
        String id;
    }
}

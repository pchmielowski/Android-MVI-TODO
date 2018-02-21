package net.chmielowski.todo.list;

import net.chmielowski.todo.data.TaskList;

// Currently this class wraps SQL entity. Consider using separate DTO or living object
class ListViewState {
    final TaskList list;

    ListViewState(final TaskList list) {
        this.list = list;
    }
}

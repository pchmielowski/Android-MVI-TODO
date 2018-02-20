package net.chmielowski.todo.list;

import net.chmielowski.todo.data.TaskList;

class ListViewState {
    final String name;

    ListViewState(final TaskList taskList) {
        name = taskList.name;
    }
}

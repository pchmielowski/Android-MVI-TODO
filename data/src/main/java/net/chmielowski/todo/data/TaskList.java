package net.chmielowski.todo.data;

import java.util.Collection;
import java.util.Collections;

public class TaskList {
    public final String name;
    public final Collection<Task> tasks = Collections.emptyList();

    TaskList(final String name) {
        this.name = name;
    }
}

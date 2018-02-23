package net.chmielowski.todo.data;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

public class TaskList {
    public final String name;
    public final Collection<Task> tasks = Collections.emptyList();
    final long id = UUID.randomUUID().getLeastSignificantBits();

    TaskList(final String name) {
        this.name = name;
    }
}

package net.chmielowski.todo.data;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;


public class TaskList {
    public final String name;
    public final Collection<Task> tasks;
    final long id = UUID.randomUUID().getLeastSignificantBits();

    TaskList(final String name) {
        this.name = name;
        tasks = Arrays.asList(
                new Task(name + " 1", new Date().getTime() % 2 == 0),
                new Task(name + " 2", new Date().getTime() % 2 == 0),
                new Task(name + " 3", new Date().getTime() % 2 == 0),
                new Task(name + " 4", new Date().getTime() % 2 == 0)
        );
    }
}

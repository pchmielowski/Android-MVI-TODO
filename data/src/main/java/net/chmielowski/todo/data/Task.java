package net.chmielowski.todo.data;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public final class Task {
    public final String name;
    public final boolean done;

    Task(final String name, final boolean done) {
        this.name = name;
        this.done = done;
    }
}

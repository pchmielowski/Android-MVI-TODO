package net.chmielowski.todo.list;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import net.chmielowski.todo.data.Task;

import java.util.Collection;
import java.util.LinkedList;

class TasksAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Collection<Task> tasks = new LinkedList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    void replace(final Collection<Task> tasks) {
        // TODO: use DiffUtil
        this.tasks.clear();
        this.tasks.addAll(tasks);
        notifyDataSetChanged();
    }
}

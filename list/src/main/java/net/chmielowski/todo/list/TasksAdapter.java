package net.chmielowski.todo.list;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import net.chmielowski.todo.data.Task;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import static android.view.LayoutInflater.from;
import static net.chmielowski.todo.list.databinding.ItemTaskBinding.inflate;

class TasksAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<Task> tasks = new LinkedList<>();

    @Inject
    TasksAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new ViewHolder(inflate(from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.bind(tasks.get(position));
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


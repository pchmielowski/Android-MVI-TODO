package net.chmielowski.todo.list;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.chmielowski.todo.data.Task;
import net.chmielowski.todo.list.databinding.ItemTaskBinding;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

class TasksAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Task> tasks = new LinkedList<>();

    @Inject
    TasksAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final ItemTaskBinding binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
//        ItemTaskBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder) holder).binding.name.setText(tasks.get(position).name);
        ((ViewHolder) holder).binding.done.setChecked(tasks.get(position).done);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    void replace(final Collection<Task> tasks) {
        Log.d("pchm", "TasksAdapter::replace " + tasks);
        // TODO: use DiffUtil
        this.tasks.clear();
        this.tasks.addAll(tasks);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ItemTaskBinding binding;

        ViewHolder(final ItemTaskBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

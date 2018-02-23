package net.chmielowski.todo.list;

import android.support.v7.widget.RecyclerView;

import net.chmielowski.todo.data.Task;
import net.chmielowski.todo.list.databinding.ItemTaskBinding;

final class ViewHolder extends RecyclerView.ViewHolder {
    private final ItemTaskBinding binding;

    ViewHolder(final ItemTaskBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(final Task task) {
        binding.name.setText(task.name);
        binding.done.setChecked(task.done);
    }
}

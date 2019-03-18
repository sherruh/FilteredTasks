package com.example.filteredtasks.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.filteredtasks.R;
import com.example.filteredtasks.models.Task;
import com.example.filteredtasks.viewholders.TaskViewHolder;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private ArrayList<Task> taskList;

    public TaskAdapter(ArrayList<Task> taskList){
        this.taskList=taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_holder_task, viewGroup, false);
        TaskViewHolder taskViewHolder=new TaskViewHolder(view);
        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder taskViewHolder, int i) {
        taskViewHolder.onBind(taskList.get(i));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}

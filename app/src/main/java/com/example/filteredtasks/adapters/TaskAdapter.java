package com.example.filteredtasks.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.filteredtasks.R;
import com.example.filteredtasks.interfaces.IOnClickListener;
import com.example.filteredtasks.models.Task;
import com.example.filteredtasks.viewholder.TaskViewHolder;


import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder>  {

    ArrayList<Task> tasks;
    IOnClickListener miOnClickListener;

    public TaskAdapter(ArrayList<Task> tasks, IOnClickListener iOnClickListener){
        this.tasks=tasks;
        miOnClickListener=iOnClickListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.view_holder_task,viewGroup,false);
        TaskViewHolder vh=new TaskViewHolder(v,miOnClickListener);
        Log.d("TaskManagerLog","created "+i);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder taskViewHolder, int i) {
        Log.d("TaskManagerLog","Size of list: " +String.valueOf( tasks.size()));
        Log.d("TaskManagerLog","onBind "+i);
        if(tasks.size()>0){
            taskViewHolder.onBind(tasks.get(i%tasks.size()),i);
        }
    }

    @Override
    public int getItemCount() {
        return tasks.size();
        //return tasks.size()*999;
    }
}

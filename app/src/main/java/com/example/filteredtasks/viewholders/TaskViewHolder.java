package com.example.filteredtasks.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.filteredtasks.R;
import com.example.filteredtasks.models.Task;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle;
    private TextView tvMessage;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle=itemView.findViewById(R.id.vh_task_title);
        tvMessage=itemView.findViewById(R.id.vh_task_message);
    }

    public void onBind(Task task){
        tvTitle.setText(task.getName());
        tvMessage.setText(task.getMessage());
    }
}

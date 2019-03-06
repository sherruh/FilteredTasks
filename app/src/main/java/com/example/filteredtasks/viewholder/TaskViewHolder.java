package com.example.filteredtasks.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filteredtasks.R;
import com.example.filteredtasks.interfaces.IOnClickListener;
import com.example.filteredtasks.models.Task;
import com.squareup.picasso.Picasso;

public class TaskViewHolder extends RecyclerView.ViewHolder  {
    TextView taskTitle;
    TextView taskDescription;
    ImageView taskImage;
    int taskId;
    private IOnClickListener miOnClickListener;

    public TaskViewHolder(@NonNull View itemView, IOnClickListener iOnClickListener) {
        super(itemView);
        taskTitle=itemView.findViewById(R.id.vh_task_Title);
        taskDescription=itemView.findViewById(R.id.textOfTask);
        taskImage=itemView.findViewById(R.id.imageView);
        miOnClickListener=iOnClickListener;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miOnClickListener.clickOnTask(taskId);
            }
        });
    }

    public void onBind(Task task, int taskId){
        taskDescription.setText(task.getMessage());
        taskTitle.setText(task.getMessage());
        Picasso.get().load("http://i.imgur.com/"+ String.valueOf(task.getMessage())+".jpg").
                resize(150, 150)
                .centerCrop().into(taskImage);

        Log.d("TaskManagerLog","Image URL:  http://i.imgur.com/"+
                String.valueOf(task.getMessage())+".jpg");
        this.taskId=taskId;
    }

}

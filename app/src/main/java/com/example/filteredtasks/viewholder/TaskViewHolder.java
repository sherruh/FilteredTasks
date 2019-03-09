package com.example.filteredtasks.viewholder;

import android.annotation.SuppressLint;
import android.arch.lifecycle.AndroidViewModel;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
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
    CheckBox checkBoxInWork;
    CheckBox checkBoxDone;
    Task task;
    int taskId;
    private IOnClickListener miOnClickListener;

    public TaskViewHolder(@NonNull final View itemView, IOnClickListener iOnClickListener) {
        super(itemView);
        taskTitle=itemView.findViewById(R.id.vh_task_Title);
        taskDescription=itemView.findViewById(R.id.textOfTask);
        taskImage=itemView.findViewById(R.id.imageView);
        miOnClickListener=iOnClickListener;
        checkBoxInWork=itemView.findViewById(R.id.check_bx_in_work);
        checkBoxInWork.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                setColorInWork(checkBoxInWork.isChecked());
            }
        });
        checkBoxDone=itemView.findViewById(R.id.check_bx_done);
        checkBoxDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setColorDone(checkBoxDone.isChecked());
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miOnClickListener.clickOnTask(taskId);
            }
        });
    }

    public void onBind(Task task, int taskId){
        this.task=task;
        taskDescription.setText(task.getMessage());
        taskTitle.setText(task.getName());
        checkBoxInWork.setChecked(task.isInWork());
        checkBoxDone.setChecked(task.isDone());
        setColorInWork(task.isInWork());
        setColorDone(task.isDone());
        Picasso.get().load("http://i.imgur.com/"+ String.valueOf(task.getMessage())+".jpg").
                resize(150, 150)
                .centerCrop().into(taskImage);
        Log.d("TaskManagerLog","Image URL:  http://i.imgur.com/"+
                String.valueOf(task.getMessage())+".jpg");
        this.taskId=taskId;
    }

    private void setColorDone(boolean done) {
        task.setDone(done);
        if(done){
            checkBoxInWork.setClickable(false);
            itemView.setBackgroundResource(R.color.colorGreen);
        }else {
            checkBoxInWork.setClickable(true);
            setColorInWork(task.isInWork());
        }
    }

    private void setColorInWork(boolean inWork){
        task.setInWork(inWork);
        if(inWork){
            itemView.setBackgroundResource(R.color.colorYellow);
        }else {
            itemView.setBackgroundResource(R.color.colorOrange);
        }
    }
}

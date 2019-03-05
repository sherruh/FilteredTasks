package com.example.filteredtasks.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filteredtasks.R;
import com.example.filteredtasks.models.Task;
import com.squareup.picasso.Picasso;

public class TaskViewFragment extends Fragment {

    TextView taskTitle;
    TextView taskDescription;
    ImageView taskImage;
    Task task;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_view_task,container,false);
        taskTitle=view.findViewById(R.id.task_title_text_view_opened);
        taskDescription=view.findViewById(R.id.task_description_text_view_opened);
        taskImage=view.findViewById(R.id.imageView_opened);
        initViewTask(task);
        return view;
    }

    private void initViewTask(Task task) {
        taskTitle.setText(task.getMessage());
        taskDescription.setText(task.getMessage());
        Picasso.get().load("http://i.imgur.com/"+ String.valueOf(task.getMessage())+".jpg").
                resize(1000, 1000)
                .centerCrop().into(taskImage);
    }

    public void setTask(Task task){
        this.task=task;
    }
}

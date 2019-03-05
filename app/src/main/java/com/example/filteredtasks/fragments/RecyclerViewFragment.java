package com.example.filteredtasks.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.filteredtasks.R;
import com.example.filteredtasks.adapters.TaskAdapter;
import com.example.filteredtasks.interfaces.IOnClickListener;
import com.example.filteredtasks.models.Task;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment  {
    RecyclerView recyclerViewTasks;
    RecyclerView.LayoutManager recycleLayoutManager;
    TaskAdapter taskAdapter;
    Button buttonAddTask;
    ArrayList<Task> tasks;
    View view;
    IOnClickListener miOnClickListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_recyclerview,container,false);
        initRecycleView(view);
        return view;
    }

    private void initRecycleView(View view) {
        recyclerViewTasks= (RecyclerView) view.findViewById(R.id.recyclerTasks);
        recycleLayoutManager=new LinearLayoutManager(getActivity());
        recyclerViewTasks.setLayoutManager(recycleLayoutManager);
        taskAdapter=new TaskAdapter(tasks,miOnClickListener );
        recyclerViewTasks.setAdapter(taskAdapter);
        recyclerViewTasks.setItemAnimator(new DefaultItemAnimator());

    }

    public void setTasks() {
       tasks=new ArrayList<>();
        tasks.add(new Task(false,false,"Problem"));
        tasks.add(new Task(false,false,"Problem"));
        tasks.add(new Task(false,false,"Problem"));
        //tasks.add(new Task("Task 4","Text of task",4));
        //tasks.add(new Task("Task 5","Text of task",5));
        //tasks.add(new Task("Task 6","Text of task",6));
        //tasks.add(new Task("Task 7","Text of task",7));
        //tasks.add(new Task("Task 8","Text of task",8));
        //tasks.add(new Task("Task 9","Text of task",9));
        //tasks.add(new Task("Task 10","Text of task",10));
        //tasks.add(new Task("Task 11","Text of task",11));
        //tasks.add(new Task("Task 12","Text of task",12));
        //tasks.add(new Task("Task 13","Text of task",13));
        //tasks.add(new Task("Task 14","Text of task",14));
        //tasks.add(new Task("Task 15","Text of task",15));
        //tasks.add(new Task("Task 16","Text of task",16));
        //tasks.add(new Task("Task 17","Text of task",17));
        //tasks.add(new Task("Task 18","Text of task",18));
        //tasks.add(new Task("Task 19","Text of task",19));
        //tasks.add(new Task("Task 20","Text of task",20));
    }

    public void addTask(Task task){
        tasks.add(task);
        initRecycleView(view);
    }

    public void setIOnClicklistener(IOnClickListener iOnClicklistener){
        miOnClickListener=iOnClicklistener;
    }

    public Task getTask(int taskId){
        return tasks.get(taskId);
    }


}

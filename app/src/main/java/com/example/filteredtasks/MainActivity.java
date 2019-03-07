package com.example.filteredtasks;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.filteredtasks.fragments.RecyclerViewFragment;
import com.example.filteredtasks.fragments.TaskViewFragment;
import com.example.filteredtasks.interfaces.IOnClickListener;
import com.example.filteredtasks.models.Task;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnClickListener {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    RecyclerViewFragment recyclerViewFragment;
    TaskViewFragment taskViewFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        recyclerViewFragment=new RecyclerViewFragment();
        recyclerViewFragment.setTasks();
        recyclerViewFragment.setIOnClicklistener(this);
        fragmentTransaction.add(R.id.frame_layout,recyclerViewFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void clickOnTask(int taskId) {
        Log.d("TaskManagerLog","Clicked on "+taskId);
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.remove(recyclerViewFragment);
        fragmentTransaction.commit();
        fragmentTransaction=fragmentManager.beginTransaction();
        taskViewFragment=new TaskViewFragment();
        taskViewFragment.setTask(recyclerViewFragment.getTask(taskId));
        fragmentTransaction.add(R.id.frame_layout,taskViewFragment);
        fragmentTransaction.addToBackStack(null).commit();
    }


}

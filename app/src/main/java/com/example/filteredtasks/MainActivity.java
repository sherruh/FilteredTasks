package com.example.filteredtasks;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.filteredtasks.models.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Task> tasks;
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        RecyclerViewFragment recyclerViewFragment;
        NewTaskFragment newTaskFragment;
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
    }
}

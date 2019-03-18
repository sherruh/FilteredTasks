package com.example.filteredtasks.fragments;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.filteredtasks.R;
import com.example.filteredtasks.adapters.TaskAdapter;
import com.example.filteredtasks.models.Task;
import com.example.filteredtasks.services.JSonWorker;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class RecyclerFragment extends Fragment {

    RecyclerView recyclerViewTaskList;
    TaskAdapter taskAdapter;
    ArrayList<Task> taskList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_task_list,container,false);
        taskList=setTasks();
        initRecycler(view,taskList);
        return view;
    }

    void initRecycler(View view, ArrayList<Task> taskList){
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        taskAdapter=new TaskAdapter(taskList);
        recyclerViewTaskList=view.findViewById(R.id.recycler_task_list);
        recyclerViewTaskList.setAdapter(taskAdapter);
        recyclerViewTaskList.setLayoutManager(layoutManager);
    }

    ArrayList<Task> setTasks(){
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        try {
            JSonWorker jSonWorker=new JSonWorker();
            return jSonWorker.getTaskList();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

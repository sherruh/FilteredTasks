package com.example.filteredtasks.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.filteredtasks.R;
import com.example.filteredtasks.adapters.TaskAdapter;
import com.example.filteredtasks.interfaces.IOnClickListener;
import com.example.filteredtasks.models.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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

    public void createJSondata(){
        JSONObject jObject = new JSONObject();
        try
        {
            JSONArray jArray = new JSONArray();
            for (Task task : tasks)
            {
                JSONObject studentJSON = new JSONObject();
                studentJSON.put("", task.));
                studentJSON.put("age", task.);
                jArray.put(studentJSON);
            }
            jObject.put("StudentList", jArray);
        } catch (JSONException jse) {

        }
        Log.d("MyAppLog");
    }

}

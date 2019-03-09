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
import com.example.filteredtasks.enums.ProblemType;
import com.example.filteredtasks.enums.Region;
import com.example.filteredtasks.enums.Technology;
import com.example.filteredtasks.interfaces.IOnClickListener;
import com.example.filteredtasks.models.Task;
import com.example.filteredtasks.serialyzers.JSonWorker;

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
    JSonWorker jSonWorker;

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
       tasks.add(new Task(false,false,"Nrn_40000","Traffic 10%", ProblemType.EMERGENCY, Technology.UMTS, Region.CHUY));
       tasks.add(new Task(false,false,"Nrn_40001","Traffic 70%Traffic 70%Traffic 70%Traffic 70%", ProblemType.EMERGENCY, Technology.GSM, Region.CHUY));
       tasks.add(new Task(false,true,"Nrn_40001","Traffic 70%", ProblemType.EMERGENCY, Technology.GSM, Region.CHUY));
       tasks.add(new Task(true,false,"Nrn_40001","Traffic 60%", ProblemType.VOICE, Technology.GSM, Region.CHUY));
       tasks.add(new Task(true,true,"Nrn_40001","Traffic 70%", ProblemType.TRAFFIC, Technology.GSM, Region.CHUY));
       jSonWorker=new JSonWorker();
       jSonWorker.readJSondata(tasks);
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

package com.example.filteredtasks.serialyzers;

import com.example.filteredtasks.models.Task;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;


public class ArrayListForSerialyzer extends ArrayList<Task> implements Serializable {
    public ArrayListForSerialyzer(){}

    public ArrayList<Task> getEmployee() {
        return this;
    }

}
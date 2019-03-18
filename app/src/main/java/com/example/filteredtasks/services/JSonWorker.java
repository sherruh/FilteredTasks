package com.example.filteredtasks.services;


import android.util.Log;

import com.example.filteredtasks.models.Task;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class JSonWorker {

    public JSonWorker() {

    }

    public ArrayList<Task> getTaskList()throws IOException, JSONException {
        String url = "https://my-json-server.typicode.com/sherruh/DBJSonFilteredTasks/db";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        Gson gson = new Gson();
        JSONArray jsonArray = new JSONObject(response.toString()).getJSONArray("TaskList");
        String jsonTaskList = jsonArray.toString();
        Type listType = new TypeToken<List<Task>>(){}.getType();
        ArrayList<Task> taskList=gson.fromJson(jsonTaskList, listType);
        Log.d("MyApp", String.valueOf(taskList.size()));
        return taskList;
    }
}

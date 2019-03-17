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
import java.util.List;


public class JSonWorker {

    public JSonWorker() throws IOException, JSONException {
        String url = "https://my-json-server.typicode.com/sherruh/DBJSonFilteredTasks/db";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        //con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Gson gson = new Gson();
        JSONArray myResponse = new JSONObject(response.toString()).getJSONArray("TaskList");
        String jsonTaskList = myResponse.toString();
        Type listType = new TypeToken<List<Task>>(){}.getType();
        Log.d("MyApp", gson.fromJson(jsonTaskList, listType).toString());

    }
}

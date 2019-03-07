package com.example.filteredtasks.serialyzers;

import android.os.Environment;
import android.util.Log;

import com.example.filteredtasks.enums.ProblemType;
import com.example.filteredtasks.enums.Region;
import com.example.filteredtasks.enums.Technology;
import com.example.filteredtasks.models.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

public class JSonWorker {

    public void createJSondata(ArrayList<Task> tasks){
        JSONObject jObject = new JSONObject();
        try
        {
            JSONArray jArray = new JSONArray();
            for (Task task : tasks)
            {
                JSONObject taskJSON = new JSONObject();
                taskJSON.put("inWork", task.isInWork());
                taskJSON.put("done", task.isDone());
                taskJSON.put("name", task.getName());
                taskJSON.put("message", task.getMessage());
                taskJSON.put("problemType", task.getProblemType());
                taskJSON.put("technology", task.getTechnology());
                taskJSON.put("region", task.getRegion());
                jArray.put(taskJSON);
            }
            jObject.put("TaskList", jArray);
            Log.d("MyAppLog",jObject.toString());
        } catch (JSONException jse) {

        }

        try {
            Log.d("MyAppLog","File is written");

            Writer output = null;
            File file = new File( "1.json");
            output = new BufferedWriter(new FileWriter(file));
            output.write(jObject.toString());
            output.close();

            Log.d("MyAppLog","File is written");

        } catch (Exception e) {
            Log.d("MyAppLog",e.getMessage());
        }

    }

    public void readJSondata(ArrayList<Task> tasks){


        Object obj = null;
        try {

            BufferedReader reader=new BufferedReader(new FileReader("/storage/emulated/0/"+ "/TaskList.json"));

            JSONObject jsonObject = new JSONObject(reader.readLine());
            reader.close();
            jsonObject.get("TaskList");

            Log.d("MyAppLog",jsonObject.get("TaskList").toString());
            JSONArray jsonArray = (JSONArray) jsonObject.get("TaskList");

            for(int i=0;i<jsonArray.length();i++){
                JSONObject ob=jsonArray.getJSONObject(i);
                tasks.add(new Task(ob.getBoolean("inWork"),ob.getBoolean("done"),
                        ob.getString("name"),ob.getString("message"),
                        ProblemType.valueOf(ob.getString("problemType")),
                        Technology.valueOf(ob.getString("technology")),
                        Region.valueOf(ob.getString("region"))));
            }

        } catch (IOException | JSONException e) {
            Log.d("MyAppLog",e.getMessage());
        }
    }
}

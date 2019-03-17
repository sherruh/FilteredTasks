package com.example.filteredtasks.serialyzers;

import android.util.Log;
import android.webkit.WebResourceRequest;

import com.example.filteredtasks.enums.ProblemType;
import com.example.filteredtasks.enums.Region;
import com.example.filteredtasks.enums.Technology;


import org.glassfish.jersey.filter.LoggingFilter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;



public class JSonWorker {

    public JSonWorker() throws IOException, JSONException {
        String url = "https://my-json-server.typicode.com/sherruh/DBJSonFilteredTasks/posts";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        //con.setRequestMethod("GET");
        //add request header
        //con.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
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

        System.out.println(response.toString());

        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("result after Reading JSON Response");
        System.out.println("statusCode- "+myResponse.getString("id"));
        System.out.println("statusMessage- "+myResponse.getString("title"));
    }
}

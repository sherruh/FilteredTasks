package com.example.filteredtasks;

import android.os.StrictMode;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.filteredtasks.fragments.RecyclerFragment;
import com.example.filteredtasks.services.JSonWorker;

import org.json.JSONException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    RecyclerFragment recyclerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        recyclerFragment=new RecyclerFragment();
        fragmentTransaction.add(R.id.fragment_container,recyclerFragment);
        fragmentTransaction.commit();
    }
}

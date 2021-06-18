package com.example.habtracker20;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class viewTasks extends AppCompatActivity {


    /*
    This class is used to show Tasks
    Taken from the video: https://www.youtube.com/watch?v=jTL6EDvrjn8

    Connected to DoesAdapter.java that use item_style.xml
    Connected to Task.java

     */

    // Show tasks
      // add data
    RecyclerView ourtasks;
    ArrayList<Task> list;
    DoesAdapter doesAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("viewtasks", "OK");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tasks);


        ourtasks = findViewById(R.id.ourTasks);
        ourtasks.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Task>();


        // For test
        for (int i = 0; i<10; i++) {
            Task tsk = new Task();
            tsk.setName("NAME");
            tsk.setNotes("NOTES");
            tsk.setDate("Today");

            list.add(tsk);

        }
//        Task tsk = new Task();
//        tsk.setName("NAME");
//        tsk.setNotes("NOTES");
//        tsk.setDate("TOday");

//        list.add(tsk);


        doesAdapter = new DoesAdapter(viewTasks.this, list);
        ourtasks.setAdapter(doesAdapter);



        // Button to go to Main
        Button button = findViewById(R.id.button_second);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (viewTasks.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }



}
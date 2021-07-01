package com.example.habtracker20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class CreateTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        // Go to main activity
        Button cancel = findViewById(R.id.cancelBtn);
        cancel.setOnClickListener(vew -> {
            Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
        });
    }
}
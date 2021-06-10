package com.example.habtracker20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class CalendarDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_display);


        // Setup Calendar by Fetching Date
        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        String date = getIntent().getStringExtra("date");
        if(date!=null)
            testView.setText(date);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.class, CalendarDisplay.this);
                startActivity(intent);
            }
        });

        // Setup Display Calendar
        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = year + "/" + month + "/" + dayOfMonth;
                Intent intent2 = new Intent(CalendarDisplay.this, MainActivity.class);
                intent2.putExtra("date", date);

                startActivity(intent2);
            }
        });
    }
}
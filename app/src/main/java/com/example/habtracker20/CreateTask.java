package com.example.habtracker20;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class CreateTask extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener {
    public String nameString;
    public String data;
    private ArrayList<Task> coso;
    EditText habitName;

    int day = 0;
    int month = 0;
    int year = 0;
    int hour = 0;
    int minute = 0;

    int savedDay = 0;
    int savedMonth = 0;
    int savedYear = 0;
    int savedHour = 0;
    int savedMinute = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        habitName = findViewById(R.id.nameOfHabit);
        // Buttons
        Button toCal = findViewById(R.id.toCalendar);
        toCal.setOnClickListener(view -> {
            Intent intent = new Intent (CreateTask.this, CalendarActivity.class);
            startActivity(intent);
        });
        Button toTask = findViewById(R.id.toTasks);
        toTask.setOnClickListener(vew -> {
            Intent intent1 = new Intent(CreateTask.this, viewTasks.class);
            startActivity(intent1);
        });
        Button cancel = findViewById(R.id.cancelBtn);
        cancel.setOnClickListener(vew -> {
            Intent intent1 = new Intent(CreateTask.this, MainActivity.class);
            startActivity(intent1);
        });
        Button something = findViewById(R.id.toSomething);
        something.setOnClickListener(vew -> {
            Intent intent1 = new Intent(CreateTask.this, MainActivity.class);
            startActivity(intent1);
        });

        // set date and time
        Button date = findViewById(R.id.pickDateTime);
        date.setOnClickListener(vew -> {
            getDateTimeCalender();
            new DatePickerDialog(this, this, year, month, day).show();
        });
        // save new task
        Button save = findViewById(R.id.saveBtn);
        save.setOnClickListener(vew -> {
            nameString = habitName.getText().toString();
            data = savedMonth +" "+ savedDay;
            Log.d("Action", "Habit Added/Saved");
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        this.savedDay = dayOfMonth;
        this.savedMonth = month;
        this.savedYear = year;
        getDateTimeCalender();
        new TimePickerDialog(this, this, hour, minute, true).show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        this.savedHour = hourOfDay;
        this.savedMinute = minute;
        String text1 = this.savedDay + "/" + this.savedMonth + "/" + this.savedYear;
        String text2 = this.savedHour + ":" + this.savedMinute;
        String finalText = text1 + "\n" + text2;
        TextView textView = findViewById(R.id.seeDate);
        textView.setText(finalText);
    }

    private void saveDate() {
        //TODO JSON
    }

    private void getDateTimeCalender() {
        Calendar cal = Calendar.getInstance();
        this.day = cal.get(Calendar.DAY_OF_MONTH);
        this.month = cal.get(Calendar.MONTH);
        this.year = cal.get(Calendar.YEAR);
        this.hour = cal.get(Calendar.HOUR);
        this.minute = cal.get(Calendar.MINUTE);
    }

    public String getNameString(){
        return nameString;
    }

    public String getData(){
        return data;
    }
}
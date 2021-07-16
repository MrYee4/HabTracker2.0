package com.example.habtracker20;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;
import java.util.Calendar;

public class CreateTask extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    public String strh;

    public String datahab;

    EditText nmofhabit;

    private ArrayList<Task> coso;

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

        nmofhabit = (EditText) findViewById(R.id.nameOfHabit);

        // Go to main activity
        Button cancel = findViewById(R.id.cancelBtn);
        cancel.setOnClickListener(vew -> {
            Intent intent1 = new Intent(this, MainActivity.class);
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
            strh = nmofhabit.getText().toString();

            datahab = savedMonth +" "+ savedDay;

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

    }

    private void getDateTimeCalender() {
        Calendar cal = Calendar.getInstance();
        this.day = cal.get(Calendar.DAY_OF_MONTH);
        this.month = cal.get(Calendar.MONTH);
        this.year = cal.get(Calendar.YEAR);
        this.hour = cal.get(Calendar.HOUR);
        this.minute = cal.get(Calendar.MINUTE);
    }

    public String getStrh(){
        return strh;
    }

    public String getDatahab(){
        return datahab;
    }
}
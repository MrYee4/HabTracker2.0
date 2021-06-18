package com.example.habtracker20;

import com.google.gson.Gson;

import java.util.Calendar;
import java.util.Date;

public class Task {

    //Changed Data to String!
    private String name;
    private String time;
    private String notes;
    private Boolean done;
    private String subtype;

//    public Task(String title, String today, String subtitle, String rwrew) {
//        this.name = "Habit";
//        this.time = Calendar.getInstance().getTime();
//        this.done = false;
//        this.subtype = null;
//    }
//
//    public Task (String name, Date time, String notes, String subtype) {
//        this.name = name;
//        this.time = time;
//        this.notes = notes;
//        this.done = false;
//        this.subtype = subtype;
//    }

    public void complete () {
        this.done = true;
    }

    public void incomplete () {this.done = false;}

    public String getName () {
        return this.name;
    }

    public void setName (String name) {this.name = name;}

    public String getTime () { return this.time;}

    public void setDate (String date) {this.time = date;}

    public String getNotes () {
        return this.notes;
    }

    public void setNotes (String notes) {this.notes = notes;}

    public Boolean getDone () {
        return this.done;
    }

    public String getSubtype () {
        return this.subtype;
    }

    public String toJson () {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

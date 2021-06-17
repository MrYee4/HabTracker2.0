package com.example.habtracker20;

import java.util.Calendar;
import java.util.Date;

public class Task {
    private String name;
    private Date time;
    private String notes;
    private Boolean done;
    private String subtype;

    public Task () {
        this.name = "Habit";
        this.time = Calendar.getInstance().getTime();
        this.done = false;
        this.subtype = null;
    }

    public Task (String name, Date time, String notes, String subtype) {
        this.name = name;
        this.time = time;
        this.notes = notes;
        this.done = false;
        this.subtype = subtype;
    }

    public void complete () {
        this.done = true;
    }

    public String getName () {
        return this.name;
    }

    public Date getTime () {
        return this.time;
    }

    public String getNotes () {
        return this.notes;
    }

    public Boolean getDone () {
        return this.done;
    }

    public String getSubtype () {
        return this.subtype;
    }
}

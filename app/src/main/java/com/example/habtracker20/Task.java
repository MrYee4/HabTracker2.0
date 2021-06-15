package com.example.habtracker20;

public class Task {
    private String name;
    private int time;
    private String notes;
    private Boolean done;
    private String subtype;

    private Task (String name, int time, String notes, Boolean done, String subtype) {
        this.name = name;
        this.time = time;
        this.notes = notes;
        this.done = done;
        this.subtype = subtype;
    }

    public String getName () {
        return this.name;
    }

    public int getTime () {
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

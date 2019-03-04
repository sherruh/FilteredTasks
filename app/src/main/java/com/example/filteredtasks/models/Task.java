package com.example.filteredtasks.models;

public class Task {
    private int inWork;
    private int done;
    private String message;

    public Task(int inWork, int done, String message) {
        this.inWork = inWork;
        this.done = done;
        this.message = message;
    }

    public int getInWork() {
        return inWork;
    }

    public int getDone() {
        return done;
    }

    public String getMessage() {
        return message;
    }
}

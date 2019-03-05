package com.example.filteredtasks.models;

public class Task {
    private boolean inWork;
    private boolean done;
    private String message;

    public Task(boolean inWork, boolean done, String message) {
        this.inWork = inWork;
        this.done = done;
        this.message = message;
    }

    public boolean getInWork() {
        return inWork;
    }

    public boolean getDone() {
        return done;
    }

    public String getMessage() {
        return message;
    }
}

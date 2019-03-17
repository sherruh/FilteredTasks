package com.example.filteredtasks.models;

import com.example.filteredtasks.enums.ProblemType;
import com.example.filteredtasks.enums.Region;
import com.example.filteredtasks.enums.Technology;

public class Task {
    private boolean inWork;
    private boolean done;
    private String name;
    private String message;
    private ProblemType problemType;
    private Technology technology;
    private Region region;

    public Task(boolean inWork, boolean done, String name, String message, ProblemType problemType,
                Technology technology, Region region) {
        this.inWork = inWork;
        this.done = done;
        this.name = name;
        this.message = message;
        this.problemType = problemType;
        this.technology = technology;
        this.region = region;
    }

    public boolean isInWork() {
        return inWork;
    }

    public boolean isDone() {
        return done;
    }

    public String getName() {
        return name;
    }

    public ProblemType getProblemType() {
        return problemType;
    }

    public Technology getTechnology() {
        return technology;
    }

    public Region getRegion() {
        return region;
    }

    public String getMessage() {
        return message;
    }

    public void setInWork(boolean inWork) {
        this.inWork = inWork;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}

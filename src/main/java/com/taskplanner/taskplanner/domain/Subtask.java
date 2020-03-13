package com.taskplanner.taskplanner.domain;

public class Subtask {
    private String naam, description;
    private Task task;

    public Subtask(String naam, String description, Task task) {
        this.naam = naam;
        this.description = description;
        setTask(task);
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

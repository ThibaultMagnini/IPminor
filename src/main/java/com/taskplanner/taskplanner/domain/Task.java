package com.taskplanner.taskplanner.domain;

import javafx.scene.control.Tab;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private String name;
    private String description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDate;
    private int id;
    private List<Task> subtasks;

    public Task(String name, String description, LocalDateTime dueDate){
        this.dueDate = dueDate;
        this.name = name;
        this.description = description;
        subtasks = new ArrayList<>();
    }

    public List<Task> getSubtasks() {
        return subtasks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addSubtask(Task task){
        subtasks.add(task);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

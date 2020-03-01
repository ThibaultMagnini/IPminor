package com.taskplanner.taskplanner.domain;

import javafx.scene.control.Tab;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
    private String name;
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dueDate;
    private int id;

    public Task(String name, String description, LocalDateTime dueDate, int id){
        this.dueDate = dueDate;
        this.name = name;
        this.description = description;
        this.id = id;
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

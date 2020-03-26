package com.taskplanner.taskplanner.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {
    private String name;
    private String description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Subtask> subtasks;

    public Task(String name, String description, LocalDateTime dueDate){
        this.dueDate = dueDate;
        this.name = name;
        this.description = description;
        subtasks = new ArrayList<>();
    }

    public Task(){

    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addSubtask(Subtask task){
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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

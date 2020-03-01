package com.taskplanner.taskplanner.service;

import com.taskplanner.taskplanner.domain.Task;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {
    List<Task> getTasks();

    void addTask(String name, String description, LocalDateTime localDateTime);

    Task getTask(int id);

}

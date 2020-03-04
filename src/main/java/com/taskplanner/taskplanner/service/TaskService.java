package com.taskplanner.taskplanner.service;

import com.taskplanner.taskplanner.domain.Task;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {
    List<Task> getTasks();

    void addTask(Task task);

    Task getTask(int id);

    void addSubtask(Task task, int id);

    List<Task> getSubtasks(int id);

    void taskEdit(String name, String description, LocalDateTime localDateTime, int id);

}

package com.taskplanner.taskplanner.service;

import com.taskplanner.taskplanner.domain.Subtask;
import com.taskplanner.taskplanner.domain.Task;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {
    List<Task> getTasks();

    void addTask(Task task);

    Task getTask(int id);

    void addSubtask(Subtask task, int id);

    List<Subtask> getSubtasks(int id);

    void taskEdit(Task task);

}

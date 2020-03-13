package com.taskplanner.taskplanner.service;

import com.taskplanner.taskplanner.domain.Subtask;
import com.taskplanner.taskplanner.domain.SubtaskDTO;
import com.taskplanner.taskplanner.domain.Task;
import com.taskplanner.taskplanner.domain.TaskDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {
    List<Task> getTasks();

    void addTask(TaskDTO task);

    Task getTask(int id);

    void addSubtask(SubtaskDTO task);

    List<Subtask> getSubtasks(int id);

    void taskEdit(TaskDTO task);

}

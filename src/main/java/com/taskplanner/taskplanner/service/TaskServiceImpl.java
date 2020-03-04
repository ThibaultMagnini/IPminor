package com.taskplanner.taskplanner.service;

import com.taskplanner.taskplanner.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private List<Task> tasks;

    @Autowired
    public TaskServiceImpl(){
        tasks = new ArrayList<>();
        tasks.add(new Task("Task 1", "first task", LocalDateTime.of(2020, 11,16,12,30)));
        tasks.add(new Task("Task 2","second task", LocalDateTime.of(2020, 8,12, 6, 40)));
        tasks.add(new Task("Task 3", "third task", LocalDateTime.of(2021, 5,26, 5, 20)));
        tasks.get(0).setId(0);
        tasks.get(1).setId(1);
        tasks.get(2).setId(2);
    }

    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void addTask(Task task) {
        int id = tasks.get(tasks.size()-1).getId() + 1;
        task.setId(id);
        tasks.add(task);
    }

    @Override
    public Task getTask(int id) {
        for (Task t : tasks){
            if (t.getId() == id){
                return t;
            }
        }
        return null;
    }

    @Override
    public void addSubtask(Task task, int id) {
        getTask(id).addSubtask(task);
    }

    @Override
    public List<Task> getSubtasks(int id) {
        return getTask(id).getSubtasks();
    }

    @Override
    public void taskEdit(String name, String description, LocalDateTime localDateTime, int id) {
        Task t = getTask(id);
        t.setName(name);
        t.setDescription(description);
        t.setDueDate(localDateTime);
    }
}

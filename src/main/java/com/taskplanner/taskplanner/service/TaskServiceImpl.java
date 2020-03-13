package com.taskplanner.taskplanner.service;

import com.taskplanner.taskplanner.TaakRepository;
import com.taskplanner.taskplanner.domain.Subtask;
import com.taskplanner.taskplanner.domain.SubtaskDTO;
import com.taskplanner.taskplanner.domain.Task;
import com.taskplanner.taskplanner.domain.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private TaakRepository repository;

    @Autowired
    public TaskServiceImpl(TaakRepository repository){
        this.repository = repository;
        repository.save(new Task("jef", "ga naar de bakker", LocalDateTime.now()));
//        tasks = new ArrayList<>();
//        tasks.add(new Task("Task 1", "first task", LocalDateTime.of(2020, 11,16,12,30)));
//        tasks.add(new Task("Task 2","second task", LocalDateTime.of(2020, 8,12, 6, 40)));
//        tasks.add(new Task("Task 3", "third task", LocalDateTime.of(2021, 5,26, 5, 20)));
//        tasks.get(0).setId(0);
//        tasks.get(1).setId(1);
//        tasks.get(2).setId(2);
    }

    @Override
    public List<Task> getTasks() {
        return repository.findAll();
    }

    @Override
    public void addTask(TaskDTO task) {
        Task t = new Task(task.getName(), task.getDescription(), task.getDueDate());
        repository.save(t);
        //int id = tasks.get(tasks.size()-1).getId() + 1;
        //task.setId(id);
        //tasks.add(task);
    }

    @Override
    public Task getTask(int id) {
        for (Task t : repository.findAll()){
            if (t.getId() == id){
                return t;
            }
        }
        return null;
    }

    //TODO fix
    @Override
    public void addSubtask(SubtaskDTO task) {
        //Subtask t = new Subtask(task.getName(), task.getDescription(),ta);

    }

    @Override
    public List<Subtask> getSubtasks(int id) {
        return getTask(id).getSubtasks();
    }

    @Override
    public void taskEdit(TaskDTO task) {
        repository.editTaak(task.getName(), task.getDescription(), task.getDueDate(), task.getId());
    }
}

package com.taskplanner.taskplanner.service;

import com.taskplanner.taskplanner.repositories.SubTaskRepository;
import com.taskplanner.taskplanner.repositories.TaakRepository;
import com.taskplanner.taskplanner.domain.Subtask;
import com.taskplanner.taskplanner.domain.SubtaskDTO;
import com.taskplanner.taskplanner.domain.Task;
import com.taskplanner.taskplanner.domain.TaskDTO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private TaakRepository repository;
    private SubTaskRepository subTaskRepository;

    @Autowired
    public TaskServiceImpl(TaakRepository repository, SubTaskRepository subTaskRepository){
        this.repository = repository;
        this.subTaskRepository = subTaskRepository;

        repository.save(new Task("jef", "ga naar de bakker", LocalDateTime.now()));

    }

    @Override
    public List<Task> getTasks() {
        return repository.findAll();
    }

    @Override
    public TaskDTO addTask(TaskDTO task) {
        Task t = new Task(task.getName(), task.getDescription(), task.getDueDate());
        repository.save(t);
        return convert(t);
    }

    @Override
    public Task getTask(long id) {
        for (Task t : repository.findAll()){
            if (t.getId() == id){
                return t;
            }
        }
        return null;
    }

    @Override
    public void addSubtask(SubtaskDTO task) {
        Subtask subtask = new Subtask();
        subtask.setNaam(task.getName());
        subtask.setDescription(task.getDescription());
        subtask.setTask(repository.findById(task.getId()).orElse(null));
        repository.findById(task.getId()).map(post -> subTaskRepository.save(subtask));
    }

    @Override
    public List<Subtask> getSubtasks(long id) {
        return getTask(id).getSubtasks();
    }

    @Override
    public void taskEdit(TaskDTO task) {
        System.out.println(task.getId());
        repository.editTaak(task.getName(), task.getDescription(), task.getDueDate(), task.getId());
    }

    private TaskDTO convert(Task task){
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setDueDate(task.getDueDate());
        dto.setDescription(task.getDescription());
        return dto;
    }

    @Override
    public List<Task> getAll() {
        return repository.findAll();
    }
}

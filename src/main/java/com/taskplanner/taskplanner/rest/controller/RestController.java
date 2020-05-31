package com.taskplanner.taskplanner.rest.controller;


import com.taskplanner.taskplanner.domain.Task;
import com.taskplanner.taskplanner.domain.TaskDTO;
import com.taskplanner.taskplanner.service.TaskService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    private final TaskService taskService;

    public RestController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    @ResponseBody
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping("/tasks")
    public TaskDTO createTask(@RequestBody @Valid TaskDTO taskDTO){
        return taskService.addTask(taskDTO);
    }
}

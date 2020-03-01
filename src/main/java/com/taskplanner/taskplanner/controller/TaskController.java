package com.taskplanner.taskplanner.controller;

import com.taskplanner.taskplanner.domain.Task;
import com.taskplanner.taskplanner.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService t){
        this.taskService = t;
    }

    @GetMapping("/task")
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/task/{id}")
    public String showTaskDetails (Model model, @PathVariable("id") int id) {
        model.addAttribute("task", taskService.getTask(id));
        return "detailTask";
    }

    @GetMapping("/task/new")
    public String getNew(){
        return "addTask";
    }

    @PostMapping("/task/new")
    public String addTask(@ModelAttribute Task task){
        taskService.addTask(task);
        return "redirect:/task";
    }
}

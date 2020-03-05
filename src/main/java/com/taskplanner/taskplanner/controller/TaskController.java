package com.taskplanner.taskplanner.controller;

import com.taskplanner.taskplanner.domain.Subtask;
import com.taskplanner.taskplanner.domain.SubtaskDTO;
import com.taskplanner.taskplanner.domain.Task;
import com.taskplanner.taskplanner.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService t){
        this.taskService = t;
    }

    @GetMapping("/")
    public String showIndex(){
        return "index";
    }

    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String showTaskDetails (Model model, @PathVariable("id") int id) {
        model.addAttribute("task", taskService.getTask(id));
        model.addAttribute("subtasks", taskService.getSubtasks(id));
        return "detailTask";
    }

    @GetMapping("/tasks/new")
    public String getNew(){
        return "addTask";
    }

    @PostMapping("/tasks/new")
    public String addTask(@ModelAttribute Task task){
        taskService.addTask(task);
        return "redirect:/task";
    }

    @GetMapping("/tasks/edit/{id}")
    public String showTaskEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("task", taskService.getTask(id));
        return "taskEdit";
    }

    @PostMapping("/tasks/edit")
    public String taskEdit(@ModelAttribute Task task){
        taskService.taskEdit(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String showSubTask(Model model, @PathVariable("id") int id){
        model.addAttribute("task", taskService.getTask(id));
        return "addSubtask";
    }

    @PostMapping("/tasks/sub/create")
    public String addSubtask(@ModelAttribute SubtaskDTO task){
        Subtask t = new Subtask(task.getName(), task.getDescription());
        taskService.addSubtask(t, task.getId());
        return "redirect:/tasks/" + task.getId();
    }
}

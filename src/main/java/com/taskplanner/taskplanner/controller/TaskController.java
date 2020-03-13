package com.taskplanner.taskplanner.controller;

import com.taskplanner.taskplanner.domain.Subtask;
import com.taskplanner.taskplanner.domain.SubtaskDTO;
import com.taskplanner.taskplanner.domain.Task;
import com.taskplanner.taskplanner.domain.TaskDTO;
import com.taskplanner.taskplanner.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String getNew(Model model){
        TaskDTO t = new TaskDTO();
        model.addAttribute("task", t);
        return "addTask";
    }

    @PostMapping("/tasks/new")
    public String addTask(@ModelAttribute @Valid TaskDTO task, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/tasks/new";
        }
        taskService.addTask(task);
        return "redirect:/task";
    }

    @GetMapping("/tasks/edit/{id}")
    public String showTaskEdit(@PathVariable("id") int id, Model model){
        TaskDTO task = new TaskDTO();
        task.setId(id);
        task.setDescription(taskService.getTask(id).getDescription());
        task.setName(taskService.getTask(id).getName());
        task.setDueDate(taskService.getTask(id).getDueDate());
        model.addAttribute("task", task);
        return "taskEdit";
    }

    @PostMapping("/tasks/edit")
    public String taskEdit(@ModelAttribute TaskDTO task, BindingResult bindingResult, Model model){
        model.addAttribute("task", task);
        if (bindingResult.hasErrors()){
            return "taskEdit";
        }
        taskService.taskEdit(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String showSubTask(Model model, @PathVariable("id") int id){
        SubtaskDTO dto =new SubtaskDTO();
        dto.setId(id);
        model.addAttribute("task", dto);
        return "addSubtask";
    }

    @PostMapping("/tasks/sub/create")
    public String addSubtask(@ModelAttribute SubtaskDTO task, BindingResult bindingResult, Model model){
        model.addAttribute("task",taskService.getTask(task.getId()));
        model.addAttribute("task" , task);
        taskService.addSubtask(task);
        return "redirect:/tasks/" + task.getId();
    }
}

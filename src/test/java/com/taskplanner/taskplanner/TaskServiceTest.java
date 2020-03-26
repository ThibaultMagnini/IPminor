package com.taskplanner.taskplanner;

import com.taskplanner.taskplanner.domain.Task;
import com.taskplanner.taskplanner.domain.TaskDTO;
import com.taskplanner.taskplanner.service.TaskServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskServiceImpl service;

    @Test
    public void add_task_and_get_taken_test() {
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setName("test");
        taskDTO.setDescription("testtest");
        taskDTO.setDueDate(LocalDateTime.of(2020,5,5,20,5));
        service.addTask(taskDTO);

        List<Task> tasks = service.getTasks();

        Assertions.assertNotNull(tasks);

        Task task = tasks.get(0);
        Assertions.assertNotNull(task);

    }

}

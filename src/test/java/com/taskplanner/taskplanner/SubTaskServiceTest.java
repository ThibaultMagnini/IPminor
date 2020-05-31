package com.taskplanner.taskplanner;

import com.taskplanner.taskplanner.domain.Subtask;
import com.taskplanner.taskplanner.domain.Task;
import com.taskplanner.taskplanner.domain.TaskDTO;
import com.taskplanner.taskplanner.repositories.SubTaskRepository;
import com.taskplanner.taskplanner.repositories.TaakRepository;
import com.taskplanner.taskplanner.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SubTaskServiceTest {

    @Autowired
    private TaskService service;
    private TaakRepository repository;
    private SubTaskRepository subTaskRepository;
    private TaskDTO t;


    @Test
    public void TaskTest(){
        assertNotNull(service.getAll().get(0));
    }


}

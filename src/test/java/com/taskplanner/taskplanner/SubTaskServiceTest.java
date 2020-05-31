package com.taskplanner.taskplanner;

import com.taskplanner.taskplanner.domain.Task;
import com.taskplanner.taskplanner.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SubTaskServiceTest {

    @Autowired
    private TaskService service;
    private Task t;


    @Test
    public void subtaskTest(){
        assertNotNull(service.getAll().get(0));
    }


}

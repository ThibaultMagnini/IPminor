package com.taskplanner.taskplanner.repositories;

import com.taskplanner.taskplanner.domain.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface SubTaskRepository extends JpaRepository<Subtask, Long> {

}

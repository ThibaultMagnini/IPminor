package com.taskplanner.taskplanner;

import com.taskplanner.taskplanner.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Component
public interface TaakRepository extends JpaRepository<Task, Integer> {

    @Modifying
    @Transactional
    @Query("update Task t set t.name = ?1 , t.description = ?2, t.dueDate = ?3 where t.id = ?4")
    void editTaak(String name, String description, LocalDateTime dueDate, int id);

}

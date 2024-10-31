package com.example.Todo_FullStack_Application.repository;

import com.example.Todo_FullStack_Application.dto.CountType;
import com.example.Todo_FullStack_Application.model.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@EnableJpaRepositories
@Repository
@Transactional


public interface TaskRepository extends JpaRepository<Task,Long> {

    @Modifying
    @Query(value = "update Task set title=?1,type=?2,dueDate=?3,description=?4 where id=?5")
    void updateTask(String title, String type, Date dueDate, String description, Long id);



    @Query("SELECT new com.example.Todo_FullStack_Application.dto.CountType(" +
            "(COUNT(t) * 1.0 / (SELECT COUNT(t2) FROM Task t2) * 100), " +
            "t.type) " +
            "FROM Task t GROUP BY t.type")
    public List<CountType> getPercentageGroupByType();



}

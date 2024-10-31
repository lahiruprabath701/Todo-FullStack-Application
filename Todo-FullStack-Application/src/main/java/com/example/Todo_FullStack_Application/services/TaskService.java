package com.example.Todo_FullStack_Application.services;

import com.example.Todo_FullStack_Application.dto.CountType;
import com.example.Todo_FullStack_Application.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    Task addTask(Task task);

    Task updateTask(Task task, Long id);

    Task getTaskById(Long id);

    String deleteTaskById(Long id);

    List<CountType> getPercentageGroupByType();
}

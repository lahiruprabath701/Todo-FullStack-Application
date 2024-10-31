package com.example.Todo_FullStack_Application.services.serviceIMPL;

import com.example.Todo_FullStack_Application.dto.CountType;
import com.example.Todo_FullStack_Application.model.Task;
import com.example.Todo_FullStack_Application.repository.TaskRepository;
import com.example.Todo_FullStack_Application.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceIMPL implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    @Override
    public Task updateTask(Task task, Long id) {
        if (taskRepository.existsById(id)){
            taskRepository.updateTask(task.getTitle(),task.getType(),task.getDueDate(),task.getDescription(),id);
            return task;
        }else{
            return null;
        }

    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
          if (task.isPresent()){
              return task.get();
          }else {
              return null;
          }

    }

    @Override
    public String deleteTaskById(Long id) {
        if (taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return id + " task deleted";

        }else{
            return id + "this id not found in database";
        }

    }

    @Override
    public List<CountType> getPercentageGroupByType() {
        return taskRepository.getPercentageGroupByType();
    }
}

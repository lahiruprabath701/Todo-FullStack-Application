package com.example.Todo_FullStack_Application.controller;

import com.example.Todo_FullStack_Application.dto.CountType;
import com.example.Todo_FullStack_Application.model.Task;
import com.example.Todo_FullStack_Application.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/v1/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping(path = "/getTask/vData/percentcounttype")
    public List<CountType> getPercentageGroupByType(){

        return taskService.getPercentageGroupByType();
    }

    @GetMapping(path = "/getAllTask")
    public List<Task> getAllTask(){

        return taskService.getAllTasks();
    }

    @PostMapping(path = "/addTask")
    public Task addTask(@RequestBody Task task){

        return taskService.addTask(task);
    }

    @PutMapping(path = "/updateTask/{id}")
    public Task updateTask(@RequestBody Task task,@PathVariable Long id){
        return taskService.updateTask(task,id);
    }

    @GetMapping(path = "/getById/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @DeleteMapping(path = "/deleteById/{id}")
    public String deleteTask(@PathVariable Long id){
         return taskService.deleteTaskById(id);

    }



}

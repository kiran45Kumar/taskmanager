package com.kiran.taskmanager.controller;
import com.kiran.taskmanager.service.*;
import com.kiran.taskmanager.entity.Task;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/tasks")
public class TaskController{
    @Autowired
    private TaskService service;

    @PostMapping
    public Task create(@RequestBody Task task){
        return service.createTask(task);
    }

    @GetMapping
    public List<Task> getAll(){
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id){
        return service.getTaskById(id);
    }
   

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task){
        return service.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
     public void delete(@PathVariable Long id){
        service.deleteTask(id);
    }
}
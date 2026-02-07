package com.kiran.taskmanager.service;
import com.kiran.taskmanager.service.TaskService;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.kiran.taskmanager.repository.TaskRepository;
import com.kiran.taskmanager.entity.*;
import org.springframework.data.domain.Sort;

import java.util.*;
@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskrepository;

    @Override
    public Task createTask(Task task){
        return taskrepository.save(task);
    }
    
    @Override
    public List<Task> getAllTasks(){
        return taskrepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
  
    @Override
    public Task getTaskById(Long id){
        return taskrepository.findById(id).filter(task->!task.isDeleted()).orElseThrow(()->new RuntimeException("Task not found"));
    }
  
    @Override
    public Task updateTask(Long id, Task task){
        Task existing = taskrepository.findById(id);
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription()); 
        existing.setCompleted(task.isCompleted());
        return taskrepository.save(existing);
    }

    @Override
    public void deleteTask(Long id){
    Task task = getTaskById(id);
    task.setIsDeleted(true);
    taskrepository.save(task);
}

}
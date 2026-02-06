package com.kiran.taskmanager.service;
import com.kiran.taskmanager.entity.*;
import java.util.*;

public interface TaskService{
    Task createTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
}
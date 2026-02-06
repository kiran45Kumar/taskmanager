package com.kiran.taskmanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.kiran.taskmanager.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
}
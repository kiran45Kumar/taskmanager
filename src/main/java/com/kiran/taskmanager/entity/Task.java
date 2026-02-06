package com.kiran.taskmanager.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "users")
@Data
public class Task{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private boolean completed = false;
    
    private boolean deleted = false;


    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    
    public boolean isCompleted(){
        return completed;
    }
    public void setIsCompleted(boolean completed){
        this.completed = completed;
    }

    
    public boolean isDeleted(){
        return deleted;
    }
    public void setIsDeleted(boolean deleted){
        this.deleted = deleted;
    }
}
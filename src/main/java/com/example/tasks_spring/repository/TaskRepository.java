package com.example.tasks_spring.repository;

import com.example.tasks_spring.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
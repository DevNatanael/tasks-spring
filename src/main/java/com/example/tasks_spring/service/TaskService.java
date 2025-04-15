package com.example.tasks_spring.service;

import com.example.tasks_spring.dto.TaskDTO;
import com.example.tasks_spring.entity.Task;
import com.example.tasks_spring.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> listAll() {
        return repository.findAll();
    }

    public Task create(TaskDTO dto) {
        Task task = new Task(null, dto.getTitle(), dto.getDescription(), dto.getCompleted());
        return repository.save(task);
    }

    public Task update(Long id, TaskDTO dto) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.getCompleted());
        return repository.save(task);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Task getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));
    }
}
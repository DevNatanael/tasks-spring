package com.example.tasks_spring.dto;

import jakarta.validation.constraints.NotBlank;

public class TaskDTO {
    @NotBlank
    private String title;

    private String description;
    private Boolean completed = false;

    public TaskDTO(String title, String description, Boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public @NotBlank String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}

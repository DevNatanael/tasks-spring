package com.example.tasks_spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tasks_spring.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}

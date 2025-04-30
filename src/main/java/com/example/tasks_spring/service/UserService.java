package com.example.tasks_spring.service;

import com.example.tasks_spring.dto.UserDTO;
import com.example.tasks_spring.entity.User;
import com.example.tasks_spring.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> listAll(){
        return  repository.findAll();
    }

    public User create(UserDTO dto){
        User user = new User(null, dto.getName(),dto.getEmail(),dto.getPassword());
        return repository.save(user);
    }

    public User update(Long id, UserDTO dto){
        User user = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Usuário não encontrado"));
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return repository.save((user));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User getById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Usuário não encontrado"));
    }
}

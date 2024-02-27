package com.example.lab3.services;

import com.example.lab3.model.UserEntity;
import com.example.lab3.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Integer id) {
        if (userRepository.findById(id).isEmpty()) {
            return null;
        }
        return userRepository.findById(id).get();
    }

    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}

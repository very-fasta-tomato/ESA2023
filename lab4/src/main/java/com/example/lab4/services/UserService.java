package com.example.lab4.services;

import com.example.lab4.model.UserEntity;
import com.example.lab4.repo.UserRepository;
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

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public int deleteById(Integer id) {
        if (userRepository.findById(id).isEmpty()) {
            return -1;
        }
        userRepository.deleteById(id);
        return 1;
    }
}

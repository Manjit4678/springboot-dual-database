package com.example.dualdb.spring_boot_dual_database.service;

import com.example.dualdb.spring_boot_dual_database.entity.mysql.User;
import com.example.dualdb.spring_boot_dual_database.repository.mysql.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        Long userId = Long.parseLong(id);
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }


    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(Long.parseLong(id));
    }

    public User updateUser(User user) {
        if (!userRepository.existsById(user.getId())) {
            throw new RuntimeException("User not found with id: " + user.getId());
        }
        return userRepository.save(user);
    }

}

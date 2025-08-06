package com.example.dualdb.spring_boot_dual_database.service;

import com.example.dualdb.spring_boot_dual_database.entity.mongodb.UserDocument;
import com.example.dualdb.spring_boot_dual_database.repository.mongodb.UserDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDocumentService {

    private final UserDocumentRepository userDocumentRepository;

    public UserDocumentService(UserDocumentRepository userDocumentRepository) {
        this.userDocumentRepository = userDocumentRepository;
    }

    public List<UserDocument> getAllUsers() {
        return userDocumentRepository.findAll();
    }

    public UserDocument createUser(UserDocument user) {
        return userDocumentRepository.save(user);
    }

    public void deleteUser(String id) {
        userDocumentRepository.deleteById(id);
    }

    public UserDocument updateUser(UserDocument user) {
        return userDocumentRepository.save(user);
    }
}

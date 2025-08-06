package com.example.dualdb.spring_boot_dual_database.controller;

import com.example.dualdb.spring_boot_dual_database.dto.ClaimRequest;
import com.example.dualdb.spring_boot_dual_database.entity.mongodb.UserDocument;
import com.example.dualdb.spring_boot_dual_database.entity.mysql.User;
import com.example.dualdb.spring_boot_dual_database.repository.mongodb.UserDocumentRepository;
import com.example.dualdb.spring_boot_dual_database.repository.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDocumentRepository userDocumentRepository;

    @PostMapping
    public ResponseEntity<?> createClaim(@RequestBody ClaimRequest request) {
        // Fetch user from MySQL
        Optional<User> userOpt = userRepository.findById(request.getUserId());
        if (!userOpt.isPresent()) {
            return ResponseEntity.badRequest().body("User not found");
        }

        // Fetch user documents from MongoDB and convert Iterable to List
        List<UserDocument> userDocuments = StreamSupport
                .stream(userDocumentRepository.findAllById(request.getProductIds()).spliterator(), false)
                .collect(Collectors.toList());

        // Prepare response
        Map<String, Object> result = new HashMap<>();
        result.put("user", userOpt.get());
        result.put("userDocuments", userDocuments);
        result.put("message", "Claim created successfully");

        return ResponseEntity.ok(result);
    }
}

package com.example.dualdb.spring_boot_dual_database.controller;

import com.example.dualdb.spring_boot_dual_database.entity.mysql.User;
import com.example.dualdb.spring_boot_dual_database.entity.mongodb.UserDocument;
import com.example.dualdb.spring_boot_dual_database.service.UserService;
import com.example.dualdb.spring_boot_dual_database.service.UserDocumentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final UserDocumentService userDocumentService;

    public UserController(UserService userService, UserDocumentService userDocumentService) {
        this.userService = userService;
        this.userDocumentService = userDocumentService;
    }

    // CRUD for Autonomous DB
    @GetMapping("/mysql/users")
    public List<User> getMysqlUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/mysql/users")
    public User createMysqlUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // CRUD for NoSQL (MongoDB-like)
    @GetMapping("/nosql/users")
    public List<UserDocument> getNoSqlUsers() {
        return userDocumentService.getAllUsers();
    }

    @PostMapping("/nosql/users")
    public UserDocument createNoSqlUser(@RequestBody UserDocument user) {
        return userDocumentService.createUser(user);
    }
}

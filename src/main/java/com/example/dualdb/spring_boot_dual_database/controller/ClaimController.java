package com.example.dualdb.spring_boot_dual_database.controller;


import com.example.dualdb.spring_boot_dual_database.dto.ClaimRequest;
import com.example.dualdb.spring_boot_dual_database.entity.mongodb.Product;
import com.example.dualdb.spring_boot_dual_database.entity.mysql.User;
import com.example.dualdb.spring_boot_dual_database.repository.mongodb.ProductRepository;
import com.example.dualdb.spring_boot_dual_database.repository.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<?> createClaim(@RequestBody ClaimRequest request) {

        // Fetch user from MySQL
        Optional<User> userOpt = userRepository.findById(request.getUserId());
        if (!userOpt.isPresent()) {
            return ResponseEntity.badRequest().body("User not found");
        }

        // Fetch products from MongoDB
        List<Product> products = (List<Product>) productRepository.findAllById(request.getProductIds());

        // Prepare response
        Map<String, Object> result = new HashMap<>();
        result.put("user", userOpt.get());
        result.put("products", products);
        result.put("message", "Claim created successfully");

        return ResponseEntity.ok(result);
    }
}

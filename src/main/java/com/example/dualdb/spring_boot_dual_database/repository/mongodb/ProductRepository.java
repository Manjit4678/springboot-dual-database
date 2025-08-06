package com.example.dualdb.spring_boot_dual_database.repository.mongodb;

import com.example.dualdb.spring_boot_dual_database.entity.mongodb.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {}

package com.example.dualdb.spring_boot_dual_database.repository.mongodb;

import com.example.dualdb.spring_boot_dual_database.entity.mongodb.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDocumentRepository extends MongoRepository<UserDocument, String> {
}

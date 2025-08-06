
package com.example.dualdb.spring_boot_dual_database.repository.mysql;

import com.example.dualdb.spring_boot_dual_database.entity.mysql.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}

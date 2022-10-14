package com.hordiienko.exampleSecurity.repository;

import com.hordiienko.exampleSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}



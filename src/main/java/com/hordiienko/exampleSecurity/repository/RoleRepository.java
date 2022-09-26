package com.hordiienko.exampleSecurity.repository;

import com.hordiienko.exampleSecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

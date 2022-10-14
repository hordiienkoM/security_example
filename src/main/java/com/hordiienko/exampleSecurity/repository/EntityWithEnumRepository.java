package com.hordiienko.exampleSecurity.repository;

import com.hordiienko.exampleSecurity.entity.EntityWithEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityWithEnumRepository extends JpaRepository<EntityWithEnum, Long> {
}

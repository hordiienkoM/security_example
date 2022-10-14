package com.hordiienko.exampleSecurity.repository;

import com.hordiienko.exampleSecurity.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {
}

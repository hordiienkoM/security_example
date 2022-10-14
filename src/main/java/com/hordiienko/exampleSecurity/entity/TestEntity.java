package com.hordiienko.exampleSecurity.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Email(message = "it's not email")
    private String email;
}

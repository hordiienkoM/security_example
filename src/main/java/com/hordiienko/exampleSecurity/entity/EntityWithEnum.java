package com.hordiienko.exampleSecurity.entity;


import com.hordiienko.exampleSecurity.entity.enums.MyEntityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EntityWithEnum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entityName;
    @Enumerated(EnumType.STRING)
    private MyEntityType type;
}

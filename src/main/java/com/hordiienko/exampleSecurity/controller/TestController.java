package com.hordiienko.exampleSecurity.controller;


import com.hordiienko.exampleSecurity.entity.EntityWithEnum;
import com.hordiienko.exampleSecurity.entity.TestEntity;
import com.hordiienko.exampleSecurity.entity.User;
import com.hordiienko.exampleSecurity.entity.enums.MyEntityType;
import com.hordiienko.exampleSecurity.repository.EntityWithEnumRepository;
import com.hordiienko.exampleSecurity.repository.TestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.Email;

@RestController
@RequestMapping("/test")
@Validated
public class TestController {
    @Autowired
    private TestEntityRepository testEntityRepository;
    @Autowired
    private EntityWithEnumRepository entityWithEnumRepository;

    @GetMapping("/email")
    ResponseEntity isEmail(@RequestParam("email") @Email(message = "it's not email") String email) {
        return ResponseEntity.ok().body("it's email");
    }

    @GetMapping("/testEntity")
    ResponseEntity isTestEntity(@Valid @RequestBody TestEntity testEntity) {
        return ResponseEntity.ok().body(testEntity);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(e.getConstraintViolations().toString());
    }

    @GetMapping("/entity")
    public ResponseEntity getEntityWithEnum() {
        EntityWithEnum example = new EntityWithEnum();
        example.setEntityName("example");
        example.setType(MyEntityType.TYPE_FIRST);
        return ResponseEntity.ok().body(example);
    }

    @PostMapping("/entity")
    public ResponseEntity saveEntityWithEnum(@RequestBody EntityWithEnum newEntity) {
        entityWithEnumRepository.save(newEntity);
        return ResponseEntity.ok().body("ok");
    }

}

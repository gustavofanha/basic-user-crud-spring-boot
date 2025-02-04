package com.fanha.basic_user_crud.controller;

import com.fanha.basic_user_crud.domain.dto.UserRequest;
import com.fanha.basic_user_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserRequest> createUser(@RequestBody UserRequest newUser) {
        service.createUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}

package com.fanha.basic_user_crud.controller;

import com.fanha.basic_user_crud.domain.dto.UserRequest;
import com.fanha.basic_user_crud.domain.dto.UserResponse;
import com.fanha.basic_user_crud.domain.entity.User;
import com.fanha.basic_user_crud.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserRequest> createUser(@Valid @RequestBody UserRequest newUser) {
        service.createUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        List<UserResponse> userList = service.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable Long id) {
        var userId = service.findUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userUpdated) {
        service.updateUser(id, userUpdated);
        return ResponseEntity.status(HttpStatus.OK).body(userUpdated);
    }
}

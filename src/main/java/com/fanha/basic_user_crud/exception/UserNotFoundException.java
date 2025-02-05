package com.fanha.basic_user_crud.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id) {
        super("User not found, ID: " + id);
    }
}

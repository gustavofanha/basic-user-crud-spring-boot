package com.fanha.basic_user_crud.exception;

public class UniqueMethodsException extends RuntimeException{

    public UniqueMethodsException() {
        super("User already registered. Email and document must be unique.");
    }
}

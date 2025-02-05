package com.fanha.basic_user_crud.exception.handler;

import com.fanha.basic_user_crud.exception.UniqueMethodsException;
import com.fanha.basic_user_crud.exception.UserNotFoundException;
import com.fanha.basic_user_crud.exception.error.MethodError;
import com.fanha.basic_user_crud.exception.error.StandardError;
import com.fanha.basic_user_crud.util.Util;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardError> notFound(UserNotFoundException e, HttpServletRequest request) {
        var status = HttpStatus.NOT_FOUND.value();
        var exception = new StandardError(Util.zonedTimeStamp(), status, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }

    @ExceptionHandler(UniqueMethodsException.class)
    public ResponseEntity<StandardError> alreadyRegistered(UniqueMethodsException e, HttpServletRequest request) {
        var status = HttpStatus.BAD_REQUEST.value();
        var exception = new StandardError(Util.zonedTimeStamp(), status, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MethodError> methodNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        var message = "Invalid method: " + e.getFieldError().getField();
        var status = HttpStatus.BAD_REQUEST.value();
        var exception = new MethodError(Util.zonedTimeStamp(), status, message, request.getRequestURI(), e.getFieldError().getField(), e.getBindingResult());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }
}

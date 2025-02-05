package com.fanha.basic_user_crud.exception.error;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.validation.BindingResult;

import java.time.ZonedDateTime;

public class MethodError {

    private ZonedDateTime timestamp;
    private Integer status;
    private String message;
    private String path;
    private String fieldError;

    @JsonIgnore
    private BindingResult bindingResult;

    public MethodError() {}

    public MethodError(ZonedDateTime timestamp, Integer status, String message, String path, String fieldError, BindingResult bindingResult) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
        this.fieldError = fieldError;
        this.bindingResult = bindingResult;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFieldError() {
        return fieldError;
    }

    public void setFieldError(String fieldError) {
        this.fieldError = fieldError;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }
}

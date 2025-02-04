package com.fanha.basic_user_crud.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        @NotBlank @NotNull String name,
        @NotBlank @NotNull String document,
        @Email String email,
        @NotBlank @NotNull String password) {
}

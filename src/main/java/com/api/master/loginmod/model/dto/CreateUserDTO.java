package com.api.master.loginmod.model.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateUserDTO(
        @NotEmpty(message = "Name cannot be empty") @NotNull String userName,
        @NotEmpty(message = "Password cannot be empty") @NotNull String userPassword,
        @NotEmpty(message = "Email cannot be empty") @NotNull @Email String email
) {}


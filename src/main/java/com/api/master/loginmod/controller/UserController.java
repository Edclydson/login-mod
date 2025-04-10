package com.api.master.loginmod.controller;

import com.api.master.loginmod.model.dto.CreateUserDTO;
import com.api.master.loginmod.service.User.UserRegistrationService;
import com.api.master.loginmod.validation.Handler.UserValidatorHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserController {

    private final UserValidatorHandler userValidator;
    private final UserRegistrationService userRegistrationService;

    public UserController(UserValidatorHandler userValidator, UserRegistrationService userRegistrationService) {
        this.userValidator = userValidator;
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping
    public ResponseEntity<Void> registerUser(@RequestBody @Valid CreateUserDTO createUserDTO) {
        userValidator.userIsValid(createUserDTO);
        userRegistrationService.saveNewUser(createUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

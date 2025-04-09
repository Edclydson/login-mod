package com.api.master.loginmod.controller;

import com.api.master.loginmod.model.dto.CreateUserDTO;
import com.api.master.loginmod.service.impl.UserServiceImpl;
import com.api.master.loginmod.util.Validations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserController {

    private final UserServiceImpl userService;
    private final Validations checker;

    public UserController(UserServiceImpl userService, Validations checker) {
        this.userService = userService;
        this.checker = checker;
    }

    @PostMapping
    public ResponseEntity<Void> registerUser(@RequestBody CreateUserDTO createUserDTO) {
        if(checker.isEmailValid(createUserDTO.email()) &&
                checker.passwordRequirements(createUserDTO.userPassword()) &&
                !checker.passwordEmpty(createUserDTO.userPassword())) {
            return userService.saveUser(createUserDTO);
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
}

package com.api.master.loginmod.exception.handler;

import com.api.master.loginmod.exception.custom.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // Email Exceptions
    @ExceptionHandler(EmailAlreadyinUseException.class)
    public ResponseEntity<Void> handleEmailAlreadyInUseException() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<Void> handleInvalidEmailException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @ExceptionHandler(EmptyEmailException.class)
    public ResponseEntity<Void> handleEmptyEmailException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // Password Exceptions
    @ExceptionHandler(PasswordRequirementsException.class)
    public ResponseEntity<Void> handleInvalidPasswordException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @ExceptionHandler(PasswordEmptyException.class)
    public ResponseEntity<Void> handlePasswordEmptyException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // Username Exceptions
    @ExceptionHandler(UsernameAlreadyinUseException.class)
    public ResponseEntity<Void> handleUsernameAlreadyInUseException() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
    @ExceptionHandler(UsernameEmptyException.class)
    public ResponseEntity<Void> handleUsernameEmptyException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<Void> handleResponseStatusException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

package com.api.master.loginmod.exception.custom;

public class PasswordEmptyException extends RuntimeException {
    public PasswordEmptyException() {
        super("Password cannot be empty.");
    }
}

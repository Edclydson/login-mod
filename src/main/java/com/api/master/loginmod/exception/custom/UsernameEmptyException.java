package com.api.master.loginmod.exception.custom;

public class UsernameEmptyException extends RuntimeException{
    public UsernameEmptyException() {
        super("Username cannot be empty");
    }
}

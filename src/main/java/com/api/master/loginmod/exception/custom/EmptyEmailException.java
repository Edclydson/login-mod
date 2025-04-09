package com.api.master.loginmod.exception.custom;

public class EmptyEmailException extends RuntimeException{
    public EmptyEmailException() {
        super("Email cannot be empty");
    }
}

package com.api.master.loginmod.exception.custom;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException() {
        super("Invalid email format.");
    }


}

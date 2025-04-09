package com.api.master.loginmod.exception.custom;

public class UsernameAlreadyinUseException extends RuntimeException {
    public UsernameAlreadyinUseException() {
        super("This username is already in use.");
    }
}

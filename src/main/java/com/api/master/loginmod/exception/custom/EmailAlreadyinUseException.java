package com.api.master.loginmod.exception.custom;

public class EmailAlreadyinUseException extends RuntimeException {
    public EmailAlreadyinUseException() {
        super("This email is already in use.");
    }
}

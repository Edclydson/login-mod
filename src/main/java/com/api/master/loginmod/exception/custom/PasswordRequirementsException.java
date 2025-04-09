package com.api.master.loginmod.exception.custom;

public class PasswordRequirementsException extends RuntimeException {
    public PasswordRequirementsException() {
        super("Password must contain at least 8 characters, including at least one uppercase letter, one lowercase letter, one number, and one special character.");
    }


}

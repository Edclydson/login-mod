package com.api.master.loginmod.exception.custom;

public class InternalServerException extends RuntimeException {
    public InternalServerException() {
        super("Internal Server Error");
    }

    public InternalServerException(Throwable cause) {
        super("Internal Server Error ",cause);
    }
}

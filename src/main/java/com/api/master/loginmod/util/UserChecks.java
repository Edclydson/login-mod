package com.api.master.loginmod.util;

public interface UserChecks {
    boolean isEmailValid(String email);
    boolean passwordRequirements(String password);
    boolean passwordEmpty(String password);
    boolean isEmailAlreadyInUse(String email);
    boolean isUsernameAlreadyInUse(String username);
}

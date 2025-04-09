package com.api.master.loginmod.validation.Password;

import com.api.master.loginmod.validation.Password.Interfaces.isPasswordEmpty;
import org.springframework.stereotype.Component;

@Component
public class PasswordEmpty implements isPasswordEmpty {
    @Override
    public boolean isPasswordEmptyCheck(String password) {
        return password.isBlank();
    }
}

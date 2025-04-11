package com.api.master.loginmod.validation.Password;

import com.api.master.loginmod.validation.Password.Interfaces.isPasswordFillRequirements;
import org.springframework.stereotype.Component;

@Component
public class PasswordRequirements implements isPasswordFillRequirements {
    @Override
    public boolean isPasswordFillRequirementsCheck(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#&()–[{}]:;',?/*~$^+=<>]).{8,}$";
        return password.matches(passwordRegex);
    }
}

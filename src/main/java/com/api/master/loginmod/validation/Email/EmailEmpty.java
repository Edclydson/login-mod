package com.api.master.loginmod.validation.Email;

import com.api.master.loginmod.validation.Email.Interfaces.isEmailEmpty;
import org.springframework.stereotype.Component;

@Component
public class EmailEmpty implements isEmailEmpty {
    @Override
    public boolean isEmailEmptyCheck(String email) {
        return email.isBlank();
    }
}

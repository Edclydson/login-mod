package com.api.master.loginmod.validation.Email;

import com.api.master.loginmod.validation.Email.Interfaces.isEmailValid;
import org.springframework.stereotype.Component;

@Component
public class EmailValid implements isEmailValid {
    @Override
    public boolean isEmailValidCheck(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
}

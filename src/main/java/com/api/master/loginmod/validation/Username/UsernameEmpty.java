package com.api.master.loginmod.validation.Username;

import com.api.master.loginmod.validation.Username.Interfaces.isUsernameEmpty;
import org.springframework.stereotype.Component;

@Component
public class UsernameEmpty implements isUsernameEmpty {
    @Override
    public boolean isUsernameEmptyCheck(String username) {
        return username.isBlank();
    }
}

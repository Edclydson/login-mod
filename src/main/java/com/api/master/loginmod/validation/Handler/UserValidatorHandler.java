package com.api.master.loginmod.validation.Handler;

import com.api.master.loginmod.model.dto.CreateUserDTO;
import com.api.master.loginmod.validation.Email.EmailEmpty;
import com.api.master.loginmod.validation.Email.EmailValid;
import com.api.master.loginmod.validation.Handler.Interfaces.UserValidator;
import com.api.master.loginmod.validation.Password.PasswordEmpty;
import com.api.master.loginmod.validation.Password.PasswordRequirements;
import com.api.master.loginmod.validation.Username.UsernameEmpty;
import org.springframework.stereotype.Component;


@Component
public class UserValidatorHandler implements UserValidator {

    private final EmailEmpty emailEmpty;
    private final EmailValid emailValid;
    private final PasswordEmpty passwordEmpty;
    private final PasswordRequirements passwordRequirements;
    private final UsernameEmpty usernameEmpty;


    public UserValidatorHandler(EmailEmpty emailEmpty, EmailValid emailValid, PasswordEmpty passwordEmpty, PasswordRequirements passwordRequirements, UsernameEmpty usernameEmpty) {
        this.emailEmpty = emailEmpty;
        this.emailValid = emailValid;
        this.passwordEmpty = passwordEmpty;
        this.passwordRequirements = passwordRequirements;
        this.usernameEmpty = usernameEmpty;
    }


    @Override
    public boolean userIsValid(CreateUserDTO createUserDTO) {
        return !usernameEmpty.isUsernameEmptyCheck(createUserDTO.userName()) &&
                !emailEmpty.isEmailEmptyCheck(createUserDTO.email()) &&
                emailValid.isEmailValidCheck(createUserDTO.email()) &&
                passwordRequirements.isPasswordFillRequirementsCheck(createUserDTO.userPassword()) &&
                !passwordEmpty.isPasswordEmptyCheck(createUserDTO.userPassword());
    }
}

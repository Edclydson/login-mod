package com.api.master.loginmod.validation.Handler;

import com.api.master.loginmod.exception.custom.*;
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
    public void userIsValid(CreateUserDTO createUserDTO) {
        if(usernameEmpty.isUsernameEmptyCheck(createUserDTO.userName())){
            throw new UsernameEmptyException();
        }
        if(emailEmpty.isEmailEmptyCheck(createUserDTO.email())){
            throw new EmptyEmailException();
        }
        if(!emailValid.isEmailValidCheck(createUserDTO.email())){
            throw new InvalidEmailException();
        }
        if(!passwordRequirements.isPasswordFillRequirementsCheck(createUserDTO.userPassword())){
            throw new PasswordRequirementsException();
        }
        if(passwordEmpty.isPasswordEmptyCheck(createUserDTO.userPassword())){
            throw new PasswordEmptyException();
        }
    }
}

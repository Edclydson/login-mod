package com.api.master.loginmod.validation.Handler;

import com.api.master.loginmod.exception.custom.EmailAlreadyinUseException;
import com.api.master.loginmod.model.dto.CreateUserDTO;
import com.api.master.loginmod.validation.Email.EmailAlreadyInUse;
import com.api.master.loginmod.validation.Handler.Interfaces.UniqueUserValidator;
import com.api.master.loginmod.validation.Username.UsernameAlreadyInUse;
import org.springframework.stereotype.Component;

@Component
public class UniqueUserValidatorHandler implements UniqueUserValidator {

    private final EmailAlreadyInUse emailAlreadyInUse;
    private final UsernameAlreadyInUse usernameAlreadyInUse;

    public UniqueUserValidatorHandler(EmailAlreadyInUse emailAlreadyInUse, UsernameAlreadyInUse usernameAlreadyInUse) {
        this.emailAlreadyInUse = emailAlreadyInUse;
        this.usernameAlreadyInUse = usernameAlreadyInUse;
    }

    @Override
    public boolean userIsNotUnique(CreateUserDTO createUserDTO) {
        if(emailAlreadyInUse.isEmailAreadyUsedCheck(createUserDTO.email())){
            throw new EmailAlreadyinUseException();
        }
        if(usernameAlreadyInUse.isUsernameAlreadyInUseCheck(createUserDTO.userName())){
            throw new EmailAlreadyinUseException();
        }
        return true;
    }
}

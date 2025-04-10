package com.api.master.loginmod.validation.Handler.Interfaces;

import com.api.master.loginmod.model.dto.CreateUserDTO;

public interface UniqueUserValidator {
    void userIsUnique(CreateUserDTO createUserDTO);
}

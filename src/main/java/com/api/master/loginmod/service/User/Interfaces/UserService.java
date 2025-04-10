package com.api.master.loginmod.service.User.Interfaces;

import com.api.master.loginmod.model.dto.CreateUserDTO;

public interface UserService {
    void saveNewUser(CreateUserDTO createUserDTO);
}

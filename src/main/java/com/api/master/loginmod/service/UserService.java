package com.api.master.loginmod.service;

import com.api.master.loginmod.model.dto.CreateUserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    String getUserEmail(String userEmail);
    String getUserName(String userId);
    String getUserId(String userId);
    String getUserPassword(String userId);
    ResponseEntity<Void> saveUser(CreateUserDTO createUserDTO);
}

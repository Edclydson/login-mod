package com.api.master.loginmod.service.impl;

import com.api.master.loginmod.model.Role;
import com.api.master.loginmod.model.User;
import com.api.master.loginmod.model.dto.CreateUserDTO;
import com.api.master.loginmod.repository.UserRepository;
import com.api.master.loginmod.service.UserService;
import com.api.master.loginmod.util.Validations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Validations checker;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, Validations checker) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.checker = checker;
    }

    @Override
    public String getUserEmail(String userEmail) {
        // Implementation to get user email
        //UserRec usuario = userRepository.findUserByEmail(userEmail);
        //return usuario.getEmail();
        return "";
    }

    @Override
    public String getUserName(String userId) {
        // Implementation to get username
        return null;
    }

    @Override
    public String getUserId(String userId) {
        // Implementation to get user ID
        return null;
    }

    @Override
    public String getUserPassword(String userId) {
        // Implementation to get user password
        return null;
    }

    @Override
    public ResponseEntity<Void> saveUser(CreateUserDTO createUserDTO) {
        // Implementation to save user
        if (checker.isEmailAlreadyInUse(createUserDTO.email()) ||
                checker.passwordEmpty(createUserDTO.userPassword())) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        else {
            try {
                User user = new User();
                user.setUserName(createUserDTO.userName());
                user.setUserPassword(passwordEncoder.encode(createUserDTO.userPassword()));
                user.setEmail(createUserDTO.email());
                user.setRoles(Role.USER.getRoleName());
                userRepository.save(user);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            catch (ResponseStatusException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
    }
}

package com.api.master.loginmod.service.User;

import com.api.master.loginmod.exception.custom.InternalServerException;
import com.api.master.loginmod.model.Role;
import com.api.master.loginmod.model.User;
import com.api.master.loginmod.model.dto.CreateUserDTO;
import com.api.master.loginmod.repository.UserRepository;
import com.api.master.loginmod.service.User.Interfaces.UserService;
import com.api.master.loginmod.validation.Handler.UniqueUserValidatorHandler;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserRegistrationService implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UniqueUserValidatorHandler userValidator;

    public UserRegistrationService(UserRepository userRepository,
                                   PasswordEncoder passwordEncoder,
                                   UniqueUserValidatorHandler userValidator) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userValidator = userValidator;
    }

    @Override
    public void saveNewUser(CreateUserDTO createUserDTO) {
        userValidator.userIsUnique(createUserDTO);
        try {
            User user = new User();
            user.setUserName(createUserDTO.userName());
            user.setUserPassword(passwordEncoder.encode(createUserDTO.userPassword()));
            user.setEmail(createUserDTO.email());
            user.setRoles(Role.USER.getRoleName());
            userRepository.save(user);
        }
        catch (ResponseStatusException e) {
            throw new InternalServerException();
        }
    }
}

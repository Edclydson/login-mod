package com.api.master.loginmod.validation.Username;

import com.api.master.loginmod.model.User;
import com.api.master.loginmod.repository.UserRepository;
import com.api.master.loginmod.validation.Username.Interfaces.isUsernameAlreadyinUse;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsernameAlreadyInUse implements isUsernameAlreadyinUse {

    private final UserRepository userRepository;

    public UsernameAlreadyInUse(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isUsernameAlreadyInUseCheck(String username) {
        Optional<User> baseUser = userRepository.findUserByUserName(username);
        return baseUser.isPresent();
    }
}

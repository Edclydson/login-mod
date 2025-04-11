package com.api.master.loginmod.validation.Email;

import com.api.master.loginmod.model.User;
import com.api.master.loginmod.repository.UserRepository;
import com.api.master.loginmod.validation.Email.Interfaces.isEmailAlreadyUsed;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmailAlreadyInUse implements isEmailAlreadyUsed {

    private final UserRepository userRepository;

    public EmailAlreadyInUse(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isEmailAlreadyUsedCheck(String email) {
        Optional<User> baseEmail = userRepository.findByEmail(email);
        return baseEmail.isPresent();
    }
}

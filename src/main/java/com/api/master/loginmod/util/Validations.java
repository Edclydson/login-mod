package com.api.master.loginmod.util;

import com.api.master.loginmod.model.User;
import com.api.master.loginmod.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Validations implements UserChecks{

    private final UserRepository userRepository;

    public Validations(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isEmailValid(String email) {
            // Check if the email is in a valid format
            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            return email.matches(emailRegex);
    }

    @Override
    public boolean passwordRequirements(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9])(?=.{8,}).*$";
        return password.matches(passwordRegex);
    }

    @Override
    public boolean passwordEmpty(String password) {
        return password.isBlank();
    }

    @Override
    public boolean isEmailAlreadyInUse(String email) {
        Optional<User> baseEmail = userRepository.findByEmail(email);
        return baseEmail.isPresent();
    }

    @Override
    public boolean isUsernameAlreadyInUse(String username) {
        Optional<User> baseUser = userRepository.findUserByUserName(username);
        return baseUser.isPresent();
    }
}

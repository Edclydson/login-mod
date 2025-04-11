package com.api.master.loginmod.validation.Email;

import com.api.master.loginmod.model.User;
import com.api.master.loginmod.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.openMocks;

@ActiveProfiles("test")
class EmailAlreadyInUseTest {

    @Mock
    UserRepository userRepository;
    @Mock
    User user;

    @InjectMocks
    EmailAlreadyInUse emailAlreadyInUse;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @DisplayName("Should verify if the email is already in use and return false")
    void isEmailAlreadyUsedCheckSuccess() {
        Mockito.when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        boolean result = emailAlreadyInUse.isEmailAlreadyUsedCheck("teste@teste.com");

        Assertions.assertFalse(result);
        Mockito.verify(userRepository, Mockito.times(1)).findByEmail(anyString());

    }

    @Test
    @DisplayName("Should verify if the email is already in use and return true")
    void isEmailAlreadyUsedCheckFail() {
        Mockito.when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));

        boolean result = emailAlreadyInUse.isEmailAlreadyUsedCheck("teste@teste.com");

        Assertions.assertTrue(result);
        Mockito.verify(userRepository, Mockito.times(1)).findByEmail(anyString());

    }
}
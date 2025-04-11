package com.api.master.loginmod.validation.Username;

import com.api.master.loginmod.model.User;
import com.api.master.loginmod.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.openMocks;

@ActiveProfiles("test")
class UsernameAlreadyInUseTest {

    @InjectMocks
    UsernameAlreadyInUse usernameAlreadyInUse;

    @Mock
    UserRepository userRepository;
    @Mock
    User user;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @DisplayName("Should verify if the username is already in use and return false")
    void isUsernameAlreadyInUseCheckSuccess() {
        boolean result = usernameAlreadyInUse.isUsernameAlreadyInUseCheck("testUser");
        assertFalse(result);
    }

    @Test
    @DisplayName("Should verify if the username is already in use and return true")
    void isUsernameAlreadyInUseCheckFail() {
        Mockito.when(userRepository.findUserByUserName(anyString())).thenReturn(Optional.of(user));
        boolean result = usernameAlreadyInUse.isUsernameAlreadyInUseCheck("testUser");
        assertTrue(result);
    }
}
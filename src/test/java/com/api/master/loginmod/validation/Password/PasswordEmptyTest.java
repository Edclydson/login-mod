package com.api.master.loginmod.validation.Password;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.MockitoAnnotations.openMocks;

@ActiveProfiles("test")
class PasswordEmptyTest {

    @InjectMocks
    PasswordEmpty passwordEmpty;


    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @DisplayName("Should verify if the password is empty and return false")
    void isPasswordEmptyCheckSuccess() {
        boolean result = passwordEmpty.isPasswordEmptyCheck("password");
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Should verify if the password is empty and return true")
    void isPasswordEmptyCheckFail() {
        boolean result = passwordEmpty.isPasswordEmptyCheck("");
        Assertions.assertTrue(result);
    }

}
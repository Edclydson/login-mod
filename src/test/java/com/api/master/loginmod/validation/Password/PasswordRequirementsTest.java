package com.api.master.loginmod.validation.Password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.MockitoAnnotations.openMocks;

@ActiveProfiles("test")
class PasswordRequirementsTest {

    @InjectMocks
    PasswordRequirements passwordRequirements;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @DisplayName("Should verify if the password meets the requirements and return true")
    void isPasswordFillRequirementsCheck() {
        String password = "Password123!";
        boolean result = passwordRequirements.isPasswordFillRequirementsCheck(password);
        assertTrue(result);
    }

    @ParameterizedTest
            @ValueSource(strings = {
            "password",
            "PASSWORD",
            "12345678",
            "Password",
            "Password123",
            "Password!",
            "password123!",
            "PASSWORD123!",
            "Pass123"
    })
    @DisplayName("Should verify if the password meets the requirements and return false")
    void isPasswordFillRequirementsCheckFail(String password) {
        boolean result = passwordRequirements.isPasswordFillRequirementsCheck(password);
        assertFalse(result);
    }
}
package com.api.master.loginmod.validation.Email;

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
class EmailValidTest {
    @InjectMocks
    EmailValid emailValid;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @DisplayName("Should verify if the email is valid and return true")
    void isEmailValidCheckSuccess() {
        boolean result = emailValid.isEmailValidCheck("teste@teste.com");
        assertTrue(result);
    }
    @ParameterizedTest
    @DisplayName("Should verify if the email is valid and return false")
    @ValueSource(strings = {
            "testeteste.com",
            "testeteste@.com",
            "testeteste@teste",
            "testeteste@teste.",
            "@teste.com",
            "teste@teste..com",
            "teste@teste.c",
            "teste@.com"
    })
    void isEmailValidCheckFail(String email) {
        boolean result = emailValid.isEmailValidCheck(email);
        assertFalse(result);
    }
}
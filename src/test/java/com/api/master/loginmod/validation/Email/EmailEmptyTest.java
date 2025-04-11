package com.api.master.loginmod.validation.Email;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.MockitoAnnotations.openMocks;

@ActiveProfiles("test")
class EmailEmptyTest {

    @InjectMocks
    EmailEmpty emailEmpty;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @DisplayName("Should verify if the email is empty and return false")
    void isEmailEmptyCheckSuccess() {
        boolean result = emailEmpty.isEmailEmptyCheck("teste@teste.com");
        assertFalse(result);
    }
    @Test
    @DisplayName("Should verify if the email is empty and return true")
    void isEmailEmptyCheckFail() {
        boolean result = emailEmpty.isEmailEmptyCheck(" ");
        assertTrue(result);
    }
}
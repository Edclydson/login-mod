package com.api.master.loginmod.validation.Username;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.MockitoAnnotations.openMocks;

class UsernameEmptyTest {

    @InjectMocks
    UsernameEmpty usernameEmpty;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @DisplayName("Should verify if the username is empty and return false")
    void isUsernameEmptyCheckSuccess() {
        boolean result = usernameEmpty.isUsernameEmptyCheck("testUser");
        assertFalse(result);
    }

    @Test
    @DisplayName("Should verify if the username is empty and return true")
    void isUsernameEmptyCheckFail() {
        boolean result = usernameEmpty.isUsernameEmptyCheck("");
        assertTrue(result);
    }
}
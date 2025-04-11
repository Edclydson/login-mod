package com.api.master.loginmod.validation.Handler;

import com.api.master.loginmod.model.dto.CreateUserDTO;
import com.api.master.loginmod.validation.Email.EmailEmpty;
import com.api.master.loginmod.validation.Email.EmailValid;
import com.api.master.loginmod.validation.Password.PasswordEmpty;
import com.api.master.loginmod.validation.Password.PasswordRequirements;
import com.api.master.loginmod.validation.Username.UsernameEmpty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.openMocks;

@ActiveProfiles("test")
class UserValidatorHandlerTest {

    @Mock
    EmailEmpty emailEmpty;
    @Mock
    EmailValid emailValid;
    @Mock
    PasswordEmpty passwordEmpty;
    @Mock
    PasswordRequirements passwordRequirements;
    @Mock
    UsernameEmpty usernameEmpty;
    @Mock
    CreateUserDTO createUserDTO;

    @InjectMocks
    UserValidatorHandler userValidatorHandler;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @DisplayName("Should verify if the email and username are empty, " +
            "if the password fills the requirements or is empty and if the email is valid")
    void userIsValidSuccess() {

        Mockito.when(usernameEmpty.isUsernameEmptyCheck(anyString())).thenReturn(false);
        Mockito.when(emailEmpty.isEmailEmptyCheck(anyString())).thenReturn(false);
        Mockito.when(emailValid.isEmailValidCheck(anyString())).thenReturn(true);
        Mockito.when(passwordRequirements.isPasswordFillRequirementsCheck(anyString())).thenReturn(true);
        Mockito.when(passwordEmpty.isPasswordEmptyCheck(anyString())).thenReturn(false);

        Mockito.when(createUserDTO.userName()).thenReturn("teste");
        Mockito.when(createUserDTO.userPassword()).thenReturn("Pass-w0rd");
        Mockito.when(createUserDTO.email()).thenReturn("teste@teste.com");

        userValidatorHandler.userIsValid(createUserDTO);

        Mockito.verify(usernameEmpty, Mockito.times(1)).isUsernameEmptyCheck(anyString());
        Mockito.verify(emailEmpty, Mockito.times(1)).isEmailEmptyCheck(anyString());
        Mockito.verify(emailValid, Mockito.times(1)).isEmailValidCheck(anyString());
        Mockito.verify(passwordRequirements, Mockito.times(1)).isPasswordFillRequirementsCheck(anyString());
        Mockito.verify(passwordEmpty, Mockito.times(1)).isPasswordEmptyCheck(anyString());
    }
}
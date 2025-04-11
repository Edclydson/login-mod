package com.api.master.loginmod.validation.Handler;

import com.api.master.loginmod.exception.custom.EmailAlreadyinUseException;
import com.api.master.loginmod.exception.custom.UsernameAlreadyinUseException;
import com.api.master.loginmod.model.dto.CreateUserDTO;
import com.api.master.loginmod.validation.Email.EmailAlreadyInUse;
import com.api.master.loginmod.validation.Username.UsernameAlreadyInUse;
import org.junit.jupiter.api.Assertions;
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
class UniqueUserValidatorHandlerTest {

    @Mock
    EmailAlreadyInUse emailAlreadyInUse;
    @Mock
    UsernameAlreadyInUse usernameAlreadyInUse;
    @Mock
    CreateUserDTO createUserDTO;
    @InjectMocks
    UniqueUserValidatorHandler uniqueUserValidatorHandler;


    @BeforeEach
    void setUp() {
        openMocks(this);
        createUserDTO = new CreateUserDTO("teste","Teste@123","teste@teste.com");
    }

    @Test
    @DisplayName("Should verify if the email and username are unique and find nothing wrong")
    void userIsUniqueSuccess() {
        Mockito.when(emailAlreadyInUse.isEmailAlreadyUsedCheck(anyString())).thenReturn(false);
        Mockito.when(usernameAlreadyInUse.isUsernameAlreadyInUseCheck(anyString())).thenReturn(false);

        uniqueUserValidatorHandler.userIsUnique(createUserDTO);

        Mockito.verify(emailAlreadyInUse, Mockito.times(1)).isEmailAlreadyUsedCheck(anyString());
        Mockito.verify(usernameAlreadyInUse, Mockito.times(1)).isUsernameAlreadyInUseCheck(anyString());
    }

    @Test
    @DisplayName("Should verify if the email and find an email already in use")
    void userIsUniqueFail1() {
        Mockito.doThrow(new EmailAlreadyinUseException()).when(emailAlreadyInUse).isEmailAlreadyUsedCheck(anyString());
        Assertions.assertThrowsExactly(EmailAlreadyinUseException.class, () -> uniqueUserValidatorHandler.userIsUnique(createUserDTO));
    }

    @Test
    @DisplayName("Should verify if the username and find an username already in use")
    void userIsUniqueFail2() {
        Mockito.doThrow(new UsernameAlreadyinUseException()).when(usernameAlreadyInUse).isUsernameAlreadyInUseCheck(anyString());
        Assertions.assertThrowsExactly(UsernameAlreadyinUseException.class, () -> uniqueUserValidatorHandler.userIsUnique(createUserDTO));
    }
}
package com.api.master.loginmod.service.User;

import com.api.master.loginmod.exception.custom.EmailAlreadyinUseException;
import com.api.master.loginmod.exception.custom.InternalServerException;
import com.api.master.loginmod.exception.custom.UsernameAlreadyinUseException;
import com.api.master.loginmod.model.dto.CreateUserDTO;
import com.api.master.loginmod.repository.UserRepository;
import com.api.master.loginmod.validation.Email.EmailAlreadyInUse;
import com.api.master.loginmod.validation.Handler.UniqueUserValidatorHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.openMocks;


@ActiveProfiles("test")
class UserRegistrationServiceTest {

    UserRegistrationService userRegistrationServiceMocked;
    @Mock
    CreateUserDTO userMocked;
    @Mock
    UserRepository userRepositoryMocked;
    @Mock
    UniqueUserValidatorHandler userValidatorMocked;
    @Mock
    PasswordEncoder passwordEncoderMocked;
    @Mock
    EmailAlreadyInUse emailAlreadyInUseMocked;

    @BeforeEach
    void setUp() {
        openMocks(this);
        userMocked = new CreateUserDTO("testUser", "test#Passw0rd", "testEmail@teste.com");
    }

    @Test
    @DisplayName("Should register a user successfully")
    void saveNewUserSuccess() {
        Mockito.doNothing().when(userValidatorMocked).userIsUnique(userMocked);
        Mockito.when(passwordEncoderMocked.encode(anyString())).thenReturn("HashedPassword");

        userRegistrationServiceMocked = new UserRegistrationService(userRepositoryMocked, passwordEncoderMocked, userValidatorMocked);
        Assertions.assertDoesNotThrow(() -> userRegistrationServiceMocked.saveNewUser(userMocked));

    }

    @Test
    @DisplayName("Should raise a EmailAlreadyInUseException when user tries to register")
    void saveNewUserThrowEmailAlreadyInUseException() {
        Mockito.when(emailAlreadyInUseMocked.isEmailAreadyUsedCheck(anyString())).thenReturn(Boolean.valueOf(userMocked.email()));
        Mockito.when(passwordEncoderMocked.encode(anyString())).thenReturn("HashedPassword");
        Mockito.doThrow(new EmailAlreadyinUseException()).when(userValidatorMocked).userIsUnique(userMocked);

        userRegistrationServiceMocked = new UserRegistrationService(userRepositoryMocked, passwordEncoderMocked, userValidatorMocked);
        Assertions.assertThrows(EmailAlreadyinUseException.class, () -> userRegistrationServiceMocked.saveNewUser(userMocked));
    }

    @Test
    @DisplayName("Should raise a UsernameAlreadyInUseException when user tries to register")
    void saveNewUserThrowUsernameAlreadyInUseException() {
        Mockito.when(emailAlreadyInUseMocked.isEmailAreadyUsedCheck(anyString())).thenReturn(Boolean.valueOf(userMocked.userName()));
        Mockito.when(passwordEncoderMocked.encode(anyString())).thenReturn("HashedPassword");
        Mockito.doThrow(new UsernameAlreadyinUseException()).when(userValidatorMocked).userIsUnique(userMocked);

        userRegistrationServiceMocked = new UserRegistrationService(userRepositoryMocked, passwordEncoderMocked, userValidatorMocked);
        Assertions.assertThrows(UsernameAlreadyinUseException.class, () -> userRegistrationServiceMocked.saveNewUser(userMocked));
    }

    @Test
    @DisplayName("Should raise a InternalServerException when user tries to register")
    void saveNewUserThrowInternalServerException() {
        Mockito.when(emailAlreadyInUseMocked.isEmailAreadyUsedCheck(anyString())).thenReturn(Boolean.valueOf(userMocked.userName()));
        Mockito.when(passwordEncoderMocked.encode(anyString())).thenReturn("HashedPassword");

        Mockito.doThrow(new InternalServerException()).when(userValidatorMocked).userIsUnique(userMocked);

        userRegistrationServiceMocked = new UserRegistrationService(userRepositoryMocked, passwordEncoderMocked, userValidatorMocked);
        Assertions.assertThrows(InternalServerException.class, () -> userRegistrationServiceMocked.saveNewUser(userMocked));
    }

}
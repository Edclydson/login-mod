package com.api.master.loginmod.model;

import com.api.master.loginmod.model.dto.LoginRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class User {

        @Id
        @Column(nullable = false, unique = true, name = "user_id")
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID userId;

        @Column(nullable = false, length = 50, name = "user_name")
        @NotEmpty(message = "Name cannot be empty")
        private String userName;

        @Column(nullable = false, name = "user_password")
        @NotEmpty(message = "Password cannot be empty")
        private String userPassword;

        @Column(nullable = false, unique = true, length = 50, name = "user_email")
        @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
        @NotEmpty(message = "Email cannot be empty")
        private String email;

        @Column(nullable = false, name = "user_role", length = 10)
        @NotEmpty(message = "Role cannot be empty")
        private String roles;


        public String getRoles() {
                return roles;
        }

        public void setRoles(String roles) {
                this.roles = roles;
        }

        public UUID getUserId() {
                return userId;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getUserPassword() {
                return userPassword;
        }

        public void setUserPassword(String userPassword) {
                this.userPassword = userPassword;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public boolean loginIsCorrect(LoginRequest loginRequest, PasswordEncoder passwordEncoder){
                return passwordEncoder.matches(loginRequest.password(), this.userPassword);
        }
}

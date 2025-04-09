package com.api.master.loginmod.controller;

import com.api.master.loginmod.model.dto.LoginRequest;
import com.api.master.loginmod.model.dto.LoginResponse;
import com.api.master.loginmod.repository.UserRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/login")
//@SecurityRequirement(name = Security.SECURITY)
public class TokenController {

    private final JwtEncoder jwtEncoder;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public TokenController(JwtEncoder jwtEncoder, BCryptPasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.jwtEncoder = jwtEncoder;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        var user = userRepository.findByEmail(loginRequest.email());
        if (user.isEmpty() || !user.get().loginIsCorrect(loginRequest, passwordEncoder)) {
            throw new BadCredentialsException("Invalid credentials");
        } else {
            var now = Instant.now();
            var expirationTime = 300;
            var scopes = user.get().getRoles();
            var claims = JwtClaimsSet.builder()
                    .issuer("My-BE")
                    .subject(user.get().getUserId().toString())
                    .issuedAt(now)
                    .expiresAt(now.plusSeconds(expirationTime))
                    .claim("scope", scopes)
                    .build();
            var token = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
            return ResponseEntity.ok(new LoginResponse(token,(long)expirationTime));
        }
    }
}

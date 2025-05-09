package com.fatiharge.user.service;


import com.fatiharge.shared.user.dto.auth.LoginRequest;
import com.fatiharge.shared.user.dto.auth.TokenResponse;
import com.fatiharge.user.domain.User;
import com.fatiharge.user.exception.UserNotFoundException;
import com.fatiharge.user.repository.UserRepository;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.Instant;


@ApplicationScoped
public class AuthService {

    @Inject
    UserRepository userRepository;


    public TokenResponse login(LoginRequest request) {
        User user = userRepository.findByEmailAndPassword(request.mail,
                                                          request.password
        );
        if (user == null) {
            throw new UserNotFoundException();
        }



        String token = createToken(user.id.toString(), user.role);
        String refreshToken = createRefreshToken(user.id.toString(), user.role);

        return TokenResponse.builder()
                .token(token)
                .refreshToken(refreshToken)
                .build();
    }


    public TokenResponse refreshToken(Long userId, String refreshToken) {
        User user = userRepository.findById(userId);

        String token = createToken(userId.toString(), user.role);

        return TokenResponse.builder()
                .token(token)
                .refreshToken(refreshToken)
                .build();

    }

    private String createToken(String userId, String userRole) {
        return Jwt.subject(userId)
                .expiresAt(Instant.now().plusSeconds(600))
                .issuedAt(Instant.now())
                .groups(userRole)
                .sign();
    }

    private String createRefreshToken(String userId, String userRole) {
        return Jwt.subject(userId)
                .expiresAt(Instant.now().plusSeconds(60 * 60 * 24))
                .issuedAt(Instant.now())
                .claim("refresh", true)
                .groups(userRole)
                .sign();
    }


}
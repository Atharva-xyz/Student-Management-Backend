
package com.atharva.studentmanagement.service;

import com.atharva.studentmanagement.dto.AuthResponse;
import com.atharva.studentmanagement.dto.LoginRequest;
import com.atharva.studentmanagement.dto.RegisterRequest;
import com.atharva.studentmanagement.entity.AppUser;
import com.atharva.studentmanagement.repository.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            AppUserRepository appUserRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse register(RegisterRequest request) {
        if (appUserRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email already registered");
        }

        AppUser user = new AppUser(
                request.name(),
                request.email(),
                passwordEncoder.encode(request.password()));

        appUserRepository.save(user);

        return new AuthResponse(
                jwtService.generateToken(user.getEmail()),
                "Registration successful");
    }

    public AuthResponse login(LoginRequest request) {
        AppUser user = appUserRepository.findByEmail(request.email())
                .orElseThrow(() ->
                    new IllegalArgumentException("Invalid email or password"));

        if (!passwordEncoder.matches(
                request.password(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        return new AuthResponse(
                jwtService.generateToken(user.getEmail()),
                "Login successful");
    }
}

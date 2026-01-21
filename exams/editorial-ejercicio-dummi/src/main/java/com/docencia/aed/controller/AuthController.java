package com.docencia.aed.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.docencia.aed.infrastructure.security.JwtService;
import com.docencia.aed.service.impl.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Map;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication API")
@CrossOrigin
public class AuthController {

    private final AuthService service;
    private final JwtService jwtService;

    public AuthController(JwtService jwtService, AuthService service) {
        this.jwtService = jwtService;
        this.service = service;
    }

    public record LoginRequest(@NotBlank String username, @NotBlank String password) {
    }

    @PostMapping("/login")
    @Operation(summary = "Login with credentials")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginRequest req) {
        if (!service.credentialValidator(req.username, req.password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("token", jwtService.generateToken(req.username)));
    }
}

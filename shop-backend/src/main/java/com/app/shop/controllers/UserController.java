package com.app.shop.controllers;

import com.app.shop.configuration.security.JwtService;
import com.app.shop.entities.User;
import com.app.shop.exceptions.UserAlreadyExistsException;
import com.app.shop.exceptions.ValidationException;
import com.app.shop.model.request.LoginRequest;
import com.app.shop.model.request.UserCreateRequest;
import com.app.shop.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Validated
@Slf4j
public class UserController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) throws
            ValidationException, UserAlreadyExistsException {
        log.info("Request received for new user creation {}", userCreateRequest);
        User user = authenticationService.createUser(userCreateRequest);
        log.info("User created successfully {}", user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@Valid @RequestBody LoginRequest loginRequest) {
        log.info("Request received for logging in {}", loginRequest.getUsername());
        String jwtToken = authenticationService.authenticate(loginRequest);
        log.info("Token generated: {}", jwtToken);
        return new ResponseEntity<>(jwtToken, HttpStatus.OK);
    }
}

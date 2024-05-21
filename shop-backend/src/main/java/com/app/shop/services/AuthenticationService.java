package com.app.shop.services;

import com.app.shop.configuration.security.JwtService;
import com.app.shop.entities.User;
import com.app.shop.exceptions.PasswordsDoNotMatchException;
import com.app.shop.exceptions.UserAlreadyExistsException;
import com.app.shop.model.request.LoginRequest;
import com.app.shop.model.request.UserCreateRequest;
import com.app.shop.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenticationService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public User createUser(UserCreateRequest userCreateRequest) {
        if(!userCreateRequest.getPassword().equals(userCreateRequest.getConfirmPassword())) {
            log.error("passwords do not match");
            throw new PasswordsDoNotMatchException("passwords do not match");
        }
        usernameAlreadyExists(userCreateRequest.getEmail());
        User newUser = new User();
        newUser.setFullName(userCreateRequest.getUserFullName());
        newUser.setEmail(userCreateRequest.getEmail());
        newUser.setPassword(bCryptPasswordEncoder.encode(userCreateRequest.getPassword()));
        return userRepository.save(newUser);
    }

    public String authenticate(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtService.generateToken((User)authentication.getPrincipal());
    }

    public void usernameAlreadyExists(String username) {
        if (username!=null && !username.isBlank() && userRepository.existsByEmail(username)) {
            log.error("Username already exists {}", username);
            throw new UserAlreadyExistsException(username.concat(" already exist"));
        }
    }

}

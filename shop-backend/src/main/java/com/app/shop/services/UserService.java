package com.app.shop.services;

import com.app.shop.entities.User;
import com.app.shop.model.request.UserCreateRequest;
import com.app.shop.repositories.UserRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreateRequest userCreateRequest) throws ValidationException {
        User newUser = new User();
        newUser.setFullName("James");
        newUser.setEmail(userCreateRequest.getEmail());
        newUser.setPassword(bCryptPasswordEncoder.encode(userCreateRequest.getPassword()));
        return userRepository.save(newUser);
    }
}

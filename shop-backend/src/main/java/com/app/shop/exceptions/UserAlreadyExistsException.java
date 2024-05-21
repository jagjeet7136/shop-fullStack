package com.app.shop.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException() {}
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

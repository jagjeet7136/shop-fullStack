package com.app.shop.exceptions;

public class PasswordsEmptyException extends RuntimeException{
    public PasswordsEmptyException(String message) {
        super(message);
    }
}

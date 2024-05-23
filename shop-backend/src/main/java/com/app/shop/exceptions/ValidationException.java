package com.app.shop.exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException() {}
    public ValidationException(String message) {
        super(message);
    }
}

package com.app.shop.exceptions;

public class NotFoundException extends Exception{
    public NotFoundException() {}
    public NotFoundException(String message) {
        super(message);
    }
}

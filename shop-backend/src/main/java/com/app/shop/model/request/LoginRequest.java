package com.app.shop.model.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;

    private String password;
}

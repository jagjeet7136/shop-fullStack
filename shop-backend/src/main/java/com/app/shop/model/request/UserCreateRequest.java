package com.app.shop.model.request;

import lombok.Data;

@Data
public class UserCreateRequest {

    private String email;

    private String password;
}

package com.app.shop.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateRequest {

    @NotBlank(message = "full name is required.")
    @Size(min = 2, max = 100, message = "name should between 2 and 100 characters.")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "name should only contain letters and spaces.")
    private String userFullName;

    @NotBlank(message = "email address is required.")
    @Email(message = "email address is invalid.", flags = { Pattern.Flag.CASE_INSENSITIVE })
    private String email;

    @NotBlank(message = "password is required")
    @Size(min = 6, max = 100, message = "password should between 6 and 100 characters.")
    private String password;

    @NotBlank(message = "confirm password is required")
    @Size(min = 6, max = 100, message = "password should between 6 and 100 characters.")
    private String confirmPassword;

}
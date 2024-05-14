package com.xdracon.authentication.dtos;

import lombok.Data;

@Data
public class RegistrationUserDto {
    private String username;
    private String password;
    private String confirmPassword;
    private String firstname;
    private String surname;
    private String patronymic;
    private String phonenumber;
}


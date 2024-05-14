package com.xdracon.authentication.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String firstname;
    private String surname;
    private String patronymic;
    private String phonenumber;
}


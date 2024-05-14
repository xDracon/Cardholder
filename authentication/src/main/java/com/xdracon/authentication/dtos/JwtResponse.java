package com.xdracon.authentication.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    public JwtResponse(JwtResponse jwtResponse){
        this.token=jwtResponse.token;
    }
}



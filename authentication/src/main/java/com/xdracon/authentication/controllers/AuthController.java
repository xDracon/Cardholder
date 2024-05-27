package com.xdracon.authentication.controllers;

import com.xdracon.authentication.dtos.JwtResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.xdracon.authentication.dtos.JwtRequest;
import com.xdracon.authentication.dtos.RegistrationUserDto;
import com.xdracon.authentication.service.AuthService;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @RequestMapping("/")
    public String hello() {
        return "welcome";
    }

    @RequestMapping("/login")
    public String showSignUpForm() {
        return "login";
    }

    @RequestMapping("/registration")
    public String showRegForm() {
        return "registration";
    }

    /*@PostMapping("/login")
    public ResponseEntity<?> createAuthToken(JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }*/

    @PostMapping("/login")
    public String aut(JwtRequest authRequest, Model model){
        JwtResponse jwtResponse = new JwtResponse(authService.createAuthToken(authRequest));
        model.addAttribute("token", jwtResponse);
        return "success-login";
    }

    @PostMapping("/registration")
    public String createNewUser(RegistrationUserDto registrationUserDto) {
        authService.createNewUser(registrationUserDto);
        return "welcome";
    }
}

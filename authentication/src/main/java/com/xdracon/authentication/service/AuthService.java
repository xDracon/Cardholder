package com.xdracon.authentication.service;

import lombok.RequiredArgsConstructor;
import com.xdracon.authentication.dtos.JwtRequest;
import com.xdracon.authentication.dtos.JwtResponse;
import com.xdracon.authentication.dtos.RegistrationUserDto;
import com.xdracon.authentication.entities.User;
import com.xdracon.authentication.exceptions.AppError;
import com.xdracon.authentication.utils.JwtTokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.xdracon.authentication.dtos.UserDto;

import static com.xdracon.authentication.AuthenticationApplication.log;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    //public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
    public JwtResponse createAuthToken(@RequestBody JwtRequest authRequest) {
        //try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        //} catch (BadCredentialsException e) {
            //return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Неправильный логин или пароль"), HttpStatus.UNAUTHORIZED);
        //}
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        //return ResponseEntity.ok(new JwtResponse(token));
        log.info("Пользователь вошёл в систему");
        return (new JwtResponse(token));
    }

    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
        if (!registrationUserDto.getPassword().equals(registrationUserDto.getConfirmPassword())) {
            log.info("Пароли не совпадают");
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пароли не совпадают"), HttpStatus.BAD_REQUEST);
        }
        if (userService.findByUsername(registrationUserDto.getUsername()).isPresent()) {
            log.info("Пользователь с указанным именем уже существует");
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
        }
        User user = userService.createNewUser(registrationUserDto);
        log.info("Пользователь зарегестрирован");
        return ResponseEntity.ok(new UserDto(user.getId(), user.getUsername(), user.getFirstname(), user.getSurname(), user.getPatronymic(), user.getPhonenumber()));
    }
}

package com.xdracon.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@SpringBootApplication
public class AuthenticationApplication {
	public static final Logger log = LogManager.getLogger(AuthenticationApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}
}

package com.xdracon.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@SpringBootApplication
public class CardApplication {
	public static final Logger log = LogManager.getLogger(CardApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CardApplication.class, args);
	}
}

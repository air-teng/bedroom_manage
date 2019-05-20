package com.bedroom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bedroom.dao")
public class BedroomApplication {

	public static void main(String[] args) {
		SpringApplication.run(BedroomApplication.class, args);
	}

}

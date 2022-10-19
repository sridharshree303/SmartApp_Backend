package com.cg.pravin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartApplication {

	public static void main(String[] args) {
		System.out.println("Start");
		SpringApplication.run(SmartApplication.class, args);
		System.out.println("Stop");
	}
     
}
	 
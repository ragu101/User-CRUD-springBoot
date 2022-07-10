package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MprojectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context	= SpringApplication.run(MprojectApplication.class, args);
		Home h = context.getBean(Home.class);
		h.connect();
	}
}
   
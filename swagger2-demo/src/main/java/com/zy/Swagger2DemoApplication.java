package com.zy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zy")
public class Swagger2DemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(Swagger2DemoApplication.class, args);
	}

}

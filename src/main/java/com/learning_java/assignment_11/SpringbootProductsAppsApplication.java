package com.learning_java.assignment_11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootProductsAppsApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(SpringbootProductsAppsApplication.class, args);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}

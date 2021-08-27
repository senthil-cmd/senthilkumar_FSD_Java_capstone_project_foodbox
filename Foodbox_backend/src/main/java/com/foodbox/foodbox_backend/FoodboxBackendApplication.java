package com.foodbox.foodbox_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories("com.foodbox.Dao")
@EntityScan("com.foodbox.model")
@ComponentScan("com")
@SpringBootApplication
public class FoodboxBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodboxBackendApplication.class, args);
	}

}

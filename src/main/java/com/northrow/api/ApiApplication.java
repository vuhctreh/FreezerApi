package com.northrow.api;

import com.northrow.api.Food.FoodService;
import com.northrow.api.repository.FoodRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ApiApplication.class, args);
	}
}

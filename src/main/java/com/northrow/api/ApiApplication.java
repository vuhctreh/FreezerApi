package com.northrow.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * The type Api application.
 */
@SpringBootApplication
public class ApiApplication {

	/**
	 * Main method. Boots Spring server.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ApiApplication.class, args);
	}
}

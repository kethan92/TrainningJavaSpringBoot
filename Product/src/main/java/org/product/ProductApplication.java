package org.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"org.product"})
public class ProductApplication {

	private static final Logger logger = LoggerFactory.getLogger(ProductApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
}

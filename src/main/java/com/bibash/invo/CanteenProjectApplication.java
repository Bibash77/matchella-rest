package com.bibash.invo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories("com.bibash.invo")
@EntityScan("com.bibash.matchella")
@EnableCaching
@EnableScheduling
public class CanteenProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CanteenProjectApplication.class, args);
	}

}

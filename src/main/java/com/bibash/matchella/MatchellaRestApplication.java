package com.bibash.matchella;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories("com.bibash.matchella")
@EntityScan("com.bibash.matchella")
@EnableCaching
@EnableScheduling
public class MatchellaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatchellaRestApplication.class, args);
	}

}

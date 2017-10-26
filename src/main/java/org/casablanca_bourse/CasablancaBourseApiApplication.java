package org.casablanca_bourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CasablancaBourseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasablancaBourseApiApplication.class, args);
	}
}

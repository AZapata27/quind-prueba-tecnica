package dev.andreszapata.bankfuse.infrastructure.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "dev.andreszapata.bankfuse.infrastructure")
public class BankFuseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankFuseApplication.class, args);
	}

}

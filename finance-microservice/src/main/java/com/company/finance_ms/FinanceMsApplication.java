package com.company.finance_ms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinanceMsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FinanceMsApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("[RUNNING] Finance MS Running on port 9000");
	}
	
}
package com.tushar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ExpenseTrackingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackingApiApplication.class, args);
	}

}

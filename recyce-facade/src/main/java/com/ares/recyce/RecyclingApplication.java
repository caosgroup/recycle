package com.ares.recyce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"com.ares.recyce.*"})
@SpringBootApplication(scanBasePackages = {"com.ares.recyce"})
public class RecyclingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecyclingApplication.class, args);
	}

}

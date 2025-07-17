package com.fati.correlationidjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CorrelationIdJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorrelationIdJavaApplication.class, args);
	}

}

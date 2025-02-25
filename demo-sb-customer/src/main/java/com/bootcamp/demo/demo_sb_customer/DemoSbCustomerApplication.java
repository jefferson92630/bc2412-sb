package com.bootcamp.demo.demo_sb_customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // injcct scheduling related beans into context
public class DemoSbCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSbCustomerApplication.class, args);
	}

}

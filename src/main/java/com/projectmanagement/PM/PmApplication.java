package com.projectmanagement.PM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PmApplication {
	public static void main(String[] args) {
		SpringApplication.run(PmApplication.class, args);
	}
}

package com.usecase.instititutemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
@EnableJpaRepositories("com.usecase.instititutemanagement.repository")
@ComponentScan("com.usecase.instititutemanagement")
@EntityScan(basePackages ="com.usecase.institutemanagement")
public class InstititutemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstititutemanagementApplication.class, args);
	}
}

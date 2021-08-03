package com.usecase.instititutemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.usecase.instititutemanagement.controller.*;
import com.usecase.instititutemanagement.error.*;
import com.usecase.instititutemanagement.model.*;
import com.usecase.instititutemanagement.repository.*;
import com.usecase.instititutemanagement.payload.request.*;
import com.usecase.instititutemanagement.payload.response.*;
import com.usecase.instititutemanagement.security.*;
@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
@EnableJpaRepositories("com.usecase.instititutemanagement.repository")
@ComponentScan("com.usecase.instititutemanagement")
@EntityScan(basePackages ="com.usecase.institutemanagement")
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)

public class InstititutemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstititutemanagementApplication.class, args);
	}
}

package com.idexcel.restapi.IdexcelRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.idexcel.restapi.IdexcelRest.accountstore.accountController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan(basePackages= {"com.idexcel.restapi.IdexcelRest.accountstore"})
@EntityScan(basePackages= {"com.idexcel.restapi.IdexcelRest.accountstore"})
@EnableJpaRepositories(basePackages= {"com.idexcel.restapi.IdexcelRest.accountstore"})
@EnableSwagger2
/*
 * Main Class to Start Execution
 */
public class IdexcelRestApplication {

	public static void main(String[] args) {
		//Creating Application Context for beans
		ApplicationContext context=SpringApplication.run(IdexcelRestApplication.class, args);
		//Fetching AccountController Bean
		accountController car = context.getBean(accountController.class);
	}

}

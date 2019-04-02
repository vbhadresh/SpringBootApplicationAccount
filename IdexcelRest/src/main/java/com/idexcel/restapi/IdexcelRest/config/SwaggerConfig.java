package com.idexcel.restapi.IdexcelRest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*
 * 
 * Swagger COnfiguration Class for Swagger UI
 */
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
	
	@Bean
	public Docket Accountapi() {
		 return new Docket(DocumentationType.SWAGGER_2).
				 	select()
		            .apis(RequestHandlerSelectors
		                .basePackage("com.idexcel.restapi.IdexcelRest.accountstore"))
		            .paths(PathSelectors.regex("/account.*"))
		            .build().apiInfo(getApiInfo());
	}
	
	

	 private ApiInfo getApiInfo() {
	       ApiInfo apiInfo = new ApiInfo("Spring Boot Account Details",
	    		   "Spring Boot Account Details - Swagger UI","1.0","Terms of Service",
	    		   new Contact("Vaishnavi Bhadresh","No - website","vbhadresh@hawk.iit.edu"),
	    		   "Apache License Version 2.0","Helllo Worls");
	       return apiInfo;
	    }

	
}

package com.employee.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Component
public class SwaggerConfiguration {
	
	@Bean
	public Docket Configuration() {
		
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.employee")).build().apiInfo(apiDetails());
		
	}

	private ApiInfo apiDetails() {
		
		return new ApiInfo("EMPLOYEE PROJECT", "Employee Deatails", "v1", "", "AKSHAY HAVALE", "", "");
	}

}

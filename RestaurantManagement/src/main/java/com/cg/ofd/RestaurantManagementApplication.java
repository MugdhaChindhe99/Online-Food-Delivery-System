package com.cg.ofd;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableJpaAuditing
@SpringBootApplication
@EnableEurekaClient
public class RestaurantManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantManagementApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				   .select()
				   .paths(PathSelectors.any())
				   .apis(RequestHandlerSelectors.basePackage("com.cg.ofd"))
				   .build()
				   .apiInfo(myApiInfo());
	}
	
	private ApiInfo myApiInfo() {
		Contact contact=new Contact("Sulekha Sarkar","/stock","sarkar.sulekha20@gmail.com");
		ApiInfo apiInfo=new ApiInfo("Spring With Swagger Api","Api Creation","1.0","Free to use",contact,
				"API licence","/limits",Collections.emptyList());
		
		return apiInfo;
	}


}

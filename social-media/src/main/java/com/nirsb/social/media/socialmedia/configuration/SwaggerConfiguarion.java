package com.nirsb.social.media.socialmedia.configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Make it spring configured class
@Configuration
@EnableSwagger2 //Enabled swagger for this class
public class SwaggerConfiguarion {

	private static final Contact DEFAULT_CONTACT = new Contact("Rahul Kumar Pandey", "https://www.linkedin.com/in/rahul-kumar-pandey-b22b6684/", "rahulkumarpandeycs068@gmail.com");
	private static final ApiInfo DEFAUL_API_INFO = new ApiInfo("Social Media Application", "A new service to connect with Random Users", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	private static final Set<String> DEFAULT_API_OUTPUT_TYPE = new HashSet<String>(Arrays.asList("application/Json"
			,"application/xml"));
	private static final Set<String> DEFAULT_API_INPUT_TYPE = new HashSet<String>(Arrays.asList("application/Json"
			,"application/xml"));

	//Create a Bean to use this(Docket Bean)
	// configure swagger
	//All path and api
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAUL_API_INFO)
				.produces(DEFAULT_API_OUTPUT_TYPE)
				.consumes(DEFAULT_API_INPUT_TYPE);
	}
	
}

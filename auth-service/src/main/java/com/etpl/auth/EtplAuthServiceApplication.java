/* Copyright (C) 2020 ERNIESYS Technologies Private Limited 
 *
 * Licensed under the ETPL License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *      http://www.etpl.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package com.etpl.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author <Elavarasan Ramasamy>
 * @Date of Creation <01-July-202>
 * @Purpose <Purpose of Creating Authentication Workflow> Authentication
 *          Workflow The authentication flow is simple as: The user sends a
 *          request to get a token passing his credentials. The server validates
 *          the credentials and sends back a token. With every request, the user
 *          has to provide the token, and server will validate that token. We’ll
 *          introduce another service called ‘auth service’ for validating user
 *          credentials, and issuing tokens. What about validating the token?
 *          Well, it can be implemented in the auth service itself, and the
 *          gateway has to call the auth service to validate the token before
 *          allowing the requests to go to any service. Instead, we can validate
 *          the tokens at the gateway level, and let the auth service validate
 *          user credentials, and issue tokens. And that’s what we’re going to
 *          do here. In both ways, we are blocking the requests unless it’s
 *          authenticated (except the requests for generating tokens).
 **/
@SpringBootApplication
@EnableEurekaClient
public class EtplAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtplAuthServiceApplication.class, args);
	}
	
	/*
	 * @Bean public Docket api() throws IOException, XmlPullParserException { return
	 * new Docket(DocumentationType.SWAGGER_2) .select()
	 * .apis(RequestHandlerSelectors.basePackage("com.etpl.auth"))
	 * //.apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any())
	 * .build().apiInfo(new ApiInfo("Authentication Service Api Documentation",
	 * "Documentation automatically generated", "1.0.0", null, null, null, null)); }
	 */
	/*
	 * @Bean public Sampler defaultSampler() { return Sampler.ALWAYS_SAMPLE; }
	 */
}
@Configuration
class RestTemplateConfig {
	
	// Create a bean for restTemplate to call services
	@Bean
	@LoadBalanced		// Load balance between service instances running at different ports.
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}





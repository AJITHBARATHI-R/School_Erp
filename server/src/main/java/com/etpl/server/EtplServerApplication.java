/*
 * Copyright (C) 2020  Technologies Private Limited 
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

package com.etpl.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author <Elavarasan Ramasamy>
 * @Date of Creation <01-July-202>
 * @Purpose <Purpose of Creating Eureka Server>
	It’s the naming server, or called service registry. It’s duty to give names to each microservice.
	 Why?
		1. No need to hardcode the IP addresses of microservices.
		2. What if services use dynamic IP addresses; when autoscaling.
	So, every service registers itself with Eureka, and pings Eureka server to notify that it’s alive.
	If Eureka server didn’t receive any notification from a service. This service is unregistered from the Eureka server automatically.
*/
@SpringBootApplication
@EnableEurekaServer 
public class EtplServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtplServerApplication.class, args);
	}

}

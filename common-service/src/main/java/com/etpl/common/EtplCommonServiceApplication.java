/*
 * Copyright (C) 2020 ERNIESYS Technologies Private Limited 
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
package com.etpl.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author <Elavarasan Ramasamy>
 * @Date of Creation <01-July-202>
 * @Purpose <Purpose of Creating Eureka Server> When there is a common
 *          configuration variables, enum classes, or logic, used by multiple
 *          services, like Utility / Logger. Instead of duplicating the code, we
 *          put it in a separate service that can be included and used as a
 *          dependency in other services
 */
@SpringBootApplication
@EnableEurekaClient
public class EtplCommonServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtplCommonServiceApplication.class, args);
	}

}

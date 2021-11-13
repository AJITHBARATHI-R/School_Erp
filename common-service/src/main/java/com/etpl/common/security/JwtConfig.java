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

package com.etpl.common.security;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.ToString;

/**
 * @Author <Elavarasan Ramasamy>
 * @Date of Creation <01-July-202>
 * @Purpose <Purpose of Creating JwtConfig.java>
 * To use this class outside. You have to 1. Define it as a bean, either by
 * adding @Component or use @Bean to instantiate an object from it 2. Use
 * the @Autowire to ask spring to auto create it for you, and inject all the
 * values.
 * 
 * So, If you tried to create an instance manually (i.e. new JwtConfig()). This
 * won't inject all the values. Because you didn't ask Spring to do so (it's
 * done by you manually!). Also, if, at any time, you tried to instantiate an
 * object that's not defined as a bean Don't expect Spring will autowire the
 * fields inside that class object.
 **/

@Getter // lombok will create getters auto.
@ToString // [IMP] You need to install lombok jar file:
			// https://stackoverflow.com/a/11807022
public class JwtConfig {

	// Spring doesn't inject/autowire to "static" fields.
	// Link: https://stackoverflow.com/a/6897406
	@Value("${security.jwt.uri:/auth/**}")
	private String Uri;

	@Value("${security.jwt.header:Authorization}")
	private String header;

	@Value("${security.jwt.prefix:Bearer }")
	private String prefix;

	@Value("${security.jwt.expiration:#{24*60*60}}")
	private int expiration;

	@Value("${security.jwt.secret:JwtSecretKey}")
	private String secret;

	// In case you want to use plain getters instead of lombok.
	public String getUri() {
		return Uri;
	}

	public String getHeader() {
		return header;
	}

	public String getPrefix() {
		return prefix;
	}

	public int getExpiration() {
		return expiration;
	}

	public String getSecret() {
		return secret;
	}

}

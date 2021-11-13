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

package com.etpl.gateway.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.etpl.common.security.JwtConfig;



@EnableWebSecurity // Enable security config. This annotation denotes config for spring security.
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JwtConfig jwtConfig;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				// make sure we use stateless session; session won't be used to store user's
				// state.
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				// handle an authorized attempts
				.exceptionHandling()
				
				.authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
				// Add a filter to validate the tokens with every request
				.addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
				// authorization requests config
				.authorizeRequests()
				// allow all who are accessing "auth" service
				.antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
				.antMatchers(HttpMethod.POST,"/login/auth").permitAll()
				.antMatchers(HttpMethod.POST,"/**").permitAll()
				.antMatchers(HttpMethod.GET,"/**").permitAll()
				//Authorize Swagger
                .antMatchers(HttpMethod.GET,"/swagger-ui.html").permitAll()
                .antMatchers(HttpMethod.GET,"/swagger-ui/**").permitAll()
                .antMatchers(HttpMethod.GET,"/swagger/**").permitAll()
                .antMatchers(HttpMethod.GET,"/webjars/**").permitAll()
                .antMatchers(HttpMethod.GET,"/swagger-resources/**").permitAll()
                .antMatchers(HttpMethod.GET,"/user/v2/api-docs").permitAll()
                .antMatchers(HttpMethod.GET,"/admin/v2/api-docs").permitAll()
                .antMatchers(HttpMethod.GET,"/login/v2/api-docs").permitAll()
				// must be an admin if trying to access admin area (authentication is also
				// required here)
				.antMatchers("/gallery" + "/admin/**").hasRole("ADMIN")
				// Any other request must be authenticated
				.anyRequest().authenticated();
	}
	
	
	  
	@Bean
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}
}
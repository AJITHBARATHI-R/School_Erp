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

package com.etpl.auth.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service // It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser appUser=new AppUser();
		appUser.setUsername(username);
		appUser.setRole("ADMIN");
		try {
		//String resString = restTemplate.getForObject("http://user-service/authUser/{username}", String.class,username);
			String resString = "password";
		if(null!=resString)
		appUser.setPassword(encoder.encode(resString));
		else
			throw new UsernameNotFoundException("Username: " + username + " not found");
		/**
		 *  Remember that Spring needs roles to be in this format: "ROLE_" + userRole  (i.e. "ROLE_ADMIN")  So, we need to set it to that format, so we can  verify and compare roles // (i.e. hasRole("ADMIN")).
		 */
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());
		/** The "User" class is provided by Spring and represents a model class for user to be returned by UserDetailsService And used by auth manager to verify and check user authentication.*/
		return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
		}catch(Exception e)
		{
			throw new UsernameNotFoundException("Username: " + username + " not found");
		}
	
	}
}
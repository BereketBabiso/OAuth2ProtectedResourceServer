package com.spring.security.resource.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
//@EnableGlobalMethodSecurity
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests()
		    .antMatchers("/api/**").hasRole("ADMIN")
		    .anyRequest()
		    .authenticated();*/
		http.csrf().disable().authorizeRequests().anyRequest().permitAll();
	}
	
	

}

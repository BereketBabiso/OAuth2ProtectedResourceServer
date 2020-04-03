package com.spring.security.resource.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

@SpringBootApplication
//@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled=true, proxyTargetClass=true)
public class SpringSecurityResourceServerWithOAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityResourceServerWithOAuthApplication.class, args);
	}
	
	@Bean
	public OAuth2RestTemplate oAuth2RestTemplate(OAuth2ClientContext oAuth2ClientContext,
			OAuth2ProtectedResourceDetails details) {
		return new OAuth2RestTemplate(details, oAuth2ClientContext);
	}
	
	@Bean
	public GlobalMethodSecurityConfiguration globalMethodSecurityConfiguration() {
		return new GlobalMethodSecurityConfiguration() {
			@Override
			protected MethodSecurityExpressionHandler createExpressionHandler() {
				return new OAuth2MethodSecurityExpressionHandler();
			}
		};
	}

}

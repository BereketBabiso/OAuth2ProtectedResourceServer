package com.spring.security.resource.server.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/test/admin")
	public String testAdmin() {
		return "test : success for ADMIN";
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/test/user")
	public String testUser() {
		return "test : success for USER";
	}

}

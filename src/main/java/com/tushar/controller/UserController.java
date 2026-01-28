package com.tushar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.entity.Users;
import com.tushar.entity.Users.UserType;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@GetMapping("/test")
	public ResponseEntity<Users> getTestUser(){
		Users testUsers = Users.builder()
				.email("tushar@gmail.com")
				.passwordHash("tushar12345")
				.userType(UserType.INDIVIDUAL)
				.tenantId(null)
				.build();
		 return ResponseEntity.ok(testUsers);
		
	}

}

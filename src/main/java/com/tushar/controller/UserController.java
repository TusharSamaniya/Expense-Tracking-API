package com.tushar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.dto.UserRegrestrationDTO;
import com.tushar.entity.Users;
import com.tushar.repository.IUserRepository;

@RestController
@RequestMapping("/api/v1/users")
@Validated
public class UserController {
	
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	 @PostMapping("/register")
	    public ResponseEntity<String> registerUser(@RequestBody @Validated UserRegrestrationDTO dto) {
	        // Check if email already exists
	        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
	            return ResponseEntity.badRequest().body("Email already registered");
	        }

	        // Create user
	        Users user = Users.builder()
	                .email(dto.getEmail())
	                .passwordHash(passwordEncoder.encode(dto.getPassword()))  // Hash here
	                .userType(dto.getUserType())
	                .tenantId(null)  // Later logic for company/freelancer
	                .build();

	        userRepository.save(user);

	        return ResponseEntity.ok("User registered successfully: " + user.getEmail());
	    }

}

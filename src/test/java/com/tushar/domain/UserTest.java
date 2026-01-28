package com.tushar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.tushar.entity.Users;

public class UserTest {
	
	void testUserBuilder() {
		Users user = Users.builder()
				.email("tushar@Smanaiya.com")
				.passwordHash("tushar12345")
				.userType(Users.UserType.INDIVIDUAL)
				.build();
		
		assertNotNull(user);
		assertEquals("tushar@Smanaiya.com", user.getEmail());
		assertEquals(Users.UserType.INDIVIDUAL, user.getUserType());
	}

}

package com.bookstore;

import java.util.HashSet;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bookstore.config.SecurityUtility;
import com.bookstore.domen.User;
import com.bookstore.security.Role;
import com.bookstore.security.UserRole;
import com.bookstore.service.UserService;
import com.bookstore.service.UserServiceImpl;


@SpringBootApplication
@ComponentScan({"com.bookstore.service"})

@EnableJpaRepositories("com.bookstore.repository")


public class BookStoreAngularApplication implements CommandLineRunner {

	@Autowired 
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreAngularApplication.class, args);
	}
	

	@Override
	public void run(String... arg0) throws Exception {
		User user1 = new User();
		user1.setFirstName("Hajdi");
		user1.setLastName("Djukic Grba");
		user1.setUsername("h");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("djg"));
		user1.setEmali("hajdidjukic@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
		
		userRoles.clear();
		
		User user2 = new User();
		user2.setFirstName("Admin");
		user2.setLastName("Admin");
		user2.setUsername("a");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("a"));
		user2.setEmali("admin@gmail.com");
		Role role2 = new Role();
		role2.setRoleId(0);
		role2.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user2, role2));
		
		userService.createUser(user2, userRoles);
		
	}
}

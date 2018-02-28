package com.bookstore.service;

import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bookstore.domen.User;
import com.bookstore.security.UserRole;

@Service 

public interface UserService {
	
	 User createUser(User user, Set<UserRole> userRols);

}

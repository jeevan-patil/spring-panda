package org.spring.panda.service;

import java.util.List;

import org.spring.panda.domain.User;

public interface UserService {
	List<User> getAllUsers();
	
	void addUser(User user);
}

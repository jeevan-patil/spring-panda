package org.spring.panda.dao;

import java.util.List;

import org.spring.panda.domain.User;

public interface UserDao {
	List<User> getAllUsers();

	User getUserByEmai(String email);

	void save(Object object);

	void delete(Object object);
}

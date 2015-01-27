package org.spring.panda.service;

import java.util.List;

import org.spring.panda.dao.UserDao;
import org.spring.panda.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private StandardPasswordEncoder encoder;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void addUser(User user) {
		userDao.save(user);
	}

}

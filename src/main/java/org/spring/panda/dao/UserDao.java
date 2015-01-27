package org.spring.panda.dao;

import java.util.List;

import org.spring.panda.domain.User;
import org.spring.panda.exception.PandaException;

/**
 * 
 * @author jeevan
 * @date 24-Jan-2015
 * @purpose 
 *
 */
public interface UserDao {
	List<User> getAllUsers() throws PandaException;

	User getUserByEmai(String email) throws PandaException;

	void save(Object object) throws PandaException;

	void delete(Object object) throws PandaException;
}

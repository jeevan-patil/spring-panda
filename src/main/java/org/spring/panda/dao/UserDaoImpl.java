package org.spring.panda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.spring.panda.domain.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		return entityManager.createQuery("select u from User u").getResultList();
	}

	@Override
	public User getUserByEmai(String email) {
		return (User) entityManager.createQuery("select u from User u where u.email = :email").setParameter("email", email).getSingleResult();
	}

	@Override
	public void save(Object object) {
		entityManager.persist(object);
	}

	@Override
	public void delete(Object object) {
		entityManager.remove(object);
	}
}

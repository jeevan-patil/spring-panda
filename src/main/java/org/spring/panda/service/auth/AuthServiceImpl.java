package org.spring.panda.service.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.panda.dao.UserDao;
import org.spring.panda.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("authService")
public class AuthServiceImpl implements UserDetailsService {
	private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (null == username || username.length() <= 0) {
			try {
				throw new Exception("Customer ID is null or empty.");
			} catch (Exception e) {
				log.error("Customer ID is null.");
			}
		}

		User user = null;
		try {
			user = userDao.getUserByEmai(username);
		} catch (Exception e) {
			log.error("Exception in getting user object in service method : {}.", e.getMessage());
			e.printStackTrace();
		}

		if (null == user) {
			throw new UsernameNotFoundException("No such customer found.");
		}

		boolean enabled = true;
		if(!user.getActive()) {
			enabled = false;
		}

		boolean credentialsNonExpired = true;
		boolean accountNonExpired = true;
		boolean accountNonLocked = true;

		Collection<GrantedAuthority> authorities = getAuthorities(user);
		org.springframework.security.core.userdetails.User authUser = new org.springframework.security.core.userdetails.User(user.getEmail(),
				user.getPassword(), enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);

		return authUser;
	}

	/**
	 * method which returns the list of customer roles
	 * 
	 * @param customer
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Collection<GrantedAuthority> getAuthorities(User user) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(5);
		authList.add(new GrantedAuthorityImpl(user.getRole()));
		return authList;
	}
}


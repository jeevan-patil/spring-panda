package org.spring.panda.controller.user;

import java.util.Date;
import java.util.List;

import org.spring.panda.domain.User;
import org.spring.panda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private StandardPasswordEncoder encoder;

	@ResponseBody
	@RequestMapping(value = "user/add", method = RequestMethod.POST,  consumes= "application/json")
	public Boolean addUser(@RequestBody User user) {
		boolean response = false;

		try {
			CharSequence pass = "test";
			user.setActive(true);
			user.setPassword(encoder.encode(pass));
			user.setRole("ROLE_USER");
			user.setCreatedAt(new Date());
			userService.addUser(user);
			response = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value = "user/list", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUsersList() {
		return userService.getAllUsers();
	}
}

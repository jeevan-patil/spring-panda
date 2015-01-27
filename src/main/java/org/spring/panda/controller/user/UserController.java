package org.spring.panda.controller.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.panda.domain.User;
import org.spring.panda.objects.Response;
import org.spring.panda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author jeevan
 * @date 23-Jan-2015
 * @purpose 
 *
 */
@Controller
public class UserController {
	private final Logger _log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "user/add", method = RequestMethod.POST,  consumes= "application/json")
	public ResponseEntity<Response> addUser(@RequestBody User user) {
		Response response = null;
		try {
			userService.addUser(user);
			response = new Response(true, "Customer saved successfully.");
		} catch(Exception e) {
			response = new Response(false, "Could not save customer.");
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "user/list", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<User>> getAllUsersList() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}
}

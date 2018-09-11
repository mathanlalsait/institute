package com.candid.sma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.candid.sma.model.User;
import com.candid.sma.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public List<User> getAllUser() {
		return userService.findAllUsers();
	}

	@RequestMapping(value = "/getuserbyname/{name}", method = RequestMethod.GET)
	public User getUserByName(@PathVariable("name") String fullName) {
		return userService.findUserByFullName(fullName);
	}

	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") String id) {
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getuserbyemail/{email}", method = RequestMethod.GET)
	public User getUserByEmail(@PathVariable("email") String email) {
		User user = null;
		try {
			user = userService.findUserByEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}

	@RequestMapping(value = "/updateuser/{id}", method = RequestMethod.PUT)
	public void modifyUserById(@PathVariable("id") String id, @RequestBody User user) {
		user.setId(id);
		userService.updateUser(user);
	}

}

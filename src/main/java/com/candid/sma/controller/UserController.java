package com.candid.sma.controller;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.candid.sma.Exception.ErrorDetails;
import com.candid.sma.Exception.RecordNotFoundException;
import com.candid.sma.Exception.UserException;
import com.candid.sma.model.User;
import com.candid.sma.service.UserService;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
public class UserController {

	private static final Logger log=LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<User>> getAllUser() throws UserException {
		Collection<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
           
				throw new UserException("Students doesn´t exist");
			
    	}
		/*if (users.isEmpty()) {
			log.info("Students not found");
			return new ResponseEntity<Collection<User>>(HttpStatus.NOT_FOUND);

		}*/
		log.info("Returning all students");
		return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable("id") String id) throws UserException {
		User user = userService.findUserById(id);
		if (user == null) {

			throw new UserException("Student Does't Exist with the id : " + id);
		}
		
		/*if (user == null) {

			throw new RecordNotFoundException("Invalid Id : " + id);
		}*/

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/getuserbyname/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> getUserByName(@PathVariable("name") String fullName) throws UserException {
		User user = userService.findUserByFullName(fullName);
		if (user == null) {
			throw new UserException("User DoesnotExist with the name : " + fullName);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ErrorDetails> deleteUser(@PathVariable("id") String id) {
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<ErrorDetails>(new ErrorDetails(HttpStatus.OK.value(), "User has been deleted"), HttpStatus.OK);

	}

	@RequestMapping(value = "/getuserbyemail/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) throws UserException {
		User user = null;
		try {
			user = userService.findUserByEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user == null) {
			throw new UserException("User Does Not exist with the email : " + email);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@RequestMapping(value = "/createuser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = null;
		try {
			savedUser = userService.saveUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@RequestMapping(value = "/updateuser/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void modifyUserById(@PathVariable("id") String id, @RequestBody User user) throws UserException {
		// System.out.println(user.getId());
		// user.setId(id);
		log.info("User to update " + user);
    	user = userService.findUserById(user.getId());
    	if (user == null){
            throw new UserException("User to update doesn´t exist");
    	}
		userService.updateUser(user);
	}

}

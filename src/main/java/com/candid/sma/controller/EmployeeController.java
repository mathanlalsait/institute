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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.candid.sma.Exception.ErrorDetails;
import com.candid.sma.Exception.RecordNotFoundException;
import com.candid.sma.Exception.SmaInputException;
import com.candid.sma.Exception.UserException;
import com.candid.sma.model.Employee;
import com.candid.sma.service.EmployeeService;
import com.mongodb.client.result.UpdateResult;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")//to access different port
public class EmployeeController {

	private static final Logger log=LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	EmployeeService userService;

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<Employee>> getAllUser() throws UserException {
		Collection<Employee> users = userService.findAllUsers();
		if (users.isEmpty()) {
           
				throw new UserException("Students doesn´t exist");
			
    	}
		/*if (users.isEmpty()) {
			log.info("Students not found");
			return new ResponseEntity<Collection<User>>(HttpStatus.NOT_FOUND);

		}*/
		log.info("Returning all students");
		return new ResponseEntity<Collection<Employee>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Employee> getUserById(@PathVariable("id") String id) throws UserException {
		Employee user = userService.findUserById(id);
		if (user == null) {

			throw new UserException("Student Does't Exist with the id : " + id);
		}
		
		/*if (user == null) {

			throw new RecordNotFoundException("Invalid Id : " + id);
		}*/

		return new ResponseEntity<Employee>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/getuserbyname/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Employee> getEmpByName(@PathVariable("name") String fullName) throws UserException {
		Employee emp = userService.findUserByFullName(fullName);
		if (emp == null) {
			throw new UserException("User Doesnot Exist with the name : " + fullName);
		}
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
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
	public ResponseEntity<Employee> getUserByEmail(@PathVariable("email") String email) throws SmaInputException {
		Employee user = null;
		try {
			user = userService.findUserByEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user == null) {
			throw new SmaInputException("User Does Not exist with the email : " + email);
		}
		return new ResponseEntity<Employee>(user, HttpStatus.OK);

	}

	@RequestMapping(value = "/createuser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> createUser(@Valid @RequestBody Employee user) {
		Employee savedUser = null;
		try {
			savedUser = userService.saveUser(user);
			System.out.println("***************"+savedUser.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@RequestMapping(value = "/updateuser/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void modifyUserById(@PathVariable("id") String id, @RequestBody Employee user) throws UserException {
		// System.out.println(user.getId());
		// user.setId(id);
		log.info("User to update " + user);
    	user = userService.findUserById(user.getId());
    	if (user == null){
            throw new UserException("User to update doesn´t exist");
    	}
		userService.updateUser(user);
	}
	
	
	@RequestMapping(value = "/updatephone/{firstname}/{phone}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void updatePhone(@PathVariable("firstname") String firstName, @PathVariable("phone") String phone) throws UserException {
		System.out.println("Heyyyyyyy i am in updatePhone method");
	if(firstName != null && phone != null)
		userService.updateUserPhone(firstName, phone);
	}

	@GetMapping("/getActiveUsers")
	public ResponseEntity<Collection<Employee>> findAllActiveUsers() {
		Collection<Employee> activeUsers = userService.findAllActiveUsers();
		
		if(activeUsers.size() == 0)
			System.out.println("No Active Users");
		else
			System.out.println(activeUsers);
		return new ResponseEntity<Collection<Employee>>(activeUsers, HttpStatus.OK);
	}
}

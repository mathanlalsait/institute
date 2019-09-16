package com.candid.sma.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candid.sma.model.Employee;
import com.candid.sma.repository.EmployeeRepository;
import com.candid.sma.utils.RandomPasswordGenerator;
import com.mongodb.client.result.UpdateResult;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository userRepository;

	public Employee saveUser(Employee user) {
		// user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setCreatedOn(new Date());
		user.setDelete(false);
		String randomPass = RandomPasswordGenerator.generateRandomPassword();
		user.setPassword(randomPass);
		user.setModifiedOn(new Date());
		user.setStatus(true);
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(String id) throws Exception {
		userRepository.deleteById(id);

	}

	@Override
	public List<Employee> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	@Override
	public Employee findUserByFullName(String fullName) {
		// TODO Auto-generated method stub
		return userRepository.findByFullName(fullName);
	}

	@Override
	public Employee findUserByPrimaryMobile(String primaryMobile) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findByPrimaryMobile(primaryMobile);
	}

	@Override
	public Employee findUserByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public Employee updateUser(Employee newUser) {
		if(newUser!=null) {
	    Employee user=findUserById(newUser.getId());
	    Date createdon=user.getCreatedOn();
	    boolean delete=user.isDelete();
	    boolean status=user.isStatus();
	    newUser.setCreatedOn(createdon);
	    newUser.setDelete(delete);
	    newUser.setStatus(status);
	    newUser.setModifiedOn(new Date());
		}
		return userRepository.save(newUser);
	}

	@Override
	public Employee findUserById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public UpdateResult updateUserPhone(String firstName, String phone) {
		return userRepository.updateUserPhone(firstName, phone);
	}

	public Collection<Employee> findAllActiveUsers() {
		return userRepository.findAllActiveUsers();
	}

		
	

	
}

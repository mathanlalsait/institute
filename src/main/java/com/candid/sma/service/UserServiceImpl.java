package com.candid.sma.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candid.sma.model.User;
import com.candid.sma.repository.UserRepository;
import com.candid.sma.utils.RandomPasswordGenerator;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
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
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	@Override
	public User findUserByFullName(String fullName) {
		// TODO Auto-generated method stub
		return userRepository.findByFullName(fullName);
	}

	@Override
	public User findUserByPrimaryMobile(String primaryMobile) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findByPrimaryMobile(primaryMobile);
	}

	@Override
	public User findUserByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public User updateUser(User newUser) {
		if(newUser!=null) {
	    User user=findUserById(newUser.getId());
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
	public User findUserById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}

		
	

	
}

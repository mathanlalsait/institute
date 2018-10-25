package com.candid.sma.service;

import java.util.List;
import java.util.Optional;

import com.candid.sma.model.User;

public interface UserService {
	
	User saveUser(User user) throws Exception;
	 
	void deleteUser(String id) throws Exception;
 
    List<User> findAllUsers();
 
    User findUserByEmail(String email) throws Exception;
	User findUserByFullName(String fullName);
	User findUserByPrimaryMobile(String primaryMobile)throws Exception;
    User updateUser(User newUser);
    
   User findUserById(String id);

}

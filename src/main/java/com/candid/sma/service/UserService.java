package com.candid.sma.service;

import java.util.List;

import com.candid.sma.model.User;

public interface UserService {
	
	void saveUser(User user) throws Exception;
	 
	void deleteUser(String id) throws Exception;
 
    List<User> findAllUsers();
 
    User findUserByEmail(String email) throws Exception;
 
    void updateUser(User newUser) throws Exception;

}

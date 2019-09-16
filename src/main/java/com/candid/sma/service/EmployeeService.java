package com.candid.sma.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.candid.sma.model.Employee;
import com.mongodb.client.result.UpdateResult;

public interface EmployeeService {

	Employee saveUser(Employee user) throws Exception;

	void deleteUser(String id) throws Exception;

	List<Employee> findAllUsers();

	Employee findUserByEmail(String email) throws Exception;

	Employee findUserByFullName(String fullName);

	Employee findUserByPrimaryMobile(String primaryMobile) throws Exception;

	Employee updateUser(Employee newUser);

	Employee findUserById(String id);

	UpdateResult updateUserPhone(String firstName, String phone);

	Collection<Employee> findAllActiveUsers();

}

package com.candid.sma.repository;

import org.springframework.stereotype.Repository;

import com.candid.sma.model.Employee;
import com.mongodb.client.result.UpdateResult;
@Repository
public interface EmployeeRepositoryCustom {
	

	public UpdateResult updateUserPhone(String firstName,String phone);
	
	//public void deleteById(String id);

}

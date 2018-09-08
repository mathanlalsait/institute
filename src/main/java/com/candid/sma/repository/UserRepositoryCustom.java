package com.candid.sma.repository;

import org.springframework.stereotype.Repository;

import com.candid.sma.model.User;
import com.mongodb.client.result.UpdateResult;
@Repository
public interface UserRepositoryCustom {
	

	public UpdateResult updateUserPhone(String firstName,String phone);
	
	public void deleteById(String id);

}

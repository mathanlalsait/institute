package com.candid.sma.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.candid.sma.model.Employee;
import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;

public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public UpdateResult updateUserPhone(String fullName, String phone) {
		System.out.println(fullName+"********"+phone);
		Query query = new Query(Criteria.where("fullName").is(fullName));
        Update update = new Update();
        update.set("primaryMobile", phone);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Employee.class);
		return result;

		
	}

	

	

	

}

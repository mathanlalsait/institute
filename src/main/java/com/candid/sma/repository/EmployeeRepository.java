package com.candid.sma.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.candid.sma.model.Employee;
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>,EmployeeRepositoryCustom {
	
	
	Employee findByEmail(String email);

	Employee findByFullName(String fullName);
	
	
	Employee findByPrimaryMobile(String primaryMobile);

	@Query("{'status':true}")
	Collection<Employee> findAllActiveUsers();
}

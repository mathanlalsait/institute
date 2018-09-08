package com.candid.sma.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.candid.sma.model.User;
@Repository
public interface UserRepository extends MongoRepository<User, String>,UserRepositoryCustom {
	
	
	User findByEmail(String email);

	User findByFullName(String fullName);
	
	
	User findByPrimaryMobile(String primaryMobile);

	@Query("{'status':true}")
	Collection<User> findAllActiveUsers();
}

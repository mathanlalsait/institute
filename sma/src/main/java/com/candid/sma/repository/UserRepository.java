package com.candid.sma.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.candid.sma.model.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
	

	User findByEmail(String email);

	User findByFullName(String string);

}

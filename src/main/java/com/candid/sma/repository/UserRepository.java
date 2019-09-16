package com.candid.sma.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.candid.sma.model.User;

@Repository
public interface UserRepository {
	public User findByUserName(String username);
}

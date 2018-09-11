package com.candid.sma.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.candid.sma.model.Batch;

@Repository
public interface BatchRepository extends MongoRepository<Batch, String> {

	
	

}

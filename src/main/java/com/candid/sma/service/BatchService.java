 package com.candid.sma.service;

import java.util.List;

import com.candid.sma.model.Batch;

public interface BatchService {

	void saveBatch(Batch batch) throws Exception;
	 
	void deleteBatch(String id) throws Exception;
 
    List<Batch> findAllBatches();
    Batch updateBatch(Batch batch);

}

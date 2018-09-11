package com.candid.sma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candid.sma.model.Batch;
import com.candid.sma.repository.BatchRepository;
@Service
public class BatchServiceImpl implements BatchService {
	
	@Autowired
	BatchRepository batchRepository;

	@Override
	public void saveBatch(Batch batch) throws Exception {
		batchRepository.save(batch);
	}

	@Override
	public void deleteBatch(String id) throws Exception {
		batchRepository.deleteById(id);
	}

	@Override
	public List<Batch> findAllBatches() {
		return batchRepository.findAll();
	}

	@Override
	public Batch updateBatch(Batch batch) {
		// TODO Auto-generated method stub
		return batchRepository.save(batch);
	}

	


}
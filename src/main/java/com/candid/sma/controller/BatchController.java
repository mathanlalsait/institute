package com.candid.sma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.candid.sma.model.Batch;
import com.candid.sma.service.BatchService;

@RestController
public class BatchController {

	@Autowired
	BatchService batchService;

	@RequestMapping(value = "/getAllBatches", method = RequestMethod.GET)
	public List<Batch> getAllBatches() {
		return batchService.findAllBatches();
	}

	@RequestMapping(value = "/deletebatch/{id}", method = RequestMethod.DELETE)
	public void deleteBatch(@PathVariable("id") String id) {
		try {
			batchService.deleteBatch(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/createbatch", method = RequestMethod.POST)
	public Batch createBatch(@RequestBody Batch batch) {
		try {
			batchService.saveBatch(batch);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return batch;

	}

	@RequestMapping(value = "/updatebatch/{id}", method = RequestMethod.PUT)
	public void modifyBatchById(@PathVariable("id") String id, @RequestBody Batch batch) {
		batch.setId(id);
		batchService.updateBatch(batch);
	}

}

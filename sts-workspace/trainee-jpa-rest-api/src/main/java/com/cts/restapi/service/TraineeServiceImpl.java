package com.cts.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.restapi.dao.TraineeRepo;
import com.cts.restapi.model.Trainee;

@Service
public class TraineeServiceImpl implements TraineeService {

	@Autowired
	TraineeRepo repo;
	
	@Override
	public List<Trainee> getAllTrainees() {
		return repo.findAll();
	}

	@Override
	public Trainee getTraineeById(long id) {
		return repo.findById(id).get();
	}

}

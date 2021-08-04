package com.cts.restapi.service;

import java.util.List;

import com.cts.restapi.model.Trainee;

public interface TraineeService {

	List<Trainee> getAllTrainees();
	Trainee getTraineeById(long id);
}

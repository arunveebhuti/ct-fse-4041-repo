package com.cts.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.restapi.dao.TraineeRepo;
import com.cts.restapi.model.Trainee;
import com.cts.restapi.service.TraineeService;

@RestController
@RequestMapping("/trainees")
public class TraineeController {
	
//	@Autowired
//	private TraineeRepo repo;
	
	@Autowired
	private TraineeService service;
	
	@GetMapping
	public List<Trainee> getAllTrainees() {
		return service.getAllTrainees();
	}
	
	@GetMapping("/id/{id}")
	public Trainee getTainee(@PathVariable long id) {
		return service.getTraineeById(id);
	}
	
//	@PostMapping
//	public Trainee addTrainee(@RequestBody Trainee trainee) {
//		return repo.save(trainee);
//	}
	
}

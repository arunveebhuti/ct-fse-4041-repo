package com.cts.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.restapi.model.Trainee;

public interface TraineeRepo extends JpaRepository<Trainee, Long> {

}

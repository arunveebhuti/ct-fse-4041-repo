package com.cts.restapi.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.restapi.model.Trainee;
import com.cts.restapi.service.TraineeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TraineeController.class)
class TraineeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TraineeService service;

	@Test
	void testGetAllTrainees() throws Exception {
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/trainees");
		Trainee trainee=new Trainee(101, "Mahesh", "mahesh@yahoo.com", LocalDate.of(2000, 10,10));
		List<Trainee> trainees=new ArrayList<>();
		trainees.add(trainee);
		when(service.getAllTrainees()).thenReturn(trainees);
		
		mockMvc.perform(requestBuilder)
								.andExpect(status().isOk())
								.andReturn();
		
	}

	@Test
	void testGetTainee() {
		//fail("Not yet implemented");
	}

}

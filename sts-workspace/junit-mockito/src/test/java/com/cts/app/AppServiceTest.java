package com.cts.app;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class AppServiceTest {

	@Mock
	AppRepo repo;
	
	@InjectMocks
	AppService service;
	
	@Test
	void testAddData() {
		when(repo.addData()).thenReturn("Hello");
		assertEquals("Hello", service.addData());
	}

}

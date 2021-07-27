package com.cts.microservices.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {

	
	private String itemName;
	private double price;
	
}

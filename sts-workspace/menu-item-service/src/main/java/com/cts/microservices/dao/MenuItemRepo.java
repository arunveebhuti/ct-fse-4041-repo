package com.cts.microservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.microservices.model.MenuItem;

public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {
	
	public MenuItem findByItemName(String itemName);

}

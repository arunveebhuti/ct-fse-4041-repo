package com.cts.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.microservices.model.Coupon;
import com.cts.microservices.model.MenuItem;
import com.cts.microservices.model.Order;

@Service
public class OrderService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Order getOrderDetails(String itemName, String couponCode) {
		
		MenuItem item=restTemplate.getForObject("http://menu-item-service/items/item-name/"+itemName,MenuItem.class);
		Coupon coupon=restTemplate.getForObject("http://coupon-service/coupons/coupon-code/"+couponCode,Coupon.class);
		double finalPrice=item.getPrice()-(item.getPrice()*(coupon.getDiscount()/100));
		return new Order(item, coupon, finalPrice);
	}

}

package com.cts.microservices.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.microservices.model.Coupon;
import com.cts.microservices.model.MenuItem;
import com.cts.microservices.model.Order;

@Service
public class OrderService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${LOAD_BALANCER_URL}")
	String loadBalancerUrl;
	
	@Autowired
	CouponServiceFeignClient couponServiceClient;
	
	
	public Order getOrderDetails(String itemName, String couponCode) {
		
		//MenuItem item=restTemplate.getForObject(loadBalancerUrl+"/items/item-name/"+itemName,MenuItem.class);
		//Coupon coupon=restTemplate.getForObject(loadBalancerUrl+"/coupons/coupon-code/"+couponCode,Coupon.class);
		Coupon coupon=couponServiceClient.getCoupon(couponCode);
		MenuItem item=new MenuItem("Dosa",70.0);
		double finalPrice=item.getPrice()-(item.getPrice()*(coupon.getDiscount()/100));
		return new Order(item, coupon, finalPrice);
	}

}

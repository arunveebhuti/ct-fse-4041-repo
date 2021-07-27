package com.cts.microservices.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.microservices.dao.CouponRepo;
import com.cts.microservices.model.Coupon;

@RestController
@RequestMapping("/coupons")
public class CouponController {

	@Autowired
	private CouponRepo repo;
	
	@PostConstruct
	public void init() {
		Coupon coupon1=new Coupon(101, "c1001", 10.0);
		Coupon coupon2=new Coupon(102, "c1002", 15.0);
		repo.save(coupon1);
		repo.save(coupon2);
	}
	
	@GetMapping("/coupon-code/{couponCode}")
	public Coupon getCoupon(@PathVariable String couponCode) {
		return repo.findByCouponCode(couponCode);
	}
}

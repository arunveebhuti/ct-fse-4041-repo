package com.cts.microservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.microservices.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long>{

	public Coupon findByCouponCode(String couponCode);
	
}

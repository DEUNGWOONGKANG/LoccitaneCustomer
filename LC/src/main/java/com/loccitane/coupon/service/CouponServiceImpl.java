package com.loccitane.coupon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.loccitane.coupon.dao.CouponDAO;
import com.loccitane.coupon.domain.CouponVO;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Inject
	private CouponDAO dao;
	
	@Override
	public List<CouponVO> getUserCoupon(String userid) throws Exception {
		return dao.getUserCoupon(userid);
	}
	
}

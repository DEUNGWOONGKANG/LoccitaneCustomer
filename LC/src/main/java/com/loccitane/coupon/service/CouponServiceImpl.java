package com.loccitane.coupon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.loccitane.coupon.dao.CouponDAO;
import com.loccitane.coupon.domain.CouponCoreVO;
import com.loccitane.coupon.domain.CouponVO;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Inject
	private CouponDAO dao;
	
	@Override
	public List<CouponVO> getUserCoupon(String usercode) throws Exception {
		return dao.getUserCoupon(usercode);
	}

	@Override
	public List<CouponCoreVO> getCouponList() {
		return dao.getCouponList();
	}

	@Override
	public CouponCoreVO getCouponInfo(String couponcode) {
		return dao.getCouponInfo(couponcode);
	}

	@Override
	public int couponSave(CouponCoreVO coupon) {
		return dao.couponSave(coupon);
	}

	@Override
	public CouponVO getCoupontomember(String couponNo) {
		return dao.getCoupontomember(couponNo);
	}

	@Override
	public int coupontomemberSave(CouponVO coupon) {
		return dao.coupontomemberSave(coupon);
	}

	@Override
	public int couponUpdate(CouponCoreVO coupon) {
		return dao.couponUpdate(coupon);
	}

	@Override
	public int coupontomemberUpdate(CouponVO coupon) {
		return dao.coupontomemberUpdate(coupon);
	}
	
}

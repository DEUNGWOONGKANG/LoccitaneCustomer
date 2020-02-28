package com.loccitane.coupon.dao;

import java.util.List;

import com.loccitane.coupon.domain.CouponVO;

public interface CouponDAO {
	public List<CouponVO> getUserCoupon(String usercode) throws Exception;

}

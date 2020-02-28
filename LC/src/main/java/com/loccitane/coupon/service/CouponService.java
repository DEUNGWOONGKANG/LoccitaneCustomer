package com.loccitane.coupon.service;

import java.util.List;
import com.loccitane.coupon.domain.CouponVO;

public interface CouponService {
	
	public List<CouponVO> getUserCoupon(String usercode) throws Exception;
	
}

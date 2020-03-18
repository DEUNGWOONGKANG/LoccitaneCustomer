package com.loccitane.coupon.dao;

import java.util.List;

import com.loccitane.coupon.domain.CouponCoreVO;
import com.loccitane.coupon.domain.CouponVO;

public interface CouponDAO {
	public List<CouponVO> getUserCoupon(String usercode) throws Exception;

	public List<CouponCoreVO> getCouponList();

	public CouponCoreVO getCouponInfo(String couponcode);

	public int couponSave(CouponCoreVO coupon);

	public CouponVO getCoupontomember(String couponNo);

	public int coupontomemberSave(CouponVO coupon);

	public int couponUpdate(CouponCoreVO coupon);

	public int coupontomemberUpdate(CouponVO coupon);

}

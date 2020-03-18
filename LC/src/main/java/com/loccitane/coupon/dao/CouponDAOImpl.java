package com.loccitane.coupon.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.loccitane.coupon.domain.CouponCoreVO;
import com.loccitane.coupon.domain.CouponVO;

@Repository
public class CouponDAOImpl implements CouponDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "CouponMapper";

	@Override
	public List<CouponVO> getUserCoupon(String usercode) throws Exception {
		return sqlSession.selectList(namespace+".getUserCouponList", usercode);
	}

	@Override
	public List<CouponCoreVO> getCouponList() {
		return sqlSession.selectList(namespace+".getCouponList");
	}

	@Override
	public CouponCoreVO getCouponInfo(String couponcode) {
		return sqlSession.selectOne(namespace+".getCouponInfo", couponcode);
	}

	@Override
	public int couponSave(CouponCoreVO coupon) {
		return sqlSession.insert(namespace+".couponSave", coupon);
	}

	@Override
	public CouponVO getCoupontomember(String couponNo) {
		return sqlSession.selectOne(namespace+".getCoupontomember", couponNo);
	}

	@Override
	public int coupontomemberSave(CouponVO coupon) {
		return sqlSession.insert(namespace+".coupontomemberSave", coupon);
	}

	@Override
	public int couponUpdate(CouponCoreVO coupon) {
		return sqlSession.update(namespace+".couponUpdate", coupon);
	}

	@Override
	public int coupontomemberUpdate(CouponVO coupon) {
		return sqlSession.update(namespace+".coupontomemberUpdate", coupon);
	}
	
}

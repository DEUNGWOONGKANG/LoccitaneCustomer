package com.loccitane.coupon.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.loccitane.coupon.domain.CouponVO;

@Repository
public class CouponDAOImpl implements CouponDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "CouponMapper";

	@Override
	public List<CouponVO> getUserCoupon(String usercode) throws Exception {
		return sqlSession.selectList(namespace+".getCouponList", usercode);
	}
	
}

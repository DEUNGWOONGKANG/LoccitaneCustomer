package com.loccitane.user.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.loccitane.user.dao.UserDAO;
import com.loccitane.user.domain.UserVO;

@Repository
public class UserDAOImp implements UserDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "UserMapper";

	@Override
	public UserVO userCheck(String usercode) throws Exception {
		return sqlSession.selectOne(namespace+".userCheck", usercode);
	}

	@Override
	public UserVO userLogin(UserVO userVO) throws Exception {
		return sqlSession.selectOne(namespace+".userLogin", userVO);
	}
	
	@Override
	public int userAgree(UserVO userVO) throws Exception {
		int result = sqlSession.update(namespace+".userAgree", userVO);
		return result;
		
	}
	
}

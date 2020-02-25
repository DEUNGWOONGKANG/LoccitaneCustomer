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
	public UserVO userCheck(String userid) throws Exception {
		return sqlSession.selectOne(namespace+".userCheck", userid);
	}

	@Override
	public UserVO userLogin(UserVO userVO) throws Exception {
		return sqlSession.selectOne(namespace+".userLogin", userVO);
	}
	
}

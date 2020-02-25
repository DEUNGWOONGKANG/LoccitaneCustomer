package com.loccitane.user.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.loccitane.user.dao.UserDAO;
import com.loccitane.user.domain.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;
	
	@Override
	public UserVO userCheck(String userid) throws Exception {
		return dao.userCheck(userid);
	}

	@Override
	public UserVO userLogin(UserVO userVO) throws Exception {
		return dao.userLogin(userVO);
	}

}

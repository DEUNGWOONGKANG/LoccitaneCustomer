package com.loccitane.user.dao;

import com.loccitane.user.domain.UserVO;

public interface UserDAO {
	 public UserVO userCheck(String userid) throws Exception;
	 
	 public UserVO userLogin(UserVO userVO) throws Exception;
	 
}

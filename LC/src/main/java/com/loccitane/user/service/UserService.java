package com.loccitane.user.service;

import com.loccitane.user.domain.UserVO;

public interface UserService {
	
	public UserVO userCheck(String usercode) throws Exception;
		
	public UserVO userLogin(UserVO userVO) throws Exception;
}

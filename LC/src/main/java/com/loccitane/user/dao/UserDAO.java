package com.loccitane.user.dao;

import com.loccitane.user.domain.UserVO;

public interface UserDAO {
	public UserVO userCheck(String usercode) throws Exception;
	 
	public UserVO userLogin(UserVO userVO) throws Exception;

	public int userAgree(UserVO userVO) throws Exception;
	
	public int userSave(UserVO userVO) throws Exception;

	public int userUpdate(UserVO userData);
	 
}

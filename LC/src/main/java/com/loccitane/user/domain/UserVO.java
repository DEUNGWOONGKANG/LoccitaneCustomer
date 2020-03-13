package com.loccitane.user.domain;

public class UserVO {
	private int userseq;
	private String usercode;
	private String phone;
	private String agreeyn;
	
	public UserVO() {}

	public int getUserseq() {
		return userseq;
	}

	public void setUserseq(int userseq) {
		this.userseq = userseq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getAgreeyn() {
		return agreeyn;
	}

	public void setAgreeyn(String agreeyn) {
		this.agreeyn = agreeyn;
	}

}

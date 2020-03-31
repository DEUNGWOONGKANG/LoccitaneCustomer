package com.loccitane.user.domain;

import java.util.Date;

public class UserVO {
	private int userseq;
	private String usercode;
	private String phone;
	private String agreeyn;
	private Date startdate;
	private Date enddate;
	private String status;
	
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

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

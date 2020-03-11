package com.loccitane.user.domain;

import java.util.Date;

public class UserVO {
	private int userseq;
	private String usercode;
	private String grade;
	private String username;
	private String birthday;
	private String status;
	private String phone;
	private Date lastpurchase;
	private Date lastupdate;
	private int totalbuy;
	private String alarmyn;
	private Date secondvisit_1;
	private Date secondvisit_2;
	private Date secondvisit_3;
	private Date secondvisit_4;
	private String agreeyn;
	
	public UserVO() {}

	public int getUserseq() {
		return userseq;
	}

	public void setUserseq(int userseq) {
		this.userseq = userseq;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getLastpurchase() {
		return lastpurchase;
	}

	public void setLastpurchase(Date lastpurchase) {
		this.lastpurchase = lastpurchase;
	}

	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public int getTotalbuy() {
		return totalbuy;
	}

	public void setTotalbuy(int totalbuy) {
		this.totalbuy = totalbuy;
	}

	public String getAlarmyn() {
		return alarmyn;
	}

	public void setAlarmyn(String alarmyn) {
		this.alarmyn = alarmyn;
	}

	public Date getSecondvisit_1() {
		return secondvisit_1;
	}

	public void setSecondvisit_1(Date secondvisit_1) {
		this.secondvisit_1 = secondvisit_1;
	}

	public Date getSecondvisit_2() {
		return secondvisit_2;
	}

	public void setSecondvisit_2(Date secondvisit_2) {
		this.secondvisit_2 = secondvisit_2;
	}

	public Date getSecondvisit_3() {
		return secondvisit_3;
	}

	public void setSecondvisit_3(Date secondvisit_3) {
		this.secondvisit_3 = secondvisit_3;
	}

	public Date getSecondvisit_4() {
		return secondvisit_4;
	}

	public void setSecondvisit_4(Date secondvisit_4) {
		this.secondvisit_4 = secondvisit_4;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAgreeyn() {
		return agreeyn;
	}

	public void setAgreeyn(String agreeyn) {
		this.agreeyn = agreeyn;
	}

}

package com.loccitane.user.domain;

import java.util.Date;

public class UserVO {
	private int userseq;
	private String vipcode;
	private String userid;
	private String userpw;
	private String grade;
	private String username;
	private String store;
	private String position;
	private Date birthday;
	private String status;
	private String phone;
	private Date lastpurchase;
	private Date lastupdate;
	private int totalbuy;
	private String alarmyn;
	
	public UserVO() {}

	public int getUserseq() {
		return userseq;
	}

	public void setUserseq(int userseq) {
		this.userseq = userseq;
	}

	public String getVipcode() {
		return vipcode;
	}

	public void setVipcode(String vipcode) {
		this.vipcode = vipcode;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
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

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

}

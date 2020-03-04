package com.loccitane.coupon.domain;

import java.util.Date;


public class CouponVO {
	private int cptmseq;
	private String usercode;
	private String username;
	private String couponcode;
	private String couponname;
	private String couponno;
	private String discountkind;
	private String discountvalue;
	private String createuser;
	private Date createdate;
	private String useyn;
	private String usemanager;
	private Date usedate;
	private Date startdate;
	private Date enddate;
	private String couponinfo;
	private String useminimum;
	private String discountmax;
	private String reason;
	
	public CouponVO() {}

	
	public String getCouponno() {
		return couponno;
	}


	public void setCouponno(String couponno) {
		this.couponno = couponno;
	}

	public int getCptmseq() {
		return cptmseq;
	}

	public void setCptmseq(int cptmseq) {
		this.cptmseq = cptmseq;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getCouponcode() {
		return couponcode;
	}

	public void setCouponcode(String couponcode) {
		this.couponcode = couponcode;
	}

	public String getCouponname() {
		return couponname;
	}

	public void setCouponname(String couponname) {
		this.couponname = couponname;
	}

	public String getDiscountkind() {
		return discountkind;
	}

	public void setDiscountkind(String discountkind) {
		this.discountkind = discountkind;
	}

	public String getDiscountvalue() {
		return discountvalue;
	}

	public void setDiscountvalue(String discountvalue) {
		this.discountvalue = discountvalue;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getUseyn() {
		return useyn;
	}

	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}

	public String getUsemanager() {
		return usemanager;
	}

	public void setUsemanager(String usemanager) {
		this.usemanager = usemanager;
	}

	public Date getUsedate() {
		return usedate;
	}

	public void setUsedate(Date usedate) {
		this.usedate = usedate;
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

	public String getCouponinfo() {
		return couponinfo;
	}

	public void setCouponinfo(String couponinfo) {
		this.couponinfo = couponinfo;
	}

	public String getUseminimum() {
		return useminimum;
	}

	public void setUseminimum(String useminimum) {
		this.useminimum = useminimum;
	}

	public String getDiscountmax() {
		return discountmax;
	}

	public void setDiscountmax(String discountmax) {
		this.discountmax = discountmax;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

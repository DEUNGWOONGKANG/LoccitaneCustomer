package com.loccitane.coupon.domain;

import java.util.Date;


public class CouponVO {
	private int cptmseq;
	private String userid;
	private String couponcode;
	private String couponname;
	private String discountkind;
	private int discountvalue;
	private String createuser;
	private Date createdate;
	private String useyn;
	private String usemanager;
	private Date usedate;
	private Date startdate;
	private Date enddate;
	private String couponinfo;
	private int useminimum;
	private int discountmax;
	
	public CouponVO() {}

	public int getCptmseq() {
		return cptmseq;
	}

	public void setCptmseq(int cptmseq) {
		this.cptmseq = cptmseq;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public int getDiscountvalue() {
		return discountvalue;
	}

	public void setDiscountvalue(int discountvalue) {
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

	public int getUseminimum() {
		return useminimum;
	}

	public void setUseminimum(int useminimum) {
		this.useminimum = useminimum;
	}

	public int getDiscountmax() {
		return discountmax;
	}

	public void setDiscountmax(int discountmax) {
		this.discountmax = discountmax;
	}

}

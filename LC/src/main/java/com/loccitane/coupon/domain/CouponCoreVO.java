package com.loccitane.coupon.domain;

import java.util.Date;


public class CouponCoreVO {
	private int seq;
	private String couponcode;
	private String couponname;
	private String discountkind;
	private String discountvalue;
	private String useminimum;
	private String discountmax;
	private String useyn;
	private String couponinfo;
	private String createuser;
	private Date createdate;
	
	public CouponCoreVO() {}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public String getUseyn() {
		return useyn;
	}

	public void setUseyn(String useyn) {
		this.useyn = useyn;
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

	public String getCouponinfo() {
		return couponinfo;
	}

	public void setCouponinfo(String couponinfo) {
		this.couponinfo = couponinfo;
	}
	
	

}

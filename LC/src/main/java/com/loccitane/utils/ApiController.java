package com.loccitane.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loccitane.coupon.domain.CouponCoreVO;
import com.loccitane.coupon.domain.CouponVO;
import com.loccitane.coupon.service.CouponService;
import com.loccitane.user.domain.UserVO;
import com.loccitane.user.service.UserService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private UserService service; 
	@Autowired
	private CouponService cpservice; 
	
	//관리자페이지에서 엑셀 업로드했을경우 신규 사용자 추가
	@RequestMapping(value="/user/add", produces = "application/text; charset=utf8")
	public String userAdd(@RequestParam String usercode, @RequestParam String phone) throws Exception {
		System.out.println("신규 유저 추가:::: usercode="+usercode+"/phone="+phone);
		
		UserVO user = new UserVO();
		user.setUsercode(usercode);
		user.setPhone(phone);
		user.setAgreeyn("N");
		user.setStatus("1");
		int result = service.userSave(user);
		
		String returnString = "";
		if(result > 0) {
			returnString =  " usercode="+usercode+"/phone="+phone + "::::: USER ADD SUCCESS";
		}else {
			returnString =  " usercode="+usercode+"/phone="+phone + "::::: USER ADD FAIL";
		}
		return returnString;
	}
	
	//관리자페이지에서 엑셀 업로드했을경우 사용자 정보변경 시 
	@RequestMapping(value="/user/modify", produces = "application/text; charset=utf8")
	public String userModify(@RequestParam String usercode, @RequestParam String phone, @RequestParam String status) throws Exception {
		System.out.println("기존 유저 수정:::: usercode="+usercode+"/phone="+phone+"/status="+status);
		int result = 0;
		UserVO user = service.userCheck(usercode);
		if(user != null) {
			user.setPhone(phone);
			user.setStatus(status);
			
			result = service.userUpdate(user);
		}
		String returnString = "";
		if(result > 0) {
			returnString =  " usercode="+usercode+"/phone="+phone + "::::: USER MODIFY SUCCESS";
		}else {
			returnString =  " usercode="+usercode+"/phone="+phone + "::::: USER MODIFY FAIL";
		}
		return returnString;
	}
	
	//관리자페이지에서 신규쿠폰 생성하였을경우 쿠폰 추가
	@RequestMapping(value="/coupon/add", produces = "application/text; charset=utf8")
	public String couponAdd(@RequestParam String couponcode, @RequestParam String couponname, @RequestParam String discountkind,@RequestParam String discountvalue,@RequestParam String useminimum,@RequestParam String discountmax) throws Exception {
		System.out.println("신규 쿠폰 추가:::: couponcode="+couponcode+"/couponname="+couponname);
		Date now = new Date();
		
		CouponCoreVO coupon = new CouponCoreVO();
		coupon.setCouponcode(couponcode);
		coupon.setCouponname(couponname);
		coupon.setUseminimum(useminimum);
		coupon.setDiscountkind(discountkind);
		coupon.setDiscountvalue(discountvalue);
		coupon.setDiscountmax(discountmax);
		coupon.setUseyn("Y");
		coupon.setCouponinfo("");
		coupon.setCreateuser("");
		coupon.setCreatedate(now);
		
		int result = cpservice.couponSave(coupon);
		String returnString = "";
		if(result > 0) {
			returnString =  " couponcode="+couponcode+"/couponname="+couponname + "::::: COUPON ADD SUCCESS";
		}else {
			returnString =  " couponcode="+couponcode+"/couponname="+couponname + "::::: COUPON ADD FAIL";
		}
		return returnString;
	}
	
	//관리자페이지에서 쿠폰 수정하였을경우 쿠폰 수정
	@RequestMapping(value="/coupon/modify", produces = "application/text; charset=utf8")
	public String couponModify(@RequestParam String couponcode, @RequestParam String couponname, @RequestParam String discountkind,@RequestParam String discountvalue,@RequestParam String useminimum,@RequestParam String discountmax) throws Exception {
		System.out.println("기존 쿠폰 수정:::: couponcode="+couponcode+"/couponname="+couponname);
		int result = 0;
		CouponCoreVO coupon = cpservice.getCouponInfo(couponcode);
		if(coupon != null) {
			coupon.setCouponname(couponname);
			coupon.setDiscountkind(discountkind);
			coupon.setDiscountvalue(discountvalue);
			coupon.setUseminimum(useminimum);
			coupon.setDiscountmax(discountmax);
			
			result = cpservice.couponUpdate(coupon);
		}
		String returnString = "";
		if(result > 0) {
			returnString =  " couponcode="+couponcode+"/couponname="+couponname + "::::: COUPON MODIFY SUCCESS";
		}else {
			returnString =  " couponcode="+couponcode+"/couponname="+couponname + "::::: COUPON MODIFY FAIL";
		}
		return returnString;
	}
	
	//관리자페이지에서 쿠폰 발행되었을경우
	@RequestMapping(value="/coupontomember/add", produces = "application/text; charset=utf8")
	public String coupontomemberAdd(@RequestParam String usercode, @RequestParam String couponcode, @RequestParam String couponno,
			@RequestParam String startdate, @RequestParam String enddate) throws Exception {
		System.out.println("신규 사용자 쿠폰 추가:::: usercode="+usercode+"/couponno="+couponno);
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(startdate));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(sdf.parse(enddate));
		cal2.set(Calendar.HOUR_OF_DAY, 23);
		cal2.set(Calendar.MINUTE, 59);
		cal2.set(Calendar.SECOND, 59);
		
		CouponVO coupon = new CouponVO();
		coupon.setUsercode(usercode);
		coupon.setCouponcode(couponcode);
		coupon.setCouponno(couponno);
		coupon.setCreatedate(now);
		coupon.setCreateuser("");
		coupon.setReason("");
		coupon.setStartdate(cal.getTime());
		coupon.setEnddate(cal2.getTime());
		coupon.setUseyn("N");
		coupon.setUsemanager(null);
		coupon.setUsedate(null);
		
		int result = cpservice.coupontomemberSave(coupon);
		
		String returnString = "";
		if(result > 0) {
			returnString =  " usercode="+usercode+"/couponno="+couponno + "::::: COUPONTOMEMBER ADD SUCCESS";
		}else {
			returnString =  " usercode="+usercode+"/couponno="+couponno + "::::: COUPONTOMEMBER ADD FAIL";
		}
		return returnString;
	}
	
	//관리자페이지에서 쿠폰 사용될 경우 & 삭제할 경우
	@RequestMapping(value="/coupontomember/modify", produces = "application/text; charset=utf8")
	public String coupontomemberModify(@RequestParam String couponno, @RequestParam String useyn, @RequestParam String usemanager, @RequestParam String usedate) throws Exception {
		System.out.println("기존 사용자 쿠폰 수정:::: couponno="+couponno+"/useyn="+useyn);
		//Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CouponVO coupon = cpservice.getCoupontomember(couponno);
		int result = 0;
		if(coupon != null) {
			coupon.setUseyn(useyn);
			coupon.setUsemanager(usemanager);
			coupon.setUsedate(sdf.parse(usedate));
			
			result = cpservice.coupontomemberUpdate(coupon);
		}
		String returnString = "";
		if(result > 0) {
			returnString =  " couponno="+couponno + "::::: COUPONTOMEMBER USE SUCCESS";
		}else {
			returnString =  " couponno="+couponno + "::::: COUPONTOMEMBER USE FAIL";
		}
		return returnString;
	}

}

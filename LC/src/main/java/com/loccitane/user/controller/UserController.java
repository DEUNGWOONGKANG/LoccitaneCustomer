package com.loccitane.user.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loccitane.coupon.domain.CouponVO;
import com.loccitane.coupon.service.CouponService;
import com.loccitane.user.domain.UserVO;
import com.loccitane.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Inject
	private UserService service; 
	@Inject
	private CouponService cpservice; 
	
	@RequestMapping(value="/login", method=RequestMethod.POST) 
	public ModelAndView loginUser(UserVO userVO, HttpServletResponse response) throws Exception { 
		ModelAndView nextView = new ModelAndView("jsp/customerCouponList");
		UserVO userData = service.userLogin(userVO); 
		if(userData == null) { 
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('등록된 고객 정보가 없습니다.'); history.go(-1);</script>");
            out.flush();
		}else { 
			List<CouponVO> couponList = cpservice.getUserCoupon(userVO.getUsercode()); 
			nextView.addObject("userData", userData); 
			nextView.addObject("couponList", couponList); 
			nextView.addObject("tel", userVO.getPhone());
		}
		return nextView;
	}
	
	@RequestMapping("/check/{usercode}") 
	public ModelAndView checkUser(@PathVariable("usercode") String usercode) throws Exception  {
		UserVO user = service.userCheck(usercode);
		ModelAndView nextView = new ModelAndView("jsp/customerMain");
		if(user == null) {
			nextView.addObject("check", "N");
		}else{
			nextView.addObject("check", "Y");
			nextView.addObject("usercode", usercode);
		}
		return nextView;
	}
}
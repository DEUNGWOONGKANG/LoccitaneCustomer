package com.loccitane.user.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
		ModelAndView nextView = null;
		UserVO userData = service.userLogin(userVO); 
		if(userData == null) { 
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('등록된 고객 정보가 없습니다.'); history.go(-1);</script>");
            out.flush();
		}else { 
			if(userData.getAgreeyn().equals("Y")) {
				nextView = new ModelAndView("jsp/customerCouponList");
				List<CouponVO> couponList = cpservice.getUserCoupon(userData.getUsercode()); 
				nextView.addObject("userData", userData); 
				nextView.addObject("couponList", couponList); 
				nextView.addObject("tel", userVO.getPhone());
			}else{
				nextView = new ModelAndView("jsp/customerAgreePage");
				nextView.addObject("userData", userData); 
				nextView.addObject("tel", userVO.getPhone());
			}
		}
		return nextView;
	}
	
	@RequestMapping(value="/agree", method=RequestMethod.POST) 
	public ModelAndView agreeUser(UserVO userVO, HttpServletResponse response) throws Exception { 
		ModelAndView nextView = new ModelAndView("jsp/customerCouponList");
		
		UserVO userData = service.userLogin(userVO); 
		userData.setAgreeyn("Y");
		int agree = service.userAgree(userData);
		System.out.println(agree);
		
		List<CouponVO> couponList = cpservice.getUserCoupon(userData.getUsercode()); 
		nextView.addObject("userData", userData); 
		nextView.addObject("couponList", couponList); 
		nextView.addObject("tel", userVO.getPhone());
		
		return nextView;
	}
	
	@RequestMapping(value = "/{usercode}", method = RequestMethod.GET)
	public ModelAndView checkUser(@PathVariable("usercode") String usercode){
		ModelAndView nextView = new ModelAndView("jsp/customerMain");
		nextView.addObject("usercode", usercode);
		return nextView;
	}
	//로그아웃
	@GetMapping("/logout/{usercode}") 
	public ModelAndView logoutManager(@PathVariable("usercode") String usercode){ 
		ModelAndView nextView = new ModelAndView("jsp/logout");
		nextView.addObject("usercode", usercode);
		
		return nextView;
	}
}
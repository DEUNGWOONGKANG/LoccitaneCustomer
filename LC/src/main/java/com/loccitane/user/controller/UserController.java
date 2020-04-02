package com.loccitane.user.controller;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private UserService service; 
	@Autowired
	private CouponService cpservice; 
	
	@RequestMapping(value="/login", method=RequestMethod.POST) 
	public ModelAndView loginUser(UserVO userVO, HttpServletResponse response) throws Exception { 
		ModelAndView nextView = null;
		UserVO userData = service.userLogin(userVO); 
		if(userData == null) { 
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('올바르지 않은 접속 경로 입니다. 가까운 매장 혹은 록시땅 고객센터(02-2054-0500)으로 연락 주시기 바랍니다.'); history.go(-1);</script>");
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
	public ModelAndView agreeUser(UserVO userVO) throws Exception { 
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
	public ModelAndView checkUser(@PathVariable("usercode") String usercode, HttpServletResponse response) throws Exception{
		//ModelAndView nextView = new ModelAndView("jsp/customerMain_bak");
		ModelAndView nextView = null;
		UserVO userData = service.userCheck(usercode);
		Date now = new Date();
		if(userData == null) {
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('올바르지 않은 접속 경로 입니다. 가까운 매장 혹은 록시땅 고객센터(02-2054-0500)으로 연락 주시기 바랍니다.'); history.go(-1);</script>");
            out.flush();
		}else {
			// 첫 접속 시도시 STARTDATE 입력 ( 멤버십정보를 노출시키기 위한 날짜 )
			if(userData.getStartdate() == null) {
				userData.setStartdate(now);
				service.userUpdate(userData);
			}
			// 첫 접속 시도부터 15일 이후 날짜 계산
			Calendar cal = Calendar.getInstance();
			cal.setTime(userData.getStartdate());
			cal.add(Calendar.DATE, 15);
			if(now.after(cal.getTime())) {
				nextView = new ModelAndView("jsp/customerMain");
			}else{
				if(userData.getEnddate() == null || userData.getEnddate().before(now)) {
					nextView = new ModelAndView("jsp/membershipInfo");
				}else if(userData.getEnddate().after(now)) {
					nextView = new ModelAndView("jsp/customerMain");
				}
			}
			nextView.addObject("usercode", usercode);
		}
				
		return nextView;
	}
	//로그아웃
	@GetMapping("/logout/{usercode}") 
	public ModelAndView logoutManager(@PathVariable("usercode") String usercode){ 
		ModelAndView nextView = new ModelAndView("jsp/logout");
		nextView.addObject("usercode", usercode);
		
		return nextView;
	}
	
	@RequestMapping(value = "/login/{usercode}", method = RequestMethod.GET)
	public ModelAndView login(@PathVariable("usercode") String usercode){ 
		ModelAndView nextView = new ModelAndView("jsp/customerMain");
		nextView.addObject("usercode", usercode);
		
		return nextView;
	}
	
	@RequestMapping(value = "/login7/{usercode}", method = RequestMethod.GET)
	public ModelAndView login7(@PathVariable("usercode") String usercode) throws Exception{ 
		UserVO userData = service.userCheck(usercode);
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DATE, 7);
		
		userData.setEnddate(cal.getTime());
		service.userUpdate(userData);
		
		ModelAndView nextView = new ModelAndView("jsp/customerMain");
		nextView.addObject("usercode", usercode);
		
		return nextView;
	}
	
	@GetMapping("/test/{usercode}") 
	public ModelAndView loginTest(@PathVariable("usercode") String usercode){ 
		ModelAndView nextView = new ModelAndView("jsp/customerMain");
		nextView.addObject("usercode", usercode);
		
		return nextView;
	}
	
}
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
	
	//고객 페이지 로그인 URL상 USERCODE와 휴대폰 뒷자리 4자리가 일치해야 접속 가능
	@RequestMapping(value="/login", method=RequestMethod.POST) 
	public ModelAndView loginUser(UserVO userVO, HttpServletResponse response) throws Exception { 
		ModelAndView nextView = null;
		UserVO userData = service.userLogin(userVO); 
		if(userData == null) { 
			//일치하는 고객정보가 없을경우
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('올바르지 않은 접속 경로 입니다. 가까운 매장 혹은 록시땅 고객센터(02-2054-0500)으로 연락 주시기 바랍니다.'); history.go(-1);</script>");
            out.flush();
		}else { 
			
			if(userData.getStatus().equals("9")) { //일치하는 고객 정보가 있지만 STATUS 값이 9인경우 (휴면)
				response.setContentType("text/html; charset=UTF-8");
	            PrintWriter out = response.getWriter();
	            out.println("<script>alert('휴면 사용자 입니다. 가까운 매장 혹은 록시땅 고객센터(02-2054-0500)으로 연락 주시기 바랍니다.'); history.go(-1);</script>");
	            out.flush();
			}else if(userData.getStatus().equals("1")) {//정상사용자의 경우
				if(userData.getAgreeyn().equals("Y")) { //정보제공 동의 된경우
					nextView = new ModelAndView("jsp/customerCouponList");
					//해당 사용자의 쿠폰리스트 조회
					List<CouponVO> couponList = cpservice.getUserCoupon(userData.getUsercode()); 
					nextView.addObject("userData", userData); 
					nextView.addObject("couponList", couponList);
					//검색시 사용했던 번호 
					nextView.addObject("tel", userVO.getPhone());
				}else{ //정보제공 동의가 되지 않은경우 정보제공동의 페이지로 이동
					nextView = new ModelAndView("jsp/customerAgreePage");
					nextView.addObject("userData", userData);
					//검색시 사용했던 번호
					nextView.addObject("tel", userVO.getPhone());
				}
			}
		}
		return nextView;
	}
	
	// 정보제공 동의 페이지에서 동의 했을 경우 
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
	
	//최초 쿠폰에서 URL링크 클릭하였을 경우
	@RequestMapping(value = "/{usercode}", method = RequestMethod.GET)
	public ModelAndView checkUser(@PathVariable("usercode") String usercode, HttpServletResponse response) throws Exception{
		ModelAndView nextView = null;
		//URL상 USERCODE존재 하는지 DB에서 체크
		UserVO userData = service.userCheck(usercode);
		Date now = new Date();
		if(userData == null) {
			//USERCODE에 일치하는 데이터가 없는 경우
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('올바르지 않은 접속 경로 입니다. 가까운 매장 혹은 록시땅 고객센터(02-2054-0500)으로 연락 주시기 바랍니다.'); history.go(-1);</script>");
            out.flush();
		}else { //USERCODE에 일치하는 사용자가 있는 경우
			// 첫 접속 시도시 STARTDATE 입력 (멤버십정보를 노출시키기 위한 날짜)
			if(userData.getStartdate() == null) {
				userData.setStartdate(now);
				service.userUpdate(userData);
			}
			// 첫 접속 시도부터 15일 이후 날짜 계산 (모든 사용자에게 멤버십 페이지를 15일간 띄워줘야함)
			Calendar cal = Calendar.getInstance();
			cal.setTime(userData.getStartdate());
			cal.add(Calendar.DATE, 15);
			if(now.after(cal.getTime())) { //15일이 지났을경우 쿠폰리스트 페이지로 이동
				nextView = new ModelAndView("jsp/customerMain");
			}else{ //15일이 지나지 않았을경우
				//7일간 보지않기 체크하기 
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
	//멤버십 정보 페이지에서 나의 쿠폰 보기 클릭시
	@RequestMapping(value = "/login/{usercode}", method = RequestMethod.GET)
	public ModelAndView login(@PathVariable("usercode") String usercode){ 
		ModelAndView nextView = new ModelAndView("jsp/customerMain");
		nextView.addObject("usercode", usercode);
		
		return nextView;
	}
	//멤버십 정보 페이지에서 7일간 보지않기 클릭시
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
}
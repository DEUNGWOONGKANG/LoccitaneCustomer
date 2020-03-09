package com.loccitane.user.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loccitane.coupon.domain.CouponVO;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping(value="/login") 
	public ModelAndView loginUser(HttpServletResponse response, HttpServletRequest request) throws Exception { 
		ModelAndView nextView = new ModelAndView("jsp/customerCouponList");
		List<CouponVO> couponList = new ArrayList<CouponVO>();
		
		 try {
	        CloseableHttpClient httpclient = HttpClients.createDefault();
	        //GET 방식으로 parameter를 전달
	        //HttpGet httpGet = new HttpGet("http://localhost:8081/customer/login?code="+request.getParameter("usercode")+"&phone="+request.getParameter("phone"));
	        HttpGet httpGet = new HttpGet("http://14.52.9.171:8080/customer/login?code="+request.getParameter("usercode")+"&phone="+request.getParameter("phone"));
	        CloseableHttpResponse res = httpclient.execute(httpGet);
	        try {
	            String data = EntityUtils.toString(res.getEntity(), "UTF-8");
	            JSONParser parser = new JSONParser();
	            Object obj = parser.parse( data );
	            JSONArray jsonArrayList = (JSONArray) obj;
	            SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
	            for(int i=0; i<jsonArrayList.size(); i++) {
	            	JSONObject jsoncoupon = (JSONObject) jsonArrayList.get(i);
	            	CouponVO coupon = new CouponVO();
	            	coupon.setUsercode((String)jsoncoupon.get("usercode"));
	            	coupon.setUsername((String)jsoncoupon.get("username"));
	            	coupon.setCouponcode((String)jsoncoupon.get("cpcode"));
	            	coupon.setCouponno((String)jsoncoupon.get("couponno"));
	            	coupon.setCouponname((String)jsoncoupon.get("cpname"));
	            	coupon.setDiscountkind((String)jsoncoupon.get("dck"));
	            	coupon.setDiscountvalue((String)jsoncoupon.get("dccnt"));
	            	coupon.setCreatedate(transFormat.parse((String) jsoncoupon.get("issueday")));
	            	coupon.setStartdate(transFormat.parse((String) jsoncoupon.get("startdate")));
	            	coupon.setEnddate(transFormat.parse((String) jsoncoupon.get("enddate")));
	            	coupon.setUseyn((String)jsoncoupon.get("usedyn"));
	            	coupon.setUsemanager((String)jsoncoupon.get("usemanager"));
	            	if(jsoncoupon.get("usedate") != null) {
	            		coupon.setUsedate(transFormat.parse((String) jsoncoupon.get("usedate")));
	            	}else{
	            		coupon.setUsedate(null);
	            	}
	            	coupon.setCouponinfo((String)jsoncoupon.get("memo"));
	            	coupon.setUseminimum((String)jsoncoupon.get("minimum"));
	            	coupon.setDiscountmax((String)jsoncoupon.get("discountmax"));
	            	coupon.setReason((String)jsoncoupon.get("reason"));
	            	couponList.add(coupon);
	            }
	            nextView.addObject("couponList", couponList);
	            nextView.addObject("username", couponList.get(0).getUsername());
	            nextView.addObject("usercode", couponList.get(0).getUsercode());
		        } finally {
		        	res.close();
		        }  
		    } catch (Exception e) {
		    	response.setContentType("text/html; charset=UTF-8");
	            PrintWriter out = response.getWriter();
	            out.println("<script>alert('고객정보 에러'); history.go(-1);</script>");
	            out.flush();
		    }
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
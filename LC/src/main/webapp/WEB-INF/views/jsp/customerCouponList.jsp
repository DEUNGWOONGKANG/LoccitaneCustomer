<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
<script src="/resources/js/jquery-3.4.1.min.js"></script>
<script src="/resources/js/bootstrap.js"></script>
<script type="text/javascript">
function usedY(){
	var useY = document.getElementById("use");
	var useN = document.getElementById("unuse");
	
	useN.style.display = "block";
	useY.style.display = "none";
}
function usedN(){
	var useY = document.getElementById("use");
	var useN = document.getElementById("unuse");
	
	useN.style.display = "none";
	useY.style.display = "block";
}
function usecoupon(){
	document.getElementById("usecoupon").click();
}
function logout(){
	var result = confirm("로그아웃 하시겠습니까?");
	if(result){
		location.href = "/user/logout/${userData.usercode}";
	}
}
function click(use){
	if(use == "Y"){
		document.getElementById("useYY")
	}
}
</script>
<link rel="stylesheet" href="/resources/css/lc_common.css">
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<jsp:useBean id="today" class="java.util.Date" />
</head>
<body leftmargin="0" rightmargin="0" topmargin="0" onload="usecoupon()">
<div id="headline"></div>
<div id="logoutdiv">
<input type="button" class="button-gray" value="로그아웃" onclick="logout();">
</div>
<div id="logo_div"><img id="logo" src="/resources/img/logo.png" width="50%"></div>
<table style="width:100%">
	<tr>
		<td colspan=3 height="50px">
		</td>
	</tr>
	<tr>
		<td width="10%">
		</td>
		<td style="text-align:center;">
			<div class="infoTitle">[${tel}]님께서 발급받으신 <span style="color:red;">쿠폰</span> 내역 입니다.</div>
		</td>
		<td width="10%">
		</td>
	</tr>
	<tr>
		<td colspan=3 height="10px">
		</td>
	</tr>
	<tr>
		<td width="10%">
		</td>
		<td style="text-align:center;">
			<div class="infotext">
			</div>
		</td>
		<td width="10%">
		</td>
	</tr>
	<tr>
		<td colspan=3 height="50px">
		</td>
	</tr>
	<tr>
		<td width="10%">
		</td>
		<td style="width:80%; text-align:center">
			<div class="btn-group btn-group-toggle" data-toggle="buttons" style="width:100%">
				<label id="useYY" class="btn btn-warning btn-lg">
					<input type="radio" name="jb-radio" id="usecoupon" onclick="usedY()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>사용가능</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label>
				<label id="useNN" class="btn btn-warning btn-lg">
					<input type="radio" name="jb-radio" id="unusecoupon" onclick="usedN()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>사용만료</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label>
			</div>
		</td>
		<td width="10%">
		</td>
	</tr>
</table>
<div style="width:100%;margin-bottom:30px;" id="unuse">
	<c:forEach var="coupon" items="${couponList}">
	<c:if test="${coupon.useyn eq 'N' and coupon.startdate < today and coupon.enddate > today}">
		<div id="container">
			<div class="bubble">
				<div class="rectangle"><h2>${coupon.couponname}</h2></div>
				<div class="triangle-l"></div>
				<div class="triangle-r"></div>
				<div class="info">
					<h2>${coupon.couponinfo}</h2>
					<c:if test="${!empty coupon.useminimum}">
			      		${coupon.useminimum}원 이상 구매시
			      	</c:if>
			      	${coupon.discountvalue}
			      	<c:if test="${coupon.discountkind == 1}">
			      	원 할인
			      	</c:if>
			      	<c:if test="${coupon.discountkind == 2}">
			      	% 할인
			      	</c:if><br>
			      	<c:if test="${!empty coupon.discountmax}">
			      	(최대할인  ${coupon.discountmax}원 까지)
			      	</c:if><br>
					유효기간 : 
					<fmt:formatDate value="${coupon.startdate}" pattern="YYYY-MM-dd"/> ~
					<fmt:formatDate value="${coupon.enddate}" pattern="YYYY-MM-dd"/>
				</div>
			</div>
		</div>
	</c:if>
	</c:forEach>
	<c:if test="${empty couponList}">
		<div class="nodata">
			쿠폰이 존재하지 않습니다.
		</div>
	</c:if>
</div>
<div style="width:100%;margin-bottom:30px;" id="use">
	<c:forEach var="coupon" items="${couponList}">
	<c:if test="${coupon.useyn eq 'Y' or coupon.startdate > today or coupon.enddate < today}">
		<div id="container">
			<div class="bubble2">
				<div class="rectangle"><h2>${coupon.couponname}</h2></div>
				<div class="triangle-l"></div>
				<div class="triangle-r"></div>
				<div class="info">
					<h2>${coupon.couponinfo}</h2>
					<c:if test="${!empty coupon.useminimum}">
			      		${coupon.useminimum}원 이상 구매시
			      	</c:if>
			      	${coupon.discountvalue}
			      	<c:if test="${coupon.discountkind == 1}">
			      	원 할인
			      	</c:if>
			      	<c:if test="${coupon.discountkind == 2}">
			      	% 할인
			      	</c:if><br>
			      	<c:if test="${!empty coupon.discountmax}">
			      	(최대할인  ${coupon.discountmax}원 까지)
			      	</c:if><br>
					유효기간 : 
					<fmt:formatDate value="${coupon.startdate}" pattern="YYYY-MM-dd"/> ~
					<fmt:formatDate value="${coupon.enddate}" pattern="YYYY-MM-dd"/>
				</div>
			</div>
		</div>
	</c:if>
	</c:forEach>
	<c:if test="${empty couponList}">
		<div class="nodata">
			쿠폰이 존재하지 않습니다.
		</div>
	</c:if>
</div>
</body>
</html>
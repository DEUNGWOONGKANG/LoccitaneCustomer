<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
<link rel="stylesheet" href="/resources/css/lc_common.css">
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<script src="/resources/js/jquery-3.4.1.min.js"></script>
<script src="/resources/js/bootstrap.js"></script>
<script type="text/javascript">
function goback(){
	history.back();
}
</script>
<jsp:useBean id="today" class="java.util.Date" />
</head>
<body leftmargin="0" rightmargin="0" topmargin="0">
<div id="headline"></div>
<div id="logo_div"><img id="logo" src="/resources/img/logo.png" width="30%"></div>
<form id="dataForm" action="/user/agree" method="post">
<input type="hidden" id="usercode" name="usercode" value="${userData.usercode }">
<input type="hidden" id="phone" name="phone" value="${tel}">
<table style="width:100%">
	<tr>
		<td colspan=3 height="50px">
		</td>
	</tr>
	<tr>
		<td width="10%">
		</td>
		<td style="text-align:center;">
			<div class="infoTitle">쿠폰서비스 이용 동의</div>
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
		<td style="text-align:center;height:500px;">
			<textarea style="width:80%;height:90%;font-size:20px;">이용동의
			
쿠폰서비스 추가
본 서비스는 록시땅코리아 유한책임회사 고객여러분에게 제공하는 서비스로 2020년 04월 01일부터 2021년 03월 31일까지만 제공하는 서비스입니다. 본 서비스를 사용하시려면 아래의 동의를 누르셔야 합니다.

개인정보의 제3자 제공
본 서비스의 원활한 이용을 위하여 개인정보 중 회원번호, 전화번호 뒷 4자리가 제3자에게 제공됩니다.
제공처 : 콘센트릭스서비스 코리아 유한회사
제공정보 : 회원번호, 전화번호 뒷 4자리
			</textarea>
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
			<input type="button" class="button-gray" value="닫기" onclick="goback();">
			<input type="submit" class="button-yellow" value="서비스 동의">
		</td>
		<td width="10%">
		</td>
	</tr>
</table>
</form>
</body>
</html>
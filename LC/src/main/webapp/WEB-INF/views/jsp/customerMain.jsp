<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
<link rel="stylesheet" href="/resources/css/lc_common.css" type="text/css">
<script type="text/javascript">

function check(){
	document.getElementById("loginForm").submit();
}

</script>
</head>
<body leftmargin="0" rightmargin="0" topmargin="0">
<div id="headline"></div>
<div id="logo_div"><img id="logo" src="/resources/img/logo.png" width="50%"></div>
<form id="loginForm" action="/user/login" method="post" onsubmit="return check()">
<table style="width:100%">
	<tr>
		<td colspan=3 height="150px">
		</td>
	</tr>
	<tr>
		<td width="5%">
		</td>
		<td>
			<div class="infoTitle">휴대폰 뒷 번호 4자리를 입력하세요.</div>
		</td>
		<td width="5%">
		</td>
	</tr>
	<tr>
		<td colspan=3 height="50px">
		</td>
	</tr>
	<tr>
		<td width="5%">
		</td>
		<td>
			<div id="infoText">고객 확인을 위해 본인의 휴대폰 뒷 번호 4자리를 입력하세요.
			<br>입력 후 쿠폰 확인 페이지로 이동합니다.</div>
		</td>
		<td width="5%">
		</td>
	</tr>
	<tr>
		<td colspan=3 height="100px">
		</td>
	</tr>
	<tr>
		<td width="5%">
		</td>
		<td width="90%" style="text-align:center;">
				<input type="number" class="endNumInput" id="phone" name="phone" style="width:70%;height:100px;font-size:40px;text-align:center;">
				<input type="hidden" value="${usercode}" id="usercode" name="usercode">
		</td>
		<td width="5%">
		</td>
	</tr>
	<tr>
		<td colspan=3 height="100px">
		</td>
	</tr>
	<tr>
		<td width="5%">
		</td>
		<td width="90%" style="text-align:center;">
			<input id="submitbtn" type="submit" class="button-yellow" value="확인">
		</td>
		<td width="5%">
		</td>
	</tr>
</table>
</form>
</body>
</html>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
<script type="text/javascript">

function check(){
	var phone = document.getElementById("phone");
	if(phone.value == "" || phone.value.length != 4){
		alert("�޴��� �� ��ȣ 4�ڸ��� �Է��ϼ���");
		return false;
	}else{
		document.getElementById("loginForm").submit();
	}
	
}

</script>
</head>
<body leftmargin="0" rightmargin="0" topmargin="0" style="background:#FFCA08;">
<a href="/user/login/${usercode}"><img src="/resources/img/membershipInfo.png" style="width:100%"/></a>
<div style="font-size:25pt; width:100%; text-align:right;background:#FFCA08;">
	<a href="/user/login7/${usercode}" style="color:#000;text-decoration:none;"><b>7�ϵ��� ���� �ʱ�&nbsp;&nbsp;&nbsp;</b></a>
	<br><br>
</div>
</body>
</html>
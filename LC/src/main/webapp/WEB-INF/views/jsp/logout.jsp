<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>LogOut</title>
</head>
<body>
<%
	session.invalidate(); // 세션 초기화
%>
<script>
alert("로그아웃 되었습니다.");
location.href='/user/${usercode}';
</script>
</body>
</html>
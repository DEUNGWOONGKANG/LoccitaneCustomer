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
			<div class="infoTitle">�������� �̿� ����</div>
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
			<textarea style="width:80%;height:90%;font-size:20px;">�̿뵿��
			
�������� �߰�
�� ���񽺴� �Ͻö��ڸ��� ����å��ȸ�� �������п��� �����ϴ� ���񽺷� 2020�� 04�� 01�Ϻ��� 2021�� 03�� 31�ϱ����� �����ϴ� �����Դϴ�. �� ���񽺸� ����Ͻ÷��� �Ʒ��� ���Ǹ� �����ž� �մϴ�.

���������� ��3�� ����
�� ������ ��Ȱ�� �̿��� ���Ͽ� �������� �� ȸ����ȣ, ��ȭ��ȣ �� 4�ڸ��� ��3�ڿ��� �����˴ϴ�.
����ó : �ܼ�Ʈ�������� �ڸ��� ����ȸ��
�������� : ȸ����ȣ, ��ȭ��ȣ �� 4�ڸ�
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
			<input type="button" class="button-gray" value="�ݱ�" onclick="goback();">
			<input type="submit" class="button-yellow" value="���� ����">
		</td>
		<td width="10%">
		</td>
	</tr>
</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>

<form id="" action="/fems/logintype"  method="post" name="formm">

	<table class="tb-border">
	<tr><td rowspan="4"><img src="<%=request.getContextPath()%>/resources/images/fems_logo.png"></td>
	<td colspan="2"><img src="<%=request.getContextPath()%>/resources/images/uni_logo.png"></td></tr>
	<tr><td colspan="2">	
			<table class="def-table tb-border">
				<tr><td><input type="text" class="def-input-text-md" name="id" placeholder="아이디"></td>
					<td rowspan="2">
					<input type="submit" class="def-btn" id="admin_join_btn" value="로그인" onclick="go_index()"></td></tr>
				<tr><td><input type="password" class="def-input-text-md" name="password" placeholder="패스워드"></td></tr>
				<tr><td colspan="2"><span id='change'>여기 아작스</span></td></tr>
			</table></td></tr>
		<tr><td><input type="button" class="def-btn" value="ID찾기" onclick="modal_find_id()"></td><td><input type="button" value="PW찾기" onclick="modal_find_pw()"></td></tr>
	</table>
</form>

<!-- Footer 시작 -->
	<footer class="footer container-fluid text-center">
		<p>Footer Text</p>
	</footer>
	<!-- Footer 끝 -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>
<article>
<form id="admin_join" action="/fems/admin/step1_add"  method="post" name="formm">

	<div>
		<img src="<%=request.getContextPath()%>/resources/images/fems_logo.png"><br/>
		
		<div>
			<table class="def-table tb-border">
				<tr><td><input type="text" class="def-input-text-md" name="id" placeholder="아이디"></td>
					<td rowspan="3">
					<input type="submit" class="def-btn" id="admin_join_btn" value="회원가입 및 시작하기" onclick="go_step1_add()"></td></tr>
				<tr><td><input type="password" class="def-input-text-md" name="password" placeholder="패스워드"></td></tr>
				<tr><td><input type="text" class="def-input-text-md" name="email" placeholder="이메일"></td></tr>
				<tr><td colspan="2"><span id='change'></span></td></tr>
			</table>
		</div>
		
	
	</div>

</form>
</article>
</body>
</html>
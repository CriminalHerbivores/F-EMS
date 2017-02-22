<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * F-EMS를 처음 사용할 때 관리자 가입을 할 수 있는 JSP
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH        최초작성
 * 2017.02.23      KJH        추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<article>
<form method="post" name="formm">
<table class="non-border margin-auto">
	<tr><td>
	<div>
		<img src="<%=request.getContextPath()%>/resources/images/fems_logo.png"><br/>
		
		<div>
			<table class="def-table tb-border">
				<tr><td><input type="text" class="def-input-text-md" name="stf_Sklstf_No" placeholder="아이디"></td>
					<td rowspan="3">
					<input type="submit" class="def-btn" id="admin_join_btn" value="회원가입 및 시작하기" onclick="go_step1Add()"></td></tr>
				<tr><td><input type="password" class="def-input-text-md" name="stf_Pw" placeholder="패스워드"></td></tr>
				<tr><td><input type="text" class="def-input-text-md" name="stf_Email" placeholder="이메일"></td></tr>
				<tr><td colspan="2"><span id='change'></span></td></tr>
			</table>
		</div>
	</div>

</td></tr></table>
</form>
</article>
</body>
</html>
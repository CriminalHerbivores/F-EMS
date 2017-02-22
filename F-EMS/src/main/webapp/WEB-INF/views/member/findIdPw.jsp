<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
<script>
</script>
</head>
<body>
	<table class="def-table-full">
	<tr>
	<td>
	<h3>아이디 찾기</h3><br/>
	</td><td>
	<h3>비밀번호 찾기</h3><br/>
	</td>
	</tr>
	<tr>
	<td>
		<form id="idformm" method="post">
			<table class="def-table-auto">
			<tr><td>
			이  름</td><td> 
			<input type="text" id="idName" class="def-input-text-md custom-form-control" name="name"/><br/><br/>
			</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td>
			이메일</td><td>
			<input type="text" id="idEmail" class="def-input-text-md custom-form-control" name="email"/><br/><br/>
			</td></tr>
			</table>
			<input class="def-btn btn-sm btn-color" type="button" value="아이디 찾기" onclick="findId();"/>
			<div><span id="messageId"></span></div>
		</form>
	</td><td>
		<form method="post">
			<table class="def-table-auto">
			<tr><td>
			아이디</td><td>
			<input type="text" id="pwId" class="def-input-text-md custom-form-control" name="id"/><br/><br/>		
			</td></tr><tr><td>
			이  름</td><td>
			<input type="text" id="pwName" class="def-input-text-md custom-form-control" name="name"/><br/><br/>		
			</td></tr><tr><td>
			이메일</td><td>
			<input type="text" id="pwEmail" class="def-input-text-md custom-form-control" name="email"/><br/><br/>
			</td></tr>
			</table>
			<input class="def-btn btn-sm btn-color" type="button" value="비밀번호 찾기" onclick="findPw();"/>
			<div><span id="message"></span></div>
		</form>
	</td>
	</tr>
	<tr><td colspan="2">
	<a href="<%=request.getContextPath()%>/loginForm"><input class="def-btn btn-sm btn-color" type="button" value="로그인 페이지로"/></a>
	</td></tr>
	</table>
</body>
</html>


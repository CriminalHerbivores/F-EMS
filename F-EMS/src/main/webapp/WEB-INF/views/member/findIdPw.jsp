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
<style type="text/css">
body {
    background: linear-gradient( to bottom, ${manageVO.mng_Sub_Color2} 8%, white 20%) no-repeat fixed;
}
</style>
</head>
<body>
<br/>
	<table class="def-table-auto">
	<tr>
		<td height="3px" colspan="5"><h3>아이디/비밀번호 찾기</h3><br/></td>
	</tr>
	<tr>
		<th height="3px" colspan="5"></th>
	</tr>
	<tr>
	<td>
		<form id="idformm" method="post">
			<div style="width:300px;">
			<h3>아이디 찾기</h3><hr><br/>	
			<input type="text" placeholder="이름" id="idName" class="def-input-text-md custom-form-control" name="name"/><br/><br/>
			<input type="text" placeholder="이메일" id="idEmail" class="def-input-text-md custom-form-control" name="email"/><br/><br/><br/>	
			<input class="def-btn btn-sm btn-color" type="button" value="아이디 찾기" onclick="findId();"/>
			</div>
		</form>
	</td><td>
		<form method="post">
			<div style="width:300px;">
			<h3>비밀번호 찾기</h3><hr>
			<input type="text" placeholder="아이디" id="pwId" class="def-input-text-md custom-form-control" name="id"/><br/><br/>		
			<input type="text" placeholder="이름" id="pwName" class="def-input-text-md custom-form-control" name="name"/><br/><br/>		
			<input type="text" placeholder="이메일" id="pwEmail" class="def-input-text-md custom-form-control" name="email"/><br/><br/>
			<input class="def-btn btn-sm btn-color" type="button" value="비밀번호 찾기" onclick="findPw();"/>
			</div>
		</form>
	</td>
	</tr>
	<tr>
		<th height="3px" colspan="5"></th>
	</tr>
	<tr><td colspan="5">
	<a href="<%=request.getContextPath()%>/index"><input class="def-btn btn-md btn-color" type="button" value="로그인 페이지로"/></a>
	</td></tr>
	</table>
</body>
</html>


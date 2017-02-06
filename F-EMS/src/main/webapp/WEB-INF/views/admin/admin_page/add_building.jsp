<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>

<body>
<article>
<form id="add_building" action="/fems/admin/main" method="post" name="formm">
<h1>건물 등록</h1>

	<table class="def-table tb-border">
		<tr><td>건물 번호</td><td><input type="text" class=".def-input-text-lg"></td><td><input type="button" class="def-btn" value="중복 확인"></td><td>여기에 아작스로 사용가능여부</tr>
		<tr><td>건물 이름</td><td><input type="text" class=".def-input-text-lg"></td><td><input type="button" class="def-btn" value="중복 확인"></td><td>여기에 아작스로 사용가능여부</tr>
	</table>

<br/>
<input type="button" class="def-btn" value="이전" onclick="history.go(-1);">&nbsp;&nbsp;<input type="submit" class="def-btn" value="등록" onclick="go_admin_page()">


</form>
</article>
</body>
</html>
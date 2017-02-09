<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>

<body>
	<a href="<%=request.getContextPath() %>/index" class="no-uline">메인으로 가기</a><br/>
	<a href="<%=request.getContextPath() %>/a" class="no-uline">직원 페이지</a><br/>
	<a href="<%=request.getContextPath() %>/admin/admin_join" class="no-uline">관리자 가입</a><br/>
	<a href="<%=request.getContextPath() %>/loginForm" class="no-uline">로그인</a><br/>
	<a href="<%=request.getContextPath() %>/schlship/schlshipList" class="no-uline">장학금</a><br/>
	---------------<br/>
	<a href="<%=request.getContextPath() %>/type_login" class="no-uline">로그인형</a><br/>
	<a href="<%=request.getContextPath() %>/type_multi" class="no-uline">복합형</a><br/>
	<a href="<%=request.getContextPath() %>/type_board" class="no-uline">게시판형</a><br/>
	<a href="<%=request.getContextPath() %>/type_menu" class="no-uline">메뉴강조형</a><br/>
	
	
</body>
</html>
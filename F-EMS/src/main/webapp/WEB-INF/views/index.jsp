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
	<a href="<%=request.getContextPath() %>/index">메인으로 가기</a><br/>
	<a href="<%=request.getContextPath() %>/a">직원 페이지</a><br/>
	<a href="<%=request.getContextPath() %>/sklstf/adminJoin">관리자 가입</a><br/>
	<a href="<%=request.getContextPath() %>/schlship/schlshipList">장학금</a><br/>
	---------------<br/>
	<a href="<%=request.getContextPath() %>/lgLogin">로그인형</a><br/>
	<a href="<%=request.getContextPath() %>/lgMulti">복합형</a><br/>
	<a href="<%=request.getContextPath() %>/lgBoard">게시판형</a><br/>
	<a href="<%=request.getContextPath() %>/lgMenu">메뉴강조형</a><br/>
	
	
</body>
</html>
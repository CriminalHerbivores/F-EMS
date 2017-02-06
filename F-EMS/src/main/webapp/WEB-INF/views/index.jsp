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
	<a href="<%=request.getContextPath()%>/notice_bbs/noticeList" class="no-uline">공지게시판</a><br/>
	<a href="<%=request.getContextPath() %>/a" class="no-uline">직원 페이지</a><br/>
	<a href="<%=request.getContextPath() %>/admin/admin_join" class="no-uline">관리자 가입</a><br/>
	<a href="<%=request.getContextPath() %>/loginForm" class="no-uline">로그인</a><br/>
	<a href="<%=request.getContextPath() %>/stdnt/sknrgsList" class="no-uline">학생/학적관리</a><br/>
		
</body>
</html>
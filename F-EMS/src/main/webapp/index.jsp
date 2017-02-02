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
	<br/><br/><br/>
</body>
</html>
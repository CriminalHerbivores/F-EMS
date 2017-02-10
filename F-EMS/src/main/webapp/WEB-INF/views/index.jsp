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
	<h2><a href="<%=request.getContextPath() %>/cssExample">CSS 예시 보기</a></h2><br/>
	※ 각각 메뉴에 반영하고 싶은 url 및 메뉴 이름(순서 맞춰서) 해당영역에 넣어두면 데코레이터에 반영 ※<br/>
	--------- 기타 ---------<br/>
	<a href="<%=request.getContextPath() %>/index">메인으로 가기</a><br/>
	--------- 직원 ---------<br/>
	<a href="<%=request.getContextPath() %>/a">직원 페이지</a><br/>
	<a href="<%=request.getContextPath() %>/schlship/schlshipList">장학금</a><br/>
	--------- 교수 ---------<br/>
	--------- 학생 ---------<br/>
	--------- 학사 ---------<br/>
	--------- 수강신청 ---------<br/>
	--------- 강의 ---------<br/>
	--------- 커뮤니티 ---------<br/>
	--------- 관리자 ---------<br/>
	<a href="<%=request.getContextPath() %>/sklstf/adminJoin">관리자 가입</a><br/>
	<a href="<%=request.getContextPath() %>/lgLogin">로그인형</a><br/>
	<a href="<%=request.getContextPath() %>/lgMulti">복합형</a><br/>
	<a href="<%=request.getContextPath() %>/lgBoard">게시판형</a><br/>
	<a href="<%=request.getContextPath() %>/lgMenu">메뉴강조형</a><br/>
	
	
</body>
</html>
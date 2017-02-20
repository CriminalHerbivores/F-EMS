<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>

<h2>개설 강의</h2>
<table class="def-table-auto tb-border table-hover">
	<tr><td>개설년도</td><td>학기</td><td>강의명</td><td>개설여부</td></tr>
	
	<!-- 로그인한 교수가 개설요청한 강의목록 가져오기 -->
	<c:forEach items="${lctre_SearchVO}" var="lctre">
	
	<tr>
		<td><fmt:formatDate value="${lctre.lc_Lctrbgn_Dt }"/></td><!-- 개설일 년도 가져와야 할거같음 -->
		<td></td>
		<td>${lctre.lu_Lctre_Nm}</td>
		<td>${lctre.lc_Open_At}</td>
	</tr>	
	</c:forEach>
	
	
</table>

</body>
</html>
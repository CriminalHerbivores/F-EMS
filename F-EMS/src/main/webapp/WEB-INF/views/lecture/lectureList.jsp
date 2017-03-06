<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h2>강의 목록</h2><br/>
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>No</th>
		<th>강의 번호</th>
		<th style="width:500px;">강의명</th>
		<th>주간 강의 요일</th>
		<th>강의실 번호</th>
	</tr>
	<c:forEach items="${lctreList}" var="lec" varStatus="status">
	<tr>
		<td>${status.count}</td>
		<td>${lec.lc_Lctre_Code}-${lec.lc_Split}</td>
		<td><a href="detailLctre?lc_Lctre_No=${lec.lc_Lctre_No}&table_Nm=${table_Nm}">${lec.lu_lctre_nm}</a></td>
		<td>${lec.lc_Wik_Lctre_Dayweek}(${lec.lc_Lctre_Time})</td>
		<td>${lec.lc_Lctrum_No}</td>
	</tr>
	</c:forEach>
</table>
<br/><br/><br/>
</body>
</html>

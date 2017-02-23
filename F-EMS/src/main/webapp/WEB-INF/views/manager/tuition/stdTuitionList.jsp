<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
* <pre>
* 
* </pre>
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 2. 22.      JAR      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h2>등록금 납부 내역 조회</h2>
	<table class="def-table-full tb-border table-hover">
	<tr>
		<td>단과</td>
		<td>학부</td>
		<td>학과</td>
		<td>학생번호</td>
		<td>등록금</td>
		<td>납부기간</td>
		<td>납부날짜</td>
	</tr>
	<c:forEach var="tut" items="${tuitionList}">
		<tr>
			<td>${tut.coleg_Nm}</td>
			<td>${tut.fc_Faculty_Nm}</td>
			<td>${tut.sit_Subjct}</td>
			<td>${tut.st_Stdnt_No}</td>
			<td><fmt:formatNumber value="${tut.sit_Tut}"/> 원</td>
			<td>${tut.tu_Dt} ~ ${tut.tu_Dt_L}</td>
			<td>${tut.tu_Pay_Dt}</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="7">${paging}</td>
	</tr>
	</table>
	<form name="searchForm">
		<select name="key">
			<option value="sit_Subjct">학과</option>
			<option value="tu_Stdnt_No">학생</option>
			<option value="tu_Dt">날짜</option>
		</select>
		<input type="text" name="value"/>
		<input type="button" value="검색" onclick="searchMe(this.form)" class="def-btn btn-sm btn-color"/>
	</form>
	<a href="toStdTuition?tpage=${tpage}"><input type="button" value="등록금 고지" class="def-btn btn-color"></a>
</body>
</html>
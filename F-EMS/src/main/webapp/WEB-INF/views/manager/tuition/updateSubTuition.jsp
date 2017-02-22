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
	<h2>학과 정보 조회</h2>
	<form name="formm">
	<table class="def-table-full tb-border table-hover">
		<tr>
			<th>단과</th>
			<th>학부</th>
			<th>학과</th>
			<th>등록금</th>
			<th>학과 전화번호</th>
		</tr>
		<tr>
			<td>${tut.coleg_Nm}</td>
			<td>${tut.fc_Faculty_Nm}</td>
			<td>${tut.sit_Subjct}</td>
			<td><fmt:formatNumber value="${tut.sit_Tut}"/> 원</td>
			<td>${tut.sit_Subjct_Tlphon_No}</td>
		</tr>
		<tr>
			<th colspan="3">등록금 수정</th>
			<th>상승률</th>
			<th>수정</th>
		</tr>
		<tr>
			<td colspan="3">
				<input type="number" name="sit_Tut">
			</td>
			<td>
				<input type="hidden" name="sit_Subjct_Code" value="${tut.sit_Subjct_Code}">
				<div id="increaseTut"></div>
			</td>
			<td>
				<input type="button" value="수정" onclick="submitForm(this.form)">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
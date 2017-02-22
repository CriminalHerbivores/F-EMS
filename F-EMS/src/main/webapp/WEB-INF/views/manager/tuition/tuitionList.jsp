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
	<h2>학과 / 등록금 조회</h2>
	<table class="def-table-full tb-border table-hover">
	<tr>
		<td>단과</td>
		<td>학부</td>
		<td>학과</td>
		<td>등록금</td>
		<td>학과 전화번호</td>
		<td>수정</td>
	</tr>
	<c:forEach var="tut" items="${tuitionList}">
		<tr>
			<td>${tut.coleg_Nm}</td>
			<td>${tut.fc_Faculty_Nm}</td>
			<td>${tut.sit_Subjct}</td>
			<td><fmt:formatNumber value="${tut.sit_Tut}"/> 원</td>
			<td>${tut.sit_Subjct_Tlphon_No}</td>
			<td>
				<a href="updateSubTuition?sit_Subjct_Code=${tut.sit_Subjct_Code}&tpage=${tpage}"><input type="button" value="수정" class="def-ckbtn btn-sm ckbtn-color"></a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="6">${paging}</td>
	</tr>
	</table>
	<form name="searchForm">
		<input type="hidden" id="key" name="key" value="sit_Subjct"/>
		<input type="text" name="value"/>
		<input type="button" value="검색" onclick="searchMe(this.form)" class="def-ckbtn btn-sm ckbtn-color"/>
	</form>
	<a href="toStdTuition?tpage=${tpage}"><input type="button" value="등록금 고지" class="def-ckbtn btn-sm ckbtn-color"></a>
</body>
</html>
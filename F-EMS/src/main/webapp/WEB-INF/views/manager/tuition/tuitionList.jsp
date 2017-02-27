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
<table class="non-border margin-auto"><tr><td>
	<h2>학과 / 등록금 조회</h2>
	<table class="def-table-full tb-border table-hover">
	<tr>
		<th>단과</th>
		<th>학부</th>
		<th>학과</th>
		<th>등록금</th>
		<th>학과 전화번호</th>
		<th>수정</th>
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
		<input type="text" name="sit_Subjct" class="def-input-text-lg custom-form-control"/>
		<input type="button" value="검색" class="def-btn btn-sm btn-color"/>
	<a href="toStdTuition?tpage=${tpage}"><input type="button" value="등록금 고지" class="def-btn btn-color"></a>
	<a href="stdTuitionList"><input type="button" value="등록금 납부 내역 조회" class="def-btn btn-color"></a>
	</form>
</td></tr></table>
</body>
</html>
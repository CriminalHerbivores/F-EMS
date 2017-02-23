<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		<td>등록금</td>
		<td>납부기한</td>
		<td>납부내역</td>
	</tr>
	<c:forEach var="tut" items="${tuitionList}">
		<tr>
			<td>${tut.sit_Subjct}</td>
			<td><fmt:formatNumber value="${tut.tu_Tut}"/> 원</td>
			<td>${fn:substring(tut.tu_Dt,0,10)} ~ ${fn:substring(tut.tu_Dt_L,0,10)}</td>
			<td>${tut.tu_Pay_Dt}</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="6">${paging}</td>
	</tr>
	</table>
	<form name="searchForm">
		<input type="text" name="key"/>
		<input type="text" name="value"/>
		<input type="button" value="검색" onclick="searchKey(this.form)" class="def-btn btn-sm btn-color"/>
	</form>
</body>
</html>
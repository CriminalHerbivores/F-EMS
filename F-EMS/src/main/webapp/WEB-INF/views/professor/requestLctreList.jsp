<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>

<h2>개설 강의</h2><br/>
<table class="def-table-full tb-border table-hover">
	<tr>
		<sec:authorize access="hasAnyRole('ROLE_STF,ROLE_ADMIN')">
		<th>교수번호</th>
		</sec:authorize>
		<th>개설년도</th>
		<th>학기</th>
		<th>강의명</th>
		<th>개설여부</th>
	</tr>
	<!-- 로그인한 교수가 개설요청한 강의목록 가져오기 -->
	<c:forEach items="${lctre_SearchVO}" var="lctre">
	<tr>
		<sec:authorize access="hasAnyRole('ROLE_STF,ROLE_ADMIN')">
		<td>${lctre.pr_Profsr_No}</td>
		</sec:authorize>
		<td><fmt:formatDate value="${lctre.lc_Lctrbgn_Dt }"/></td><!-- 개설일 년도 가져와야 할거같음 -->
		<td>${lctre.lc_Term}</td>
		<td>${lctre.lu_Lctre_Nm}</td>
		<td>${lctre.lc_Open_At}</td>
	</tr>	
	</c:forEach>
	<tr>
		<sec:authorize access="hasAnyRole('ROLE_STF,ROLE_ADMIN')">
		<td colspan="5">${paging}</td>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_PRO')">
		<td colspan="4">${paging}</td>
		</sec:authorize>
	</tr>
</table>
	
	<sec:authorize access="hasAnyRole('ROLE_STF,ROLE_ADMIN')">
	<form name="searchForm">
	<table class="def-table-full"><tr><td style="text-align: right;">
	<input type="text" placeholder="교수번호" name="pr_Profsr_No" class="def-input-text-lg custom-form-control"/>
	<input type="submit" value="검색" class="def-btn btn-search btn-color"/>
	</td></tr></table>
	</form>
	</sec:authorize>

</body>
</html>

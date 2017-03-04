<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>

<h2>${title}</h2><br/>
	<sec:authorize access="hasAnyRole('ROLE_STF,ROLE_ADMIN')">
	<form name="searchForm">
	<table class="def-table-full"><tr><td style="text-align: left;">
	<input type="text" placeholder="교수번호" name="pr_Profsr_No" class="def-input-text-lg custom-form-control"/>
	<input type="submit" value="검색" class="def-btn btn-search btn-color"/>
	</td></tr></table>
	</form>
	</sec:authorize>
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>강의코드</th>
		<th>강의명</th>
		<sec:authorize access="hasAnyRole('ROLE_STF,ROLE_ADMIN')">
		<th>교수번호</th>
		</sec:authorize>
		<th>개설학기</th>
		<th>개설여부</th>
	</tr>
	<!-- 로그인한 교수가 개설요청한 강의목록 가져오기 -->
	<c:forEach items="${lctre_SearchVO}" var="lctre">
	<tr>
		<td>${lctre.lc_Lctre_Code} - ${lctre.lc_Split}</td>
		<td><a href="updateLctre?lc_Lctre_Code=${lc_Lctre_Code}&lc_Profsr_No=${lc_Profsr_No}">${lctre.lu_Lctre_Nm}</a></td>
		<sec:authorize access="hasAnyRole('ROLE_STF,ROLE_ADMIN')">
		<td>${lctre.pr_Profsr_No}</td>
		</sec:authorize>
		<td>${fn:substring(lctre.lc_Lctrbgn_Dt,0,4)} - ${lctre.lc_Term}</td><!-- 개설일 년도 가져와야 할거같음 -->
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

<table class="def-table-full"><tr><td style="text-align: right;">
	${button}
</td></tr></table>

</body>
</html>

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
<meta charset="UTF-8">
<title></title>
</head>
<body>

<h2>강의 조회</h2><br/>
	<sec:authorize access="hasAnyRole('ROLE_STF,ROLE_ADMIN')">
	<form name="searchForm">
	<table class="def-table-full"><tr><td style="text-align: left;">
	<input type="text" placeholder="교수번호" id="Profsr_No" name="pr_Profsr_No" class="def-input-text-lg custom-form-control"/>
	<input type="submit" value="검색" class="def-btn btn-search btn-color"/>
	</td>
	<td style="text-align: right;">
	<!-- <input type="button" value="Excel출력" onclick="profsrExcel(LctreExcel);" class="def-btn btn-search btn-color"/> -->
	<a href="LctreExcel"><input type="button" value="Excel출력" class="def-btn btn-search btn-color"/></a>
	</td>
	</tr></table>
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
	<c:forEach items="${lctre_SearchVO}" var="lctre">
	<tr>
		<td>${lctre.lc_Lctre_Code} - ${lctre.lc_Split}</td>
		<td><a href="detailLctre?lc_Lctre_No=${lctre.lc_Lctre_No}">${lctre.lu_Lctre_Nm}</a></td>
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
	<a href="profsrRequestLectre"><input type="button" value="개설강의" class="def-btn btn-sm btn-color"></a>
</td></tr></table>

</body>
</html>

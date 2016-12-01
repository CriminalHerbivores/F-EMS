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

<h2>진행 강의</h2><br/>
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>개설년도</th>
		<th>학기</th>
		<th>강의명</th>
		<th>성적관리</th>
	</tr>
	<!-- 로그인한 교수가 개설요청한 강의목록 가져오기 -->
	<c:forEach items="${lctre_SearchVO}" var="lctre">
	<tr>
		<td><fmt:formatDate value="${lctre.lc_Lctrbgn_Dt }"/></td><!-- 개설일 년도 가져와야 할거같음 -->
		<td>${lctre.lc_Term}</td>
		<td>${lctre.lu_Lctre_Nm}</td>
		<td><a href="<%=request.getContextPath() %>/profsr/manageLctre?gd_Lctre_No=${lctre.lc_Lctre_No}&tpage=${tpage}">성적관리</a></td>
	</tr>	
	</c:forEach>
	<tr>
		<td colspan="4">${paging}</td>
	</tr>
	
	<sec:authorize access="hasRole('ROLE_STF')">
	<form name="searchForm">
	<input type="text" placeholder="교수번호" name="pr_Profsr_No" class="def-input-text-lg custom-form-control"/>
	<input type="submit" value="검색" class="def-btn btn-search btn-color"/>
	</form>
	</sec:authorize>
	
</table>

</body>
</html>

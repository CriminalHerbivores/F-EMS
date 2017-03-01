<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
* <pre>
* 
* </pre>
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 3. 1.      JAR      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h2>성적 조회</h2>
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>강의번호</th>
		<th>강의명</th>
		<th>교수명</th>
		<th>학기</th>
		<th>성적</th>
	</tr>
	<c:forEach items="${gradeList}" var="gr">
	<tr>
		<td>${gr.lu_Lctre_Code}-${gr.lc_Split}</td>
		<td>${gr.lu_Lctre_Nm}</td>
		<td>${gr.pr_Nm}</td>
		<td>${gr.lc_Year} - ${gr.lc_Term} 학기</td>
		<td>
			${gr.gd_Al} (${gr.gd_Grade})
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
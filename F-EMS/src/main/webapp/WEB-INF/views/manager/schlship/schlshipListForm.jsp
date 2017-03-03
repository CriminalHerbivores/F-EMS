<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spting" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
* [[개정이력(Modification Information)]]
* 수정일      수정자      수정내용
* ----------  ---------  -----------------
* 2017.01.24.    KJS      최초작성
* 2017.02.15.    JAR      추가작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
		<h2>장학금 관리</h2><br/>
<form name="search">
<table class="def-table-full"><tr><td style="text-align: left;">
<input type="text"  name="key" class="def-input-text-lg custom-form-control" placeholder="장학금명">&nbsp;&nbsp;
<input type="button" class="def-btn btn-sm btn-color" value="조회">&nbsp;&nbsp;
</td></tr></table>
</form>
		<table class="def-table-full tb-border table-hover">
			<tr>
				<th>장학금 명</th>
				<th>유형</th>
				<th>금액</th>
				<th>내용</th>
				<th>다운로드</th>
				<th>사용유무</th>
				<th>수정</th>
			</tr>
			<c:forEach var="schlship" items="${schlshipList }">
				<tr>
					<td>${schlship.ss_Schlship_Nm}</td>
					<td>${schlship.ss_Schlship_Type}</td>
					<td>${schlship.ss_Amount}</td>
					<td>${schlship.ss_Papers_Content}</td>
					<td><a href="<%=request.getContextPath() %>/download/file/list?filename=${schlship.ss_File}">${schlship.ss_File}</a></td>
					<td>${schlship.ss_useyn}</td>
					<td>
					<a href="updateSchlship?ss_Schlship_Code=${schlship.ss_Schlship_Code}&tpage=${tpage}"> <input type="button" value="수정" class="def-btn btn-sm btn-color"> </a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7" style="text-align: center;">${paging}</td>
			</tr>
		</table>
<table class="def-table-full"><tr><td style="text-align: right;">
<input type="button" class="def-btn btn-sm btn-color" value="등록하기" onclick="writeschlshipForm()">
<a href="<%=request.getContextPath()%>/sklstf/requestschlship"><input type="button" value="장학금 신청 내역" class="def-btn btn-sm btn-color"></a>
</td></tr></table>
</body>
</html>
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
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
		<h2>교수 관리</h2><br>
<table class="def-table-full"><tr><td style="text-align: left;">
<select name="선택" class="combobox-md custom-form-control">
	<option value="pr_Profsr_No">교수 번호</option>
	<option value="sit_Subjct">학과</option>
	<option value="pr_Nm">이름</option>
	<option value="pr_Ihidnum">생년월일</option>
</select>&nbsp;&nbsp;
<input type="text"  name="key" class="def-input-text-lg custom-form-control">&nbsp;&nbsp;
<input type="button" onclick="searchMe(this.form)" class="def-btn btn-sm btn-color" value="조회">
</td></tr></table>
		<table class="def-table-full tb-border table-hover">
			<tr>
				<th>교수 번호</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>학과</th>
				<th>이메일</th>
			</tr>
			<c:forEach var="profsr" items="${profsrList }">
				<tr>
					<td>${profsr.pr_Profsr_No}</td>
					<td><a href="profsrDetail?pr_Profsr_No=${profsr.pr_Profsr_No}&tpage=${tpage}">${profsr.pr_Nm}</a></td>
					<td>${profsr.pr_Moblphon_No}</td>
					<td></td>
					<td>${profsr.pr_Email}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" style="text-align: center;">${paging }</td>
			</tr>
		</table>
		<form name="searchForm">
		<table class="def-table-full"><tr><td style="text-align: right;">
			<a href="<%=request.getContextPath()%>/sklstf/profsrInsert"><input type="button" class="def-btn btn-sm btn-color" value="등록"></a>
		</td></tr></table>
		</form>
</body>
</html>

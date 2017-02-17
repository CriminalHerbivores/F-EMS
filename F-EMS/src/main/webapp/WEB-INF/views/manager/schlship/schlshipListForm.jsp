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
	<div class="container">
<table class="non-border margin-auto">
	<tr><td>
	<div class="text-center">
		<h2>장학금 관리</h2>
		<form name="formm">
		<table class="text-right">
		<tr>
			<td>
				장학금 명 : <input type="text"  name="key" class="def-input-text-sm">&nbsp;&nbsp;
					<input type="button" class="def-btn" value="조회">&nbsp;&nbsp;
			</td>
		</tr>
		</table>
		</form>
		</div>
		<table class="def-table-full tb-border table-hover">
			<tr>
				<th>장학금 코드</th>
				<th>장학금 명</th>
				<th>유형</th>
				<th>금액</th>
				<th>다운로드</th>
				<th>수정/삭제</th>
			</tr>
			<c:forEach var="schlship" items="${schlshipList }">
				<tr>
					<td>${schlship.ss_Schlship_Code}</td>
					<td>${schlship.ss_Schlship_Nm}</td>
					<td>${schlship.ss_Schlship_Type}</td>
					<td>${schlship.ss_Amount}</td>
					<td><a href="fileDownload1?name=${schlship.ss_Papers_Content}">${schlship.ss_Papers_Content}</a></td>
					<td>수정/삭제</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6" style="text-align: center;">${paging }</td>
			</tr>
		</table>
		<div id="buttons" style="float:right">
	  	<input type="button" class="def-btn" value="등록하기" onclick="writeschlshipForm()">
	  </div>
	</td></tr></table>
	</div>
</body>
</html>

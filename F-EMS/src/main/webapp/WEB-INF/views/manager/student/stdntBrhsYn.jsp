<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
* <pre>
* 직원의 기숙사 승인
* </pre>
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 2. 15.      JAR      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h2>기숙사 관리</h2>
	<table class="non-border margin-auto"><tr><td>
	<form name="formm" method="post">
	<table class="def-table-full tb-border table-hover">
	<tr>
		<th>학생번호</th>
		<th>이름</th>
		<th>주소</th>
		<th>우편번호</th>
		<th>연락처</th>
		<th>상태</th>
	</tr>
	<c:forEach items="${stdntList}" var="std" varStatus="status">
	<tr>
		<td>${std.st_Stdnt_No}
			<input type="hidden" name="st_Stdnt_No" value="${std.st_Stdnt_No}">
		</td>
		<td>${std.st_Nm}</td>
		<td>${std.st_Adres1}&nbsp;${std.st_Adres2}</td>
		<td>${std.st_Post_No}</td>
		<td>${std.st_Moblphon_No}</td>
		<td>
			<c:choose>
				<c:when test="${std.st_Brhs_At=='신청'}">
					<select name="st_Brhs_At">
						<option value="신청" selected>신청</option>
						<option value="승인">승인</option>
						<option value="거부">거부</option>
					</select>
				</c:when>
				<c:when test="${std.st_Brhs_At=='거부'}">
					<select name="st_Brhs_At">
						<option value="신청">신청</option>
						<option value="승인">승인</option>
						<option value="거부" selected>거부</option>
					</select>
				</c:when>
				<c:when test="${std.st_Brhs_At=='승인'}">
				<select name="st_Brhs_At">
						<option value="신청">신청</option>
						<option value="승인" selected>승인</option>
						<option value="거부">거부</option>
					</select>
				</c:when>
			</c:choose>
		</td>
	</tr>
	</c:forEach>
	<tr>
	<td colspan="6">${paging}</td>
	</tr>
	</table>
	<input type="submit" class="def-btn btn-sm btn-color" value="등록">
	</form>
	</td></tr></table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<meta charset="utf-8">
</head>
<body>

	<div class="container">
		<h2>학적 관리</h2>
		<table class="table table-bordered">
			<tr>
				<th>No</th>
				<th>학적 유형</th>
				<th>신청날짜</th>
			</tr>

			<c:forEach var="sknrgs" items="${sknrgsList}">
				<tr>
					<td>${sknrgs.count}</td>
					<td>${sknrgs.skn_Type}</td>
					<td><fmt:formatDate value="${notice.nb_Writng_Dt}" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4" style="text-align: center;">${paging }</td>
			</tr>
		</table>
		<div id="buttons" style="float: right">
			<input type="button" class="def-btn" value="등록하기"
				onclick="writeNoticeForm();">
		</div>
	</div>

</body>
</html>

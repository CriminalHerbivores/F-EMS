<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spting" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="container">
		<h2>학생 조회</h2>
		<tr>
			<form name="frm">
				장학금 명 : <input type="text"  name="key" class="def-input-text-sm">&nbsp;&nbsp;
					<input type="button" class="def-btn" value="조회">&nbsp;&nbsp;
				</td>
			</form>
		</tr>
		<table class="table table-bordered">
			<tr>
				<th>장학금 코드</th>
				<th>장학금 명</th>
				<th>유형</th>
				<th>금액</th>
				<th>다운로드</th>
			</tr>

			<c:forEach var="schlship" items="${schlshipList }">
				<tr>
					<td>${schlship.ss_Schlship_Code}</td>
					<td><a href="stdntDetail?ss_Schlship_Code=${schlship.ss_Schlship_Code}&tpage=${tpage}">
							${schlship.ss_Schlship_Type} </a></td>
					<td>${schlship.ss_Amount}</td>
					<td>${schlship.ss_Amount}</td>
					<td>${schlship.ss_Papers_Content}</td>

				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" style="text-align: center;">${paging }</td>
			</tr>

		</table>
	</div>
</body>
</html>

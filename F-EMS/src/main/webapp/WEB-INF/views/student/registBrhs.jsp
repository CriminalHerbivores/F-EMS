<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	기숙사 신청
	<table>
		<tr>
			<th>이름 (학번)</th>
			<td>${sdnt.st_Nm} (${sdnt.st_Stdnt_No})<input type="hidden" name="st_Stdnt_"></td>
			<th>학과</th>
			<td>${sdnt.st_Subject}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${sdnt.st_Moblphon_No}</td>
			<th>이메일</th>
			<td>${sdnt.st_Email}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td colspan="3">${sdnt.st_Adres1} ${sdnt.st_Adres2} ${sdnt.st_Post_No}</td>
		</tr>
		<tr>
			<th>기숙사 신청여부</th>
			<td>
				<c:choose>
					<c:when test="${not empty sdnt.st_Brhs_At}">
						${sdnt.st_Brhs_At}
					</c:when>
					<c:otherwise>
						<input type="button" value="신청하기" onclick="registBrhs(this.form)">
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
</body>
</html>

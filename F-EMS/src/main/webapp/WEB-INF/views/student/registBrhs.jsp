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
	<form name="formm" method="post">
	<table class="def-table tb-border">
		<tr>
			<td>이름 (학번)</td>
			<td>${stdntVO.st_Nm} (${stdntVO.st_Stdnt_No})<input type="hidden" name="st_Stdnt_No" value="${stdntVO.st_Stdnt_No}"></td>
			<td>학과</td>
			<td>${stdntVO.st_Subjct_Code}</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${stdntVO.st_Moblphon_No}</td>
			<td>이메일</td>
			<td>${stdntVO.st_Email}</td>
		</tr>
		<tr>
			<td>주소</td>
			<td colspan="3">${stdntVO.st_Adres1} ${stdntVO.st_Adres2} ${stdntVO.st_Post_No}</td>
		</tr>
		<tr>
			<td>기숙사 신청여부</td>
			<td colspan="3">
				<c:choose>
					<c:when test="${not empty stdntVO.st_Brhs_At}">
						${stdntVO.st_Brhs_At}
					</c:when>
					<c:otherwise>
						<input type="button" value="신청하기" onclick="registBrhs(this.form)">
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>

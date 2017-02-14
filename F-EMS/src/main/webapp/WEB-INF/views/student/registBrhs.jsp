<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
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
	<h3>기숙사 신청</h3>
	<form name="formm" method="post">
		<table class="def-table-full tb-border table-hover">
			<tr>
				<th style="width: 200px;">이름 (학번)</th>
				<td>${stdntVO.st_Nm}(${stdntVO.st_Stdnt_No})<input
					type="hidden" name="st_Stdnt_No" value="${stdntVO.st_Stdnt_No}"></td>
				<th style="width: 200px;">학과</th>
				<td>${stdntVO.st_Subjct_Code}</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${stdntVO.st_Moblphon_No}</td>
				<th>이메일</th>
				<td>${stdntVO.st_Email}</td>
			</tr>
			<tr>
				<th>주소</th>
				<td colspan="3">${stdntVO.st_Adres1}&nbsp;${stdntVO.st_Adres2}&nbsp;(${stdntVO.st_Post_No})</td>
			</tr>
			<tr>
				<th>기숙사 신청여부</th>
				<td colspan="3"><c:choose>
						<c:when test="${not empty stdntVO.st_Brhs_At}">
					      ${stdntVO.st_Brhs_At}
					    </c:when>
						<c:otherwise>
							<input type="button" class="def-btn btn-sm btn-color" value="신청하기" onclick="registBrhs(this.form)">
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form>
</body>
</html>
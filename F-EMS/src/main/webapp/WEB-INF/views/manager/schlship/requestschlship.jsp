<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
* <pre>
* 
* </pre>
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 2. 28.      JAR      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h2>장학금 신청 내역</h2><br/>
<form name="formm" method="post">
	<table class="def-table-full tb-border table-hover">
		<tr>
			<th>장학금 명</th>
			<th>학생번호</th>
			<th>유형</th>
			<th>금액</th>
			<th>내용</th>
			<th>신청학기</th>
			<th>신청일자</th>
			<th>상태</th>
		</tr>
		<c:forEach var="schlship" items="${stdntSchlshipList}">
		<tr>
			<td>${schlship.py_Stdnt_No}</td>
			<td>${schlship.ss_Schlship_Nm}</td>
			<td>${schlship.ss_Schlship_Type}</td>
			<td>${schlship.ss_Amount}</td>
			<td>${schlship.ss_Papers_Content}</td>
			<td>${schlship.py_Crrspnd_Year}-${schlship.py_Semstr}</td>
			<td>
				<fmt:formatDate value="${schlship.py_Schlship_Dt}" />
			</td>
			<td>
			<input type="hidden" name="py_Schlship_Brkdn_No" value="${schlship.py_Schlship_Brkdn_No}">
			<c:choose>
				<c:when test="${schlship.py_Useyn=='n'}">
					<select name="py_Useyn" class="combobox-md custom-form-control">
						<option value="n" selected>거절</option>
						<option value="y">승인</option>
					</select>
				</c:when>
				<c:when test="${schlship.py_Useyn=='y'}">
					<select name="py_Useyn" class="combobox-md custom-form-control">
						<option value="n">거절</option>
						<option value="y" selected>승인</option>
					</select>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="8">${paging}</td>
		</tr>
	</table>
<table class="def-table-full"><tr><td style="text-align: right;">
	<button onclick="submitForm(this.form)" class="def-btn btn-sm btn-color">등록</button>
	<a href="<%=request.getContextPath() %>/sklstf/schlshipList"><input type="button" value="장학금 관리" class="def-btn btn-sm btn-color"></a>
</td></tr></table>
</form>
</body>
</html>
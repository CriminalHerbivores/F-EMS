<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
* <pre>
* 
* </pre>
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 2. 22.      JAR      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<table class="non-border margin-auto"><tr><td>
	<h2>등록금 납부 내역 조회</h2><br/>
	<table class="def-table-full tb-border table-hover">
	<tr>
		<th>단과</th>
		<th>학부</th>
		<th>학과</th>
		<th>학생번호</th>
		<th>등록금</th>
		<th>납부기간</th>
		<th>납부날짜</th>
		<th>관리</th>
	</tr>
	<c:forEach var="tut" items="${tuitionList}">
		<tr>
			<td>${tut.coleg_Nm}</td>
			<td>${tut.fc_Faculty_Nm}</td>
			<td>${tut.sit_Subjct}</td>
			<td>${tut.tu_Stdnt_No}</td>
			<td><fmt:formatNumber value="${tut.tu_Tut}"/> 원</td>
			<td>${fn:substring(tut.tu_Dt,0,10)} ~ ${fn:substring(tut.tu_Dt_L,0,10)}</td>
			<td>
			<c:choose>
				<c:when test="${empty tut.tu_Pay_Dt}">
					미납
				</c:when>
				<c:otherwise>
					${fn:substring(tut.tu_Pay_Dt,0,10)}
				</c:otherwise>
			</c:choose>
			</td>
			<td>
			<c:choose>
				<c:when test="${empty tut.tu_Pay_Dt}">
					<a href="updateStdTuition?tu_No=${tut.tu_No}&tu_Pay_Dt=sysdate"><button class="def-ckbtn btn-sm ckbtn-color">확인</button></a>
				</c:when>
				<c:otherwise>
					<a href="updateStdTuition?tu_No=${tut.tu_No}&tu_Pay_Dt=null"><button class="def-ckbtn btn-sm btn-gray">취소</button></a>
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="8">${paging}</td>
	</tr>
	</table>
	<form name="searchForm">
	<table class="def-table-full"><tr><td style="text-align: right;">
		<!-- <input type="date" name="tu_Dt"> -->
		<select name="key" class="combobox-md custom-form-control">
			<option value="sit_Subjct">학과</option>
			<option value="tu_Stdnt_No">학생</option>
		</select>
		<input type="text" name="value" class="def-input-text-lg custom-form-control"/>
		<input type="submit" value="검색" class="def-btn btn-sm btn-color"/>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<a href="<%=request.getContextPath() %>/admin/toStdTuition?tpage=${tpage}"><input type="button" value="등록금 고지" class="def-btn btn-color"></a>
	<a href="<%=request.getContextPath() %>/admin/tuitionList"><input type="button" value="등록금 정보 조회" class="def-btn btn-color"></a>
	</sec:authorize>
	</td></tr></table>
	</form>
</td></tr></table>
</body>
</html>
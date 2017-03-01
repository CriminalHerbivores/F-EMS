<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<jsp:useBean id="now" class="java.util.Date" />
<%--
* [[개정이력(Modification Information)]]
* 수정일      수정자      수정내용
* ----------  ---------  -----------------
* 2017.01.24.    JAR      최초작성
* 2017.02.15.    JAR      추가작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<table class="non-border margin-auto"><tr><td>
	<h3>장학금</h3><br/>
	<h4>기준년도 학기</h4>
	<table class="def-table-full tb-border table-hover">
		<tr>
			<th width=150px>신청년도</th>
			<td><fmt:formatDate value="${now}" pattern="yyyy" /></td>
			<th width=150px>신청학기</th>
			<td>${hack}</td>
		</tr>
		<tr>
			<th>신청시 유의사항</th>
			<td colspan="3">
				해당 서류를 작성한 뒤 ${manageVO.mng_Univ_Nm} (${manageVO.mng_Adres1}&nbsp;${manageVO.mng_Adres2})&nbsp;를 방문하여 제출<br/>
				 또는 팩스번호 ${manageVO.mng_Fax_No}로 제출 후 신청하여 주십시오. 
			</td>
		</tr>
	</table>
	<br/>
	<h4>신청 가능 장학금</h4>
	<table class="def-table-full tb-border table-hover">
		<tr>
			<th>장학금 명</th>
			<th>유형</th>
			<th>금액</th>
			<th>내용</th>
			<th>다운로드</th>
			<th>신청</th>
		</tr>
		<c:forEach var="schlship" items="${schlshipList }">
		<tr>
			<td>${schlship.ss_Schlship_Nm}</td>
			<td>${schlship.ss_Schlship_Type}</td>
			<td>${schlship.ss_Amount}</td>
			<td>${schlship.ss_Papers_Content}</td>
			<td><a href="<%=request.getContextPath() %>/download/file/list?filename=${schlship.ss_File}">${schlship.ss_File}</a></td>
			<td>
				<c:choose>
					<c:when test="${schlship.ss_Schlship_Code eq 0}">
						신청완료
					</c:when>
					<c:otherwise>
						<a href="requestschlship?ss_Schlship_Code=${schlship.ss_Schlship_Code}&tpage=${tpage}"><input type="button" value="신청" class="def-ckbtn btn-sm ckbtn-color"></a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
	<h4>장학금 신청 내역</h4>
	<table class="def-table-full tb-border table-hover">
		<tr>
			<th>장학금 명</th>
			<th>유형</th>
			<th>금액</th>
			<th>내용</th>
			<th>신청학기</th>
			<th>신청일자</th>
			<th>상태</th>
		</tr>
		<c:forEach var="schlship" items="${stdntSchlshipList}">
		<tr>
			<td>${schlship.ss_Schlship_Nm}</td>
			<td>${schlship.ss_Schlship_Type}</td>
			<td>${schlship.ss_Amount}</td>
			<td>${schlship.ss_Papers_Content}</td>
			<td>${schlship.py_Crrspnd_Year}-${schlship.py_Semstr}</td>
			<td>
				<fmt:formatDate value="${schlship.py_Schlship_Dt}" />
			</td>
			<td>${schlship.py_Useyn}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="7">${paging}</td>
		</tr>
	</table>
	<br/><br/><br/>
</td></tr></table>
</body>
</html>

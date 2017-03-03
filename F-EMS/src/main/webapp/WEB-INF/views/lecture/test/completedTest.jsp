<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--
* <pre>
* 시험본 학생의 시험답안
* </pre>
* [[개정이력(Modification Information)]]
* 수정일       수정자      수정내용
* ----------  ---------  -----------------
* 2017. 3. 1.      SSH      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<table style="width:80%;" class="non-border margin-auto">
<tr><td>
	<table class="def-table-auto tb-border table-hover" id="testtable">
			<tr>
				<td colspan="4" style="padding-top: 0;padding-bottom: 0;">	
					<table class="def-table-auto tb-border table-hover"  style="width:100%;">
						<tr>
							<th style="width:9%;">시험명</th>
								<td style="width:60%;"> ${tpVO.tp_Nm } 	
								</td>
							<th style="width:9%;">응시자</th>
								<td>${stdNm}</td>
							<th>점수</th>
								<td>몇점</td>
						</tr>
					</table>
				</td>
				
			</tr>
	
			<tr>
				<th>No</th>
				<th style="width:80%;">문제</th>
				<th>응시자 답안</th>
				<th>채점</th>
			</tr>
		<c:forEach var="queList" items="${queList }" varStatus="status" >
				<tr>
					<td>${status.count }</td>
					<td>${queList.te_Ques }</td>
					<td>${answerList[status.index].an_Ans}</td>
				<c:choose>
  				  <c:when test="${queList.te_Ca =='${answerList[status.index].anAns' }">
						<td>O</td>
				  </c:when>
				  <c:otherwise>
						<td>X</td>
				  </c:otherwise>
				</c:choose>
				</tr>
		</c:forEach>
	</table>
</td></tr>
</table>
</body>
</html>
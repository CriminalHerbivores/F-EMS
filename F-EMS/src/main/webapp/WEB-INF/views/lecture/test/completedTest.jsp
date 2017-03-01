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
<table style="width:100%;" class="non-border margin-auto">
<tr><td>
	<table class="def-table-auto tb-border table-hover" id="testtable">
			<tr>
				<td style="padding-top: 0;padding-bottom: 0; width:700px; ">	
					<table class="def-table-auto tb-border table-hover"  style="width:100%;">
						<tr>
							<th>시험명</th>
								<td style="width:80%;"> ${tpVO.tp_Nm } 
								</td>
						</tr>
					</table>
				</td>
				<td>
				</td>
			</tr>
	
			<tr>
				<th style="width:80%;">문제</th>
				<th>정답</th>
			</tr>
		<c:forEach var="queList" items="${queList }" varStatus="status" >
				<tr>
					<td>${queList.te_Ques }</td>
					<td>${answerList[status.index].an_Ans}</td>
				</tr>
		</c:forEach>
	</table>
</td></tr>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
<table style="width:100%;" class="non-border margin-auto">
<tr><td>
  <form name="formm" method="post">
	<table class="def-table-auto tb-border table-hover" id="testtable">
		<tr>
			<td style="padding-top: 0;padding-bottom: 0; width:700px; ">	
				<table class="def-table-auto tb-border table-hover"  style="width:100%;">
					<tr>
						<th>시험명</th>
							<td style="width:80%;"> ${tpNm } 
							<input type="hidden" name="an_Tp_No" value="${tpNo }">
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
		
		<c:forEach var="Qlist" items="${Qlist }" >
		<tr>
			<td>
				${Qlist.te_Ques}
				<input type="hidden" name="queNo" value="${Qlist.te_Ques_No }">
			</td>
			<td>
			<sec:authorize access="hasRole('ROLE_PRO')">
				${Qlist.te_Ca }
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_STD')">	
				<input type="text" class="def-input-text-md custom-form-control" name="answer">
			</sec:authorize>
				<%-- ${Qlist.te_Ca} --%>			
			</td>
		</tr>
		</c:forEach>
			<tbody></tbody>
		
		
	</table>
		<sec:authorize access="hasRole('ROLE_STD')">
			<input style="float:right;" type="button" class="def-btn btn-md btn-color" value="제출" onclick="submitForm(this.form);">
		</sec:authorize>
		
		
		<sec:authorize access="hasRole('ROLE_PRO')">
		<div style="float:right;">
			<a href=""><input type="button" class="def-btn btn-md btn-color" value="수정"></a>
			<a href="deleteTest?tpNo=${tpNo }"><input type="button" class="def-btn btn-md btn-color" value="삭제"></a>
			<input type="button" class="def-btn btn-md btn-color" value="목록" onclick="history.back()">
		</div>
		</sec:authorize>
	</form>
</td></tr>
</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
			<td style="padding-top: 0;padding-bottom: 0">	
				<table class="def-table-auto tb-border table-hover"  style="width:100%;">
					<tr>
						<th>시험명</th>
						<td style="width:80%;"> ${tpNm } </td>
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
			</td>
			<td>
				<input type="text" class="def-input-text-md custom-form-control" name="ca">
				<%-- ${Qlist.te_Ca} --%>			
			</td>
		</tr>
		</c:forEach>
			<tbody></tbody>
		
		
	</table>
		<input style="float:right;" type="button" class="def-btn btn-md btn-color" value="등록" onclick="submitForm(this.form);">
	</form>
</td></tr>
</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<script type="text/javascript">

</script>

<body>
<div class="container">
		<h2>학생 조회</h2>
		<tr>
			<form name="frm">
				<td colspan="5" class="text-right"><select name="선택"
					class="combobox-sm">
						<option value="st_Stdnt_No">학적 조회</option>
						<option value="st_Subjct_Code">전과 신청 관이</option>
						<option value="st_Nm">복수 전공 관리</option>
						<option value="st_Ihidnum">조기 졸업 관리</option>
						<option value="st_Ihidnum">졸업 연기 관리</option>
						<option value="st_Ihidnum">제적 여부 관리</option>
						<option value="st_Ihidnum">퇴학 여부 관리</option>
						<option value="st_Ihidnum">졸업 여부 관리</option>
				</select>&nbsp;&nbsp; <input type="text"  name="key" class="def-input-text-sm">&nbsp;&nbsp;
					<input type="button" class="def-btn" value="조회">&nbsp;&nbsp;
				</td>
			</form>
		</tr>
		<table class="table table-bordered">
			<tr>
				<th>학번</th>
				<th>학과</th>
				<th>이름</th>
				<th>학적 변동</th>
				<th>가능</th>
				<th>불가</th>
			</tr>

			<c:forEach var="stdnt" items="${stdntList }">
				<tr>
					<td>${stdnt.st_Stdnt_No}</td>
					<td><a href="stdntDetail?st_Stdnt_No=${stdnt.st_Stdnt_No}&tpage=${tpage}">
							${stdnt.st_Nm} </a></td>
					<td>${stdnt.st_Moblphon_No}</td>
					<td>${stdnt.st_Subjct_Code}</td>
					<td>${stdnt.st_Email}</td>

				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" style="text-align: center;">${paging }</td>
			</tr>

		</table>
	</div>
</body>
</html>
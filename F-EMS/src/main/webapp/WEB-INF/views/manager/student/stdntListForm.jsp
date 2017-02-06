<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spting" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/stdnt.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../js/notice_bbs.js"></script>
</head>
<body>
	<div class="container">
		<h2>학생 조회</h2>
		<tr>
			<form name="frm">
				<td colspan="5" class="text-right"><select name="선택"
					class="combobox-sm">
						<option value="st_Stdnt_No">학생 번호</option>
						<option value="st_Subjct_Code">학과</option>
						<option value="st_Nm">이름</option>
						<option value="st_Ihidnum">생년월일</option>
				</select>&nbsp;&nbsp; <input type="text"  name="key" class="def-input-text-sm">&nbsp;&nbsp;
					<input type="button" class="def-btn" value="조회">&nbsp;&nbsp;
				</td>
			</form>
		</tr>
		<table class="table table-bordered">
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>학과</th>
				<th>이메일</th>
			</tr>

			<c:forEach var="stdnt" items="${stdntList }">
				<tr>
					<td>${stdnt.st_Stdnt_No}</td>
<<<<<<< HEAD
					<td><a href="stdntDetail?no=&tpage=${tpage}">
=======
					<td><a href="stdntDetail?st_Stdnt_No=${stdnt.st_Stdnt_No}&tpage=${tpage}">
>>>>>>> refs/heads/kjs
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

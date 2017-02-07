<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<script type="text/javascript">
	
</script>

<body>
	<form name="frm" method="POST">
		<div class="container">
			<h2>학족 관리</h2>
			<table class="table table-bordered">
				<tr>

					<td colspan="6" class="text-right"><select name="skn_Type"
						class="combobox-sm">
							<option value="학적 조회">학적 조회</option>
							<option value="전과 신청 관이">전과 신청 관이</option>
							<option value="복수 전공 관리">복수 전공 관리</option>
							<option value="조기 졸업 관리">조기 졸업 관리</option>
							<option value="졸업 연기 관리">졸업 연기 관리</option>
							<option value="제적 여부 관리">제적 여부 관리</option>
							<option value="퇴학 여부 관리">퇴학 여부 관리</option>
							<option value="졸업 여부 관리">졸업 여부 관리</option>
					</select>&nbsp;&nbsp; <input type="text" name="key"
						class="def-input-text-sm">&nbsp;&nbsp; <input
						type="button" class="def-btn" value="조회">&nbsp;&nbsp;</td>
				</tr>

				<tr>
					<th>학번</th>
					<th>학과</th>
					<th>이름</th>
					<th>신청 사유</th>
					<th>학적 변동</th>
					<th>승인여부</th>
				</tr>

				<c:forEach var="sknrgs" items="${sknrgsDtoList }">
					<tr>
						<td>${sknrgs.st_Stdnt_No}</td>
						<td>${sknrgs.sit_Subjct}</td>
						<td>${sknrgs.st_Nm}</td>
						<td>${sknrgs.skn_Content}</td>
						<td>${sknrgs.skn_Type}</td>
						<td><input type="text" hidden name="skn_No"
							value="${sknrgs.skn_No}"> <input class="checkbox"
							type="checkbox" name="skn_Useyn" value="y">가능<input class="checkbox" type="checkbox"
							name="skn_Useyn" value="n">불가능</td>
						<td></td>

					</tr>
				</c:forEach>
				<%-- <tr>
					<td colspan="6" style="text-align: center;">${paging }</td>
				</tr> --%>

			</table>
		</div>
		<button type="submit" class="btn btn-default">등록</button>
		<button type="button" class="btn btn-default" onclick="go_home()">취소</button>
	</form>

</body>
</html>
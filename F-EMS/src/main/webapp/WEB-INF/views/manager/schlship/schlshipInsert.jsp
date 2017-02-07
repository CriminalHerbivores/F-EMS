<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form method="POST" enctype="multipart/form-data" name="frm">
		<table class="table table-bordered">
			<tr>
				<td>장학금 명 :</td>
				<td><input type="text" name="ss_Schlship_Nm"></td>
			</tr>
			<tr>
				<td>유형 :</td>
				<td><input type="text" name="ss_Schlship_Type"></td>
			</tr>
			<tr>
				<td>금액 :</td>
				<td><input type="text" name="ss_Amount"></td>
			</tr>
			<tr>
				<td>첨부파일 :</td>
				<td><input type="file" name="f"></td>
			</tr>
		</table>
		<button type="submit" class="btn btn-default">등록</button>
		<button type="button" class="btn btn-default" onclick="go_home()">취소</button>
	</form>
</body>
</html>
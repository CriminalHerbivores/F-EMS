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
				<td><input type="text" name=""></td>
			</tr>
			<tr>
				<td>유형 :</td>
				<td><input type="text" name=""></td>
			</tr>
			<tr>
				<td>금액 :</td>
				<td><input type="text" name></td>
			</tr>
			<tr>
				<td>첨부파일 :</td>
				<td><input type="file" name="f"></td>
			</tr>
		</table>
	</form>
</body>
</html>
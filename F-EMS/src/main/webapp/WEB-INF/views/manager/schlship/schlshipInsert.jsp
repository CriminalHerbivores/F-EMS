<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%--
* [[개정이력(Modification Information)]]
* 수정일      수정자      수정내용
* ----------  ---------  -----------------
* 2017.01.24.    KJS      최초작성
* 2017.02.15.    JAR      추가작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

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
				<td><input type="text" name="ss_Schlship_Nm" value="${schlshipVO.ss_Schlship_Nm }"></td>
			</tr>
			<tr>
				<td>유형 :</td>
				<td><input type="text" name="ss_Schlship_Type" value="${schlshipVO.ss_Schlship_Type }"></td>
			</tr>
			<tr>
				<td>금액 :</td>
				<td><input type="text" name="ss_Amount" value="${schlshipVO.ss_Amount }"></td>
			</tr>
			<tr>
				<td>첨부파일 :</td>
				<td><input type="file" name="f" value=""></td>
			</tr>
		</table>
		<button type="submit" class="btn btn-default">등록</button>
		<button type="button" class="btn btn-default" onclick="go_home()">취소</button>
	</form>
</body>
</html>
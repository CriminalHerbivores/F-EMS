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
<h2>등록금 정보 등록</h2>
	<form name="formm" method="post" enctype="multipart/form-data">
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
				<td><input type="number" name="ss_Amount"></td>
			</tr>
			<tr>
				<td>내용 :</td>
				<td>
				<%-- <input type="text" name="ss_Papers_Content" value="${schlshipVO.ss_Papers_Content}"> --%>
<textarea name="ss_Papers_Content">신청기간 : 
내용 : 
</textarea>
				</td>
			</tr>
			<tr>
				<td>첨부파일 :</td>
				<td><input type="file" name="uploadfile"></td>
			</tr>
		</table>
		<button type="button" class="btn btn-default" onclick="submitForm(this.form)">등록</button>
		<button type="button" class="btn btn-default" onclick="history.go(-1)">취소</button>
	</form>
</body>
</html>
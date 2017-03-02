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
<h2>장학금 정보 등록</h2><br/>
	<form name="formm" method="post" enctype="multipart/form-data">
		<table class="def-table-full tb-border table-hover">
			<tr>
				<th>장학금 명</th>
				<td><input type="text" class="def-input-text-full custom-form-control" name="ss_Schlship_Nm"></td>
			</tr>
			<tr>
				<th>유형</th>
				<td><input type="text" class="def-input-text-full custom-form-control" name="ss_Schlship_Type"></td>
			</tr>
			<tr>
				<th>금액</th>
				<td><input type="number" class="def-input-text-full custom-form-control" name="ss_Amount"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
				<%-- <input type="text" name="ss_Papers_Content" value="${schlshipVO.ss_Papers_Content}"> --%>
<textarea name="ss_Papers_Content" class="def-input-text-full custom-form-control">신청기간 
내용 : 
</textarea>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="uploadfile"></td>
			</tr>
		</table>
		<table class="def-table-full"><tr><td style="text-align: right;">
		<button type="button" class="def-btn btn-sm btn-color" onclick="submitForm(this.form)">등록</button>
		<button type="button" class="def-btn btn-sm btn-color" onclick="history.go(-1)">취소</button>
		</td></tr></table>
		
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.23    KJS            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h2> 강의 자료 게시판 </h2><br/>
<form name="formm" method="post" enctype="multipart/form-data">
<input type="hidden" name="table_Nm" value="${table_Nm}">
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>제목</th>
		<td><input type="text" name="ld_Sj" class="def-input-text-full custom-form-control"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="8" cols="65" name="ld_Cn" class="def-input-text-full custom-form-control"></textarea></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td>
			    <input type="file" name="uploadfile">
		</td>
	</tr>
</table>  
<table class="def-table-full"><tr><td style="text-align: right;">
			<input type="button"  value="등록" class="def-btn btn-md btn-color" onclick="submitForm(this.form);" > 
			<input type="button"  value="목록"  class="def-btn btn-md btn-color"  onclick="submitForm(this.form);">	
</td></tr></table>
</form>
		
</body>
</html>
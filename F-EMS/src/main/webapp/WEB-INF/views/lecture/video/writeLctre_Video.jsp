<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.24    KJS            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
  
  $(function() {
    $("#lv_Start_Dt, #lv_End_Dt").datepicker();
  });
  
</script>
</head>
<body>
<h2> 강의 동영상 게시판 </h2><br/>
<form name="formm" method="post" enctype="multipart/form-data">

<input type="hidden" name="table_Nm" value="${table_Nm}">
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>제목</th>
		<td colspan="3"><input type="text" name="lv_Sj" class="def-input-text-full custom-form-control"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><textarea rows="8" cols="64" name="lv_Cn" class="def-input-text-full custom-form-control"></textarea></td>
	</tr>
	<tr>
		<th>시작   날짜</th>
		<td><input type="text" id="lv_Start_Dt" name="lv_Start_Dt" class="def-input-text-full custom-form-control"></td>
		<th>마지막 날짜</th>
		<td><input type="text" id="lv_End_Dt" name="lv_End_Dt" class="def-input-text-full custom-form-control"></td>
	</tr>
	<tr>
		<th>시청   길이</th>
		<td><input type="text" name="lv_Time" placeholder="분 단위" class="def-input-text-full custom-form-control"></td>
		<th>업로드</th>
		<td><input type="file" name="uploadfile"></td>
	</tr>
</table>
<table class="def-table-full"><tr><td style="text-align: right;">
	<input type="button"  value="등록" class="def-btn btn-md btn-color" onclick="submitForm(this.form);" > 
	<input type="button"  value="목록"  class="def-btn btn-md btn-color"  onclick="history.go(-1);">	
</td></tr></table>
  
</form>

</body>
</html>
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

	    <h2> 강의 동영상 게시판 </h2>
		<form name="formm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="table_Nm" value="${table_Nm}">
			<fieldset>	
			    <label>제목</label>
			    <input type="text" name="lv_Sj"  size="64" ><br>
				<label>내용</label>
			    <textarea rows="8" cols="64" name="lv_Cn"></textarea><br>
			    <label>시작   날짜</label>
			    <input type="text" id="lv_Start_Dt" name="lv_Start_Dt" class="def-input-text-md custom-form-control">
			    <label>마지막 날짜</label>
			    <input type="text" id="lv_End_Dt" name="lv_End_Dt" class="def-input-text-md custom-form-control">
			    <label>시청   길이</label>
			    <input type="text" name="lv_Time" class="def-input-text-md custom-form-control"><br>
			    <input type="file" name="uploadfile">
			</fieldset>   
		<div class="clear"></div>
		 <div id="buttons" style="float:right">
			<input type="button"  value="등록" class="def-btn btn-md btn-color" onclick="submitForm(this.form);" > 
			<input type="button"  value="목록"  class="def-btn btn-md btn-color"  onclick="submitForm(this.form);">	
		  </div>
		  
		</form>
		
</body>
</html>
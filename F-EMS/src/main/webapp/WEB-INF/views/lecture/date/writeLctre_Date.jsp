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

	    <h2>강의 자료 등록</h2>
		<form name="formm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="table_Nm" value="${table_Nm}">
			<fieldset>	
			    <label>제목</label>
			    <input type="text" name="ld_Sj"  size="64" ><br>
				<label>내용</label>
			    <textarea rows="8" cols="65" name="ld_Cn"></textarea><br>
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
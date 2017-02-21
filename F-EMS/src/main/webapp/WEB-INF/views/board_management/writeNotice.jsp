<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.01    송선호            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>
$(document).on('click','#insertNotice',function(){
var title = $('#title').val();
var content = $('#content').val();
	if(Trim(title)=="" || title==null){
		alert("제목을 입력해 주세요");
		return;
	}
	if(Trim(content)=="" || content ==null){
		alert("내용을 입력해 주세요");
		return;
	}
}
</script>
</head>
<body>

	    <h2> 공지 게시판 </h2>
		<form name="formm" method="post" enctype="multipart/form-data">
			<fieldset>	
			    <label>제목</label>
			    <input type="text" id="title" name="nb_Sj"  size="64" ><br>
				<label>내용</label>
			    <textarea id="content" rows="8" cols="65" name="nb_Cn"></textarea><br>
			    <input type="file" name="uploadfile">
			</fieldset>   
		<div class="clear"></div>
		 <div id="buttons" style="float:right">
			<input type="button" value="등록" class="def-btn btn-md btn-color" onclick="submitNotice(this.form);" > 
			<input type="button"  value="목록"  class="def-btn btn-md btn-color"  onclick="submitForm(this.form);">	
		  </div>
		  
		</form>
		
</body>
</html>
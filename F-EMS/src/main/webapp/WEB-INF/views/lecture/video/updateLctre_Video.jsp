<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	    <h2> 강의 과제 게시판 </h2>
		<form name="formm" method="post" enctype="multipart/form-data">
			<fieldset>	
				 <input type="hidden" name="tpage" value=${tpage }>
				 <input type="hidden" name="table_Nm" value=${lctre_Video_Gnt.table_Nm }>
				 <input type="hidden" name="lt_Flpth_No" value=${lctre_Video_Gnt.lv_Flpth_No }>
				 <input type="hidden" name="lv_Bbs_No" value=${lctre_Video_Gnt.lv_Bbs_No }>
			    <label>제목</label>
			    <input type="text" name="lv_Sj" value="${lctre_Video_Gnt.lv_Sj }"  size="64" ><br>
				<label>내용</label>
			    <textarea rows="8" cols="65" name="lv_Cn">${lctre_Video_Gnt.lv_Cn }</textarea><br>
			    <label>시작   날짜</label>
			    <input type="text" id="lv_Start_Dt" name="lv_Start_Dt" class="def-input-text-md custom-form-control" value="${lctre_Video_Gnt.lv_Start_Dt }">
			    <label>마지막 날짜</label>
			    <input type="text" id="lv_End_Dt" name="lv_End_Dt" class="def-input-text-md custom-form-control"  value="${lctre_Video_Gnt.lv_End_Dt }">
			    <label>시청   길이</label>
			    <fmt:parseNumber var="i" integerOnly="true" 
                       type="number" value="${lctre_Video_Gnt.lv_Time/60}" />
			    <input type="text" name="lv_Time" class="def-input-text-md custom-form-control"  value=<c:out value="${i}" />><br>
			   <input type="file" name="uploadfile">
			</fieldset>   
		<div class="clear"></div>
			 <div id="buttons" style="float:right">
			 <input type="button" class="def-btn btn-md btn-color" value="수정" onclick="submitForm(this.form);">
			 <a href="videoList?tpage=${tpage}&table_Nm=${lctre_Video_Gnt.table_Nm }"> <input type="button" class="def-btn btn-md btn-color" value="목록"> </a>
		  </div>
		  
		</form>
</body>
</html>
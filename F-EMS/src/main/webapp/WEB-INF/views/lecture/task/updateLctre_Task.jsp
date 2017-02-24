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
</head>
<body>
	    <h2> 강의 과제 게시판 </h2>
		<form name="formm" method="post" enctype="multipart/form-data">
			<fieldset>	
				 <input type="hidden" name="tpage" value=${tpage }>
				 <input type="hidden" name="table_Nm" value=${lctre_Task_Gnt.table_Nm }>
				 <input type="hidden" name="lt_Flpth_No" value=${lctre_Task_Gnt.lt_Flpth_No }>
				 <input type="hidden" name="lt_Bbs_No" value=${lctre_Task_Gnt.lt_Bbs_No }>
				 <input type="hidden" name="lt_Stdnt_No" value=${lctre_Task_Gnt.lt_Stdnt_No }>
			    <label>제목</label>
			    <input type="text" name="lt_Sj" value="${lctre_Task_Gnt.lt_Sj }"  size="64" ><br>
				<label>내용</label>
			    <textarea rows="8" cols="65" name="lt_Cn">${lctre_Task_Gnt.lt_Cn }</textarea><br>
			   <input type="file" name="uploadfile">
			</fieldset>   
		<div class="clear"></div>
			 <div id="buttons" style="float:right">
			 <input type="button" class="def-btn btn-md btn-color" value="수정" onclick="submitForm(this.form);">
			 <a href="taskList?tpage=${tpage}&table_Nm=${lctre_Task_Gnt.table_Nm }"> <input type="button" class="def-btn btn-md btn-color" value="목록"> </a>
		  </div>
		  
		</form>
</body>
</html>
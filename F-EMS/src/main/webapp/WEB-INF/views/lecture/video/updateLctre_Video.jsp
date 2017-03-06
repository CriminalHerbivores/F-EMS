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
<h2> 강의 과제 게시판 </h2><br/>
<form name="formm" method="post" enctype="multipart/form-data">
<input type="hidden" name="tpage" value=${tpage }>
<input type="hidden" name="table_Nm" value=${lctre_Video_Gnt.table_Nm }>
<input type="hidden" name="lt_Flpth_No" value=${lctre_Video_Gnt.lv_Flpth_No }>
<input type="hidden" name="lv_Bbs_No" value=${lctre_Video_Gnt.lv_Bbs_No }>
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>제목</th>
		<td colspan="3"><input type="text" name="lv_Sj" value="${lctre_Video_Gnt.lv_Sj }" class="def-input-text-full custom-form-control"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><textarea rows="8" cols="65" name="lv_Cn" class="def-input-text-full custom-form-control">${lctre_Video_Gnt.lv_Cn }</textarea></td>
	</tr>
	<tr>
		<th>시작   날짜</th>
		<td><input type="text" id="lv_Start_Dt" name="lv_Start_Dt" value="${lctre_Video_Gnt.lv_Start_Dt }" class="def-input-text-full custom-form-control"></td>
		<th>마지막 날짜</th>
		<td><input type="text" id="lv_End_Dt" name="lv_End_Dt" value="${lctre_Video_Gnt.lv_End_Dt }" class="def-input-text-full custom-form-control"></td>
	</tr>
	<tr>
		<th>시청   길이</th>
		<td>
		<fmt:parseNumber var="i" integerOnly="true" type="number" value="${lctre_Video_Gnt.lv_Time/60}" />
		<input type="text" name="lv_Time" value=<c:out value="${i}" /> class="def-input-text-full custom-form-control">
		</td>
		<th>업로드</th>
		<td><input type="file" name="uploadfile"></td>
	</tr>
</table>  
<table class="def-table-full"><tr><td style="text-align: right;">
<input type="button" class="def-btn btn-md btn-color" value="수정" onclick="submitForm(this.form);">
<a href="videoList?tpage=${tpage}&table_Nm=${lctre_Video_Gnt.table_Nm }"> <input type="button" class="def-btn btn-md btn-color" value="목록"> </a>
</td></tr></table>
<br/><br/><br/>
</form>
</body>
</html>
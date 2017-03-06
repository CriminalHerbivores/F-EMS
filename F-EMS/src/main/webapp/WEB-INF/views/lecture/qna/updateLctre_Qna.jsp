<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.26    KJS            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h2> 강의 질의응답 게시판 </h2><br/>
<form name="formm" method="post" enctype="multipart/form-data">
	<input type="hidden" name="tpage" value=${tpage }>
	<input type="hidden" name="table_Nm" value=${lctre_Qna_Gnt.table_Nm }>
	<input type="hidden" name="lq_Bbs_No" value=${lctre_Qna_Gnt.lq_Bbs_No }>
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>제목</th>
		<td><input type="text" name="lq_Sj" value="${lctre_Qna_Gnt.lq_Sj }"  class="def-input-text-full custom-form-control"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="8" cols="65" name="lq_Cn" class="def-input-text-full custom-form-control">${lctre_Qna_Gnt.lq_Cn }</textarea></td>
	</tr>
</table>
<table class="def-table-full"><tr><td style="text-align: right;">
	<input type="button" class="def-btn btn-md btn-color" value="수정" onclick="submitForm(this.form);">
	<a href="qnaList?tpage=${tpage}&table_Nm=${lctre_Qna_Gnt.table_Nm }"> <input type="button" class="def-btn btn-md btn-color" value="목록"> </a>
</td></tr></table>
</form>
</body>
</html>
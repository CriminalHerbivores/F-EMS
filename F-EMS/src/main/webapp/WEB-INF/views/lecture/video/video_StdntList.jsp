<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.24    KJS            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html lang="en">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	function detailLctre_Video(lv_Bbs_No,table_Nm,lw_Stdnt_No){
	var url = "detailLctre_Video_Stdnt?lv_Bbs_No="+lv_Bbs_No+"&table_Nm="+table_Nm+"&lw_Stdnt_No="+lw_Stdnt_No;
	  window.open( url, "_blank_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=1000, height=1000, top=300, left=300, ");
}
	</script>
</head>
<body>

<div class="container">
<table class="non-border margin-auto">
<tr><td>
<div class="text-center">
  <h2>강의 동영상 게시판</h2>
 <hr />

<form name="formm">
<div class="text-right">
  <select name="key" class="combobox-md custom-form-control">
  	<option value="lv_Sj">제목</option>
  	<option value="lv_Cn">내용</option>
  </select>
  <input type="text" class="def-input-text-lg custom-form-control" name="value">
  <input type="button" class="def-btn btn-search btn-color" value="조회" onclick="submitForm(this.form);">
</div>
 </form>
 </div>
  <table class="def-table-auto tb-border table-hover">
      <tr>
        <th>No</th>
        <th style="width:400px;">제목</th>
        <th>기간</th>
        <th>시간(분)</th>
      </tr>
      
      <c:forEach var="lctre_Video" items="${lctre_VideoList }">
      <c:if test="${lctre_Video.lv_Start_Dt <= Date}">
      	<tr>
      		<td> ${lctre_Video.lv_Bbs_No}</td>
      		<td><a href="#" onclick="detailLctre_Video('${lctre_Video.lv_Bbs_No}','${lctre_Video_Gnt.table_Nm}','${lctre_Video_Gnt.lw_Stdnt_No}');">
      		 ${lctre_Video.lv_Sj} </a>
      		</td>
      		<td><fmt:formatDate value="${lctre_Video.lv_Start_Dt}"/>
      		~
      		<fmt:formatDate value="${lctre_Video.lv_End_Dt}"/> </td>
      		<td>
      			<fmt:parseNumber var="i" integerOnly="true" 
                       type="number" value="${lctre_Video.lw_Watch_Time/60}" />
				<c:out value="${i}" />:${lctre_Video.lw_Watch_Time%60}
				/
      			<fmt:parseNumber var="j" integerOnly="true" 
                       type="number" value="${lctre_Video.lv_Time/60}" />
				<c:out value="${j}" />:${lctre_Video.lv_Time%60}
			</td>
      	</tr>
      	
      	</c:if>
      </c:forEach>
      	<tr>
      		<td colspan="4" style="text-align: center;">${paging }</td>
      	</tr>
      	</table>
</td>
</tr>
</table>
</div>
</body>
</html>

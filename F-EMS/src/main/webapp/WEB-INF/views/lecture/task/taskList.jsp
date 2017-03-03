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
  <script src="<%=request.getContextPath()%>/resources/js/bbs_gnt.js"></script>
</head>
<body>
  <h2>강의 과제 게시판</h2><br/>

<form name="formm">
<table class="def-table-full"><tr><td style="text-align: left;">
<input type="hidden" name="table_Nm" value=${lctre_Task_Gnt.table_Nm }>
  <select name="key" class="combobox-md custom-form-control">
  	<option value="lt_Sj">제목</option>
  	<option value="lt_Cn">내용</option>
  </select>
  <input type="text" class="def-input-text-lg custom-form-control" name="value">
  <input type="button" class="def-btn btn-search btn-color" value="조회" onclick="submitForm(this.form);">
</td></tr></table>
 </form>
  <table class="def-table-full tb-border table-hover">
      <tr>
        <th>No</th>
        <th style="width:500px;">제목</th>
        <th>작성날짜</th>
        <th>작성자</th>
      </tr>
      
      <c:forEach var="lctre_Task" items="${lctre_TaskList }">
      	<tr>
      		<td> ${lctre_Task.lt_Bbs_No}</td>
      		<td><a href="detailLctre_Task?lt_Bbs_No=${lctre_Task.lt_Bbs_No}&table_Nm=${lctre_Task_Gnt.table_Nm}&tpage=${tpage}">
      		 ${lctre_Task.lt_Sj} </a>
      		</td>
      		<td><fmt:formatDate value="${lctre_Task.lt_Writng_Dt}" /> </td>
      		<td> ${lctre_Task.lt_Stdnt_No}</td> <!-- 조회수 -->
      		
      	</tr>
      </c:forEach>
      	<tr>
      		<td colspan="4" style="text-align: center;">${paging }</td>
      	</tr>
  </table>
  <sec:authorize access="hasRole('ROLE_STD')">
	  <table class="def-table-full"><tr><td style="text-align: right;">
	  	<a href="writeLctre_Task?table_Nm=${lctre_Task_Gnt.table_Nm}">
	  	<input type="button" class="def-btn btn-md btn-color" value="등록"></a>
	  </td></tr></table>
	  </sec:authorize>
</body>
</html>

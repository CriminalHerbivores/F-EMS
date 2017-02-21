<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.01    송선호            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html lang="en">
<head>
  <title>직원-공지게시판</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">
<table class="non-border margin-auto">
<tr><td>
<div class="text-center">
  <h2>공지 게시판</h2>
 <hr />

<form name="formm">
<div class="text-right">
  <select name="key" class="combobox-md custom-form-control">
  	<option value="nb_Sj">제목</option>
  	<option value="nb_Cn">내용</option>
  </select>
  <input type="text" class="def-input-text-lg custom-form-control" name="value">
  <input type="button" class="def-btn btn-search btn-color" value="조회" onclick="submitForm(this.form);">
</div>
 </form>
 </div>
  <table class="def-table-auto tb-border table-hover">
      <tr>
        <th>No</th>
        <th style="width:500px;">제목</th>
        <th>작성날짜</th>
        <th>조회수</th>
      </tr>
      
      <c:forEach var="notice" items="${noticeList }">
      	<tr>
      		<td> ${notice.nb_Bbs_No}</td>
      		<td><a href="detailNotice?no=${notice.nb_Bbs_No}&tpage=${tpage}">
      		 ${notice.nb_Sj} </a>
      		</td>
      		<td><fmt:formatDate value="${notice.nb_Writng_Dt}" /> </td>
      		<td> ${notice.nb_Rdcnt}</td> <!-- 조회수 -->
      		
      	</tr>
      </c:forEach>
      	<tr>
      		<td colspan="4" style="text-align: center;">${paging }</td>
      	</tr>
      	
     
  </table>
  <sec:authorize access="hasRole('ROLE_STF')">
	  <div id="buttons" style="float:right">
	  	<input type="button" class="def-btn btn-md btn-color" value="등록" onclick="writeNoticeForm();">
	  </div>
</sec:authorize>
</td></tr>  
</table>	  
</div>
 
</body>
</html>

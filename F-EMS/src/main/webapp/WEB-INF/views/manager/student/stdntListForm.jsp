<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spting" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/stdnt.js"></script>
</head>
<body>
<div class="container">
  <h2>학생 조회</h2>
  <table class="table table-bordered">
      <tr>
        <th>학번</th>
        <th>이름</th>
        <th>전화번호</th>
        <th>학과</th>
        <th>이메일</th>
      </tr>
      
      <c:forEach var="stdnt" items="${stdntList }">
      	<tr>
      		<td> ${notice.nb_Bbs_No}</td>
      		<td> ${notice.nb_Sj}</td>
      		<td>${notice.nb_Writng_Dt} </td>
      		<td> ${notice.nb_Bbs_No}</td> 
      		
      	</tr>
      </c:forEach>
      	<tr>
      		<td colspan="4" style="text-align: center;">${paging }</td>
      	</tr>
      	
     
     
     
  </table>
	  <div id="buttons" style="float:left">
	  	
	  	<input type="button" value="등록하기" onclick="writeNotice();">
	  </div>
</div>
</body>
</html>
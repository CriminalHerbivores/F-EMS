<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="../js/notice_bbs.js"></script>
</head>
<body>

<div class="container">
  <h2>공지 게시판</h2>
  <table class="table table-bordered">
      <tr>
        <th>No</th>
        <th>제목</th>
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
      		<td> ${notice.nb_Bbs_No}</td> <!-- 조회수 -->
      		
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

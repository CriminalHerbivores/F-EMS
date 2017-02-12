<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
  <h2>과제 게시판</h2>
 <hr />
<form name="forrm">
  <select name="key">
  	<option value="nb_Sj">제목</option>
  	<option value="nb_Cn">내용</option>
  </select>
  <input type="text" name="value">
  <input type="button" class="def-btn" value="검색" onclick="searchBBS();">
 </form>
  <table class="def-table-auto tb-border table-hover">
      <tr>
        <th>No</th>
        <th style="width:500px;">제목</th>
        <th>작성날짜</th>
        <th>작성자</th>
        <th>조회수</th>
      </tr>
      
      	<tr>
      		<td> 5</td>
      		<td>구구단 과제 제출</td>
      		<td>2017-02-12 </td>
      		<td>강감찬</td>
      		<td> 10</td> <!-- 조회수 -->
      		
      	</tr>
      	
      		<tr>
      		<td> 4</td>
      		<td>게시판 만들기 입니다.	</td>
      		<td>2017-02-12 </td>
      		<td>박불휘</td>
      		<td> 8</td> <!-- 조회수 -->
      		
      	</tr>
      		<tr>
      		<td> 3</td>
      		<td>get방식과 post방식의 차이점</td>
      		<td>2017-02-10 </td>
      		<td>이순신</td>
      		<td> 18</td> <!-- 조회수 -->
      		
      	</tr>
      		<tr>
      		<td> 2</td>
      		<td>ibatis framework 조사</td>
      		<td>2017-02-09 </td>
      		<td>홍길동</td>
      		<td> 38</td> <!-- 조회수 -->
      		
      	</tr>
      		<tr>
      		<td> 1</td>
      		<td>김대덕 자기소개서 제출입니다.</td>
      		<td>2017-02-06 </td>
      		<td>김대덕</td>
      		<td> 20</td> <!-- 조회수 -->
      		
      	</tr>
      	
      	
      	<tr>
      		<td colspan="5" style="text-align: center;">${paging }</td>
      	</tr>
      	
     
     
     
  </table>
	  <div id="buttons" style="float:right">
	  	<input type="button" class="def-btn" value="등록하기" onclick="writeNoticeForm();">
	  </div>
</div>
 
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
* <pre>
* 
* </pre>
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 3. 1.      JAR      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	$(function(){
		$("input[name='start']").each(function(i){
			var day = $(this).val().substring(0,10);
			var time = $(this).val().substring(11,17)+"00";
			var count = i+1;
			$("#"+count+">td>#st1").val(day);
			$("#"+count+">td>#st2").val(time);
		});
		
		$("input[name='end']").each(function(i){
			var day = $(this).val().substring(0,10);
			var time = $(this).val().substring(11,17)+"00";
			var count = i+1;
			$("#"+count+">td>#en1").val(day);
			$("#"+count+">td>#en2").val(time);
		});
	})
</script>
</head>
<body>
<h2>일정 관리</h2><br/>
<form name="formm" method="post">
<table class="def-table-full tb-border table-hover">
	<tr>
		<th width="100">일정명</th>
		<th>시작일</th>
		<th>종료일</th>
		<th>수정</th>
	</tr>
	<c:forEach items="${eventList}" var="evt" varStatus="status">
	<tr id="${status.count}">
		<td><input type="hidden" name="evt_Code" value="${evt.evt_Code}">${evt.evt_Nm}</td>
		<td>
			<input type="hidden" name="start" id="start" value="${evt.evt_Start}" class="def-input-text-lg custom-form-control">
			<input type="date" name="st1" id="st1" class="def-input-text-lg custom-form-control">
			<input type="time" name="st2" id="st2" class="def-input-text-lg custom-form-control">
		</td>
		<td>
			<input type="hidden" name="end" id="end" value="${evt.evt_End}" class="def-input-text-lg custom-form-control">
			<input type="date" name="en1" id="en1" class="def-input-text-lg custom-form-control">
			<input type="time" name="en2" id="en2" class="def-input-text-lg custom-form-control">
		</td>
		<td><input type="button" value="수정" onclick="manageEvent(${status.count})" class="def-ckbtn btn-sm ckbtn-color"></td>
	</tr>
	</c:forEach>
</table>
</form>
</body>
</html>

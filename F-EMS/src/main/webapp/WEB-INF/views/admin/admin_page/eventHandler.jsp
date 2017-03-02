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
</head>
<body>
<h2>일정 관리</h2>
<form name="formm" method="post">
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>일정명</th>
		<th>시작일</th>
		<th>종료일</th>
		<th>수정</th>
	</tr>
	<c:forEach items="${eventList}" var="evt" varStatus="status">
	<tr id="${status.count}">
		<td><input type="hidden" name="evt_Code" value="${evt.evt_Code}">${evt.evt_Nm}</td>
		<td><input type="text" name="start" value="${evt.evt_Start}" class="def-input-text-lg custom-form-control"></td>
		<td><input type="text" name="end" value="${evt.evt_End}" class="def-input-text-lg custom-form-control"></td>
		<td><input type="button" value="수정" onclick="manageEvent(${status.count})" class="def-ckbtn btn-sm ckbtn-color"></td>
	</tr>
	</c:forEach>
</table>
</form>
</body>
</html>

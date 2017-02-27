<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 해당 학기에 수강신청 가능한 잔여학점과 이미 수강신청된 학점을 보여주는 JSP
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH        최초작성
 * 2017.02.15      KJH        추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
body{
	 /* background:#FFFFB3; */
}
</style>

</head>
<body class="course-list-r-top">
<form>
<div class="text-center"><table  class="def-table-full tb-border">
	<tr><th>신청 가능 학점
	</th></tr>
	<tr><td><h3>12</h3>
	</td></tr>
</table>
<br/>
<table  class="def-table-full tb-border">
	<tr><th>수강 신청 학점
	</th></tr>
	<tr><td><h3>${reqst.sumOfReqst }</h3>
	</td></tr>
</table>

</div>
</form>
</body>
</html>
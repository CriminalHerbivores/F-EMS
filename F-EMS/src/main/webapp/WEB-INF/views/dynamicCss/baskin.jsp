<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%
pageContext.setAttribute("manageVO", session.getAttribute("baskin"));
%>
<%--
* [[개정이력(Modification Information)]]
* 수정일      수정자      수정내용
* ----------  ---------  -----------------
* 2017.02.16.    JAR      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form method="post">
<input type="submit" class="def-btn btn-sm btn-color" value="원래대로">
<input type="hidden" name="bskn_Main" value="#063F78">
<input type="hidden" name="bskn_Sub1" value="#326EA6">
<input type="hidden" name="bskn_Sub2" value="#D8E7F6">
<span style="color:#063F78;">main #063F78</span>
<span style="color:#326EA6;">sub1 #326EA6</span>
<span style="color:#D8E7F6;">sub2 #D8E7F6</span>
</form>
<hr/>
<c:forEach var="bs" items="${baskin}">
<form method="post">
<input type="submit" class="def-btn btn-sm btn-color" value="${bs.bskn_Nm}">
<input type="hidden" name="bskn_Main" value="${bs.bskn_Main}">
<input type="hidden" name="bskn_Sub1" value="${bs.bskn_Sub1}">
<input type="hidden" name="bskn_Sub2" value="${bs.bskn_Sub2}">
<span style="color: ${bs.bskn_Main};">main ${bs.bskn_Main}</span>
<span style="color: ${bs.bskn_Sub1};">sub1 ${bs.bskn_Sub1}</span>
<span style="color: ${bs.bskn_Sub2};">sub2 ${bs.bskn_Sub2}</span>
</form>
<br/>
</c:forEach>
</body>
</html>
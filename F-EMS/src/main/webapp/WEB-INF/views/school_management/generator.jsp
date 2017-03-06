<%@page import="com.uni.fems.dto.Bbs_List_AtrtyVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spting" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<script type="text/javascript">
function delet() {
     document.frm.action = "<%=request.getContextPath()%>/bbs_list/insertTable";
     document.frm.submit();
 }
 function insert() {
     document.frm.action = "<%=request.getContextPath()%>/bbs_list/insertTable";
     document.frm.submit();
 }

</script>
</head>
<body>
<h2>커뮤니티 게시판 관리</h2><br/>
<form name="frm" method="get" action="<%=request.getContextPath()%>/bbs_list/insertTable">
<input type="hidden" name="ba_Manage" value="3">
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>게시판명</th> 
		<th>직원</th>
		<th>교수</th>
		<th>학생</th>
		<th>사용유무</th>
	</tr>
	<c:forEach items="${bbsListGen}" var="bbs">
	<tr>
		<td>${bbs.bl_Bbs_Nm}</td>
		<td>${bbs.ba_Sklstf}</td>
		<td>${bbs.ba_Profsr}</td>
		<td>${bbs.ba_Stdnt}</td>
		<td>${bl_Use_Ennc}</td>
	</tr>
	</c:forEach>
</table>
<br/>
<hr>
<br/>
<h2>학사 게시판 관리</h2><br/>
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>게시판명</th> 
		<th>직원</th>
		<th>교수</th>
		<th>학생</th>
		<th>사용유무</th>
	</tr>
	<c:forEach items="${noticeListGen}" var="bbs">
	<tr>
		<td>${bbs.bl_Bbs_Nm}</td>
		<td>${bbs.ba_Sklstf}</td>
		<td>${bbs.ba_Profsr}</td>
		<td>${bbs.ba_Stdnt}</td>
		<td>${bl_Use_Ennc}</td>
	</tr>
	</c:forEach>
</table>
<br/>
<hr>
<br/>
<table class="def-table-full tb-border table-hover"><tr><td>
<h4>사용자 권한 안내</h4>
0 : 접근 불가<br/>
1 : 읽기 가능<br/>
2 : 쓰기 가능<br/>
3 : 댓글 가능
</td></tr></table>
<br/><br/><br/>
</form>
</body>
</html>
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
<form name="frm" method="get" action="<%=request.getContextPath()%>/bbs_list/insertTable">
<input type="hidden" name="ba_Manage" value="3">
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
		<td>
		<a href="updateTable?bl_Bbs_No=${bbs.bl_Bbs_No}&ba_Alpha=b">${bbs.bl_Bbs_Nm}</a>
		</td>
		<td>
			<c:choose>
			<c:when test="${bbs.ba_Sklstf eq 3}">
			댓글 가능
			</c:when>
			<c:when test="${bbs.ba_Sklstf eq 2}">
			쓰기 가능
			</c:when>
			<c:when test="${bbs.ba_Sklstf eq 1}">
			읽기 가능
			</c:when>
			<c:when test="${bbs.ba_Sklstf eq 0}">
			이용 불가
			</c:when>
			<c:otherwise>
			처리 오류
			</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
			<c:when test="${bbs.ba_Profsr eq 3}">
			댓글 가능
			</c:when>
			<c:when test="${bbs.ba_Profsr eq 2}">
			쓰기 가능
			</c:when>
			<c:when test="${bbs.ba_Profsr eq 1}">
			읽기 가능
			</c:when>
			<c:when test="${bbs.ba_Profsr eq 0}">
			이용 불가
			</c:when>
			<c:otherwise>
			처리 오류
			</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
			<c:when test="${bbs.ba_Stdnt eq 3}">
			댓글 가능
			</c:when>
			<c:when test="${bbs.ba_Stdnt eq 2}">
			쓰기 가능
			</c:when>
			<c:when test="${bbs.ba_Stdnt eq 1}">
			읽기 가능
			</c:when>
			<c:when test="${bbs.ba_Stdnt eq 0}">
			이용 불가
			</c:when>
			<c:otherwise>
			처리 오류
			</c:otherwise>
			</c:choose>
		</td>
		<td>
		${bbs.bl_Use_Ennc}
		</td>
	</tr>
	</c:forEach>
</table>
<br/>
<hr>
<br/>
<h2>커뮤니티 게시판 관리</h2><br/>
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
		<td>
		<a href="updateTable?bl_Bbs_No=${bbs.bl_Bbs_No}&ba_Alpha=t">${bbs.bl_Bbs_Nm}</a>
		</td>
		<td>
			<c:choose>
			<c:when test="${bbs.ba_Sklstf eq 3}">
			댓글 가능
			</c:when>
			<c:when test="${bbs.ba_Sklstf eq 2}">
			쓰기 가능
			</c:when>
			<c:when test="${bbs.ba_Sklstf eq 1}">
			읽기 가능
			</c:when>
			<c:when test="${bbs.ba_Sklstf eq 0}">
			이용 불가
			</c:when>
			<c:otherwise>
			처리 오류
			</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
			<c:when test="${bbs.ba_Profsr eq 3}">
			댓글 가능
			</c:when>
			<c:when test="${bbs.ba_Profsr eq 2}">
			쓰기 가능
			</c:when>
			<c:when test="${bbs.ba_Profsr eq 1}">
			읽기 가능
			</c:when>
			<c:when test="${bbs.ba_Profsr eq 0}">
			이용 불가
			</c:when>
			<c:otherwise>
			처리 오류
			</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
			<c:when test="${bbs.ba_Stdnt eq 3}">
			댓글 가능
			</c:when>
			<c:when test="${bbs.ba_Stdnt eq 2}">
			쓰기 가능
			</c:when>
			<c:when test="${bbs.ba_Stdnt eq 1}">
			읽기 가능
			</c:when>
			<c:when test="${bbs.ba_Stdnt eq 0}">
			이용 불가
			</c:when>
			<c:otherwise>
			처리 오류
			</c:otherwise>
			</c:choose>
		</td>
		<td>
		${bbs.bl_Use_Ennc}
		</td>
	</tr>
	</c:forEach>
</table>
<br/>
<hr>
<br/>
<table class="def-table-full tb-border table-hover"><tr><td class="text-left">
<h4>게시판 생성 안내</h4>
학사 게시판의 경우 학사란에 만들어지며, 커뮤니티 게시판의 경우 커뮤니티란에 만들어집니다. <br/>
커뮤니티 게시판에 게시판이 하나도 생성되지 않을 시 보이지 않습니다.
<div class="float-right">
<a href="generator"><input type="button" class="def-btn btn-md btn-color"  value="추가"></a> 
</div>
</td></tr></table>
<br/><br/><br/>
</form>
</body>
</html>
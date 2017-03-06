<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
<%@page import="org.springframework.ui.Model"%>
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
<h2>게시판 생성</h2><br/>
<form name="formm" method="post">

<% 
Bbs_List_AtrtyVO bbs_List_AtrtyVO = new Bbs_List_AtrtyVO();
bbs_List_AtrtyVO = (Bbs_List_AtrtyVO) request.getAttribute("bbs_List_AtrtyVO"); 

String ba_Sklstf = bbs_List_AtrtyVO.getBa_Sklstf();
String ba_Profsr = bbs_List_AtrtyVO.getBa_Profsr();
String ba_Stdnt = bbs_List_AtrtyVO.getBa_Stdnt();
%>

<input type="hidden" name="ba_Manage" value="3">
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>게시판명</th> 
		<td colspan="2"><input type="text" name="bl_Bbs_Nm" value="${bbs_List_AtrtyVO.bl_Bbs_Nm}" class="def-input-text-full custom-form-control"></td>
	</tr>
	<tr>
		<th>직원</th>
		<th>교수</th>
		<th>학생</th>
	</tr>
 	<tr>
		<td>
		<select name="ba_Sklstf" class="combobox-md custom-form-control">
			<option value="3" <%=ba_Sklstf.equals("3") ? "selected" : "" %>>댓글가능</option>
			<option value="2" <%=ba_Sklstf.equals("2") ? "selected" : "" %>>쓰기가능</option>
			<option value="1" <%=ba_Sklstf.equals("1") ? "selected" : "" %>>읽기가능</option>
			<option value="0" <%=ba_Sklstf.equals("0") ? "selected" : "" %>>접근불가</option>
		</select>
		</td>
		<td>
		<select name="ba_Profsr" class="combobox-md custom-form-control">
			<option value="3" <%=ba_Profsr.equals("3") ? "selected" : "" %>>댓글가능</option>
			<option value="2" <%=ba_Profsr.equals("2") ? "selected" : "" %>>쓰기가능</option>
			<option value="1" <%=ba_Profsr.equals("1") ? "selected" : "" %>>읽기가능</option>
			<option value="0" <%=ba_Profsr.equals("0") ? "selected" : "" %>>접근불가</option>
		</select>
		</td>
		<td>
		<select name="ba_Stdnt" class="combobox-md custom-form-control">
			<option value="3" <%=ba_Stdnt.equals("3") ? "selected" : "" %>>댓글가능</option>
			<option value="2" <%=ba_Stdnt.equals("2") ? "selected" : "" %>>쓰기가능</option>
			<option value="1" <%=ba_Stdnt.equals("1") ? "selected" : "" %>>읽기가능</option>
			<option value="0" <%=ba_Stdnt.equals("0") ? "selected" : "" %>>접근불가</option>
		</select>
		</td>
	</tr>
	<tr>
		<th>게시판위치</th>
		<th>사용유무</th>
		<td rowspan="2">
		<input type="submit" value="수정" class="def-btn btn-md btn-color">
		<input type="button" value="목록" onclick="history.go(-1)" class="def-btn btn-md btn-color">
		</td>
	</tr>
	<tr>
		<td>
			<c:choose>
			<c:when test="${bbs_List_AtrtyVO.ba_Alpha=='t'}">
			<label><input type="radio" name="ba_Alpha" value="t" checked> 커뮤니티 </label> &nbsp;&nbsp; 
			<label><input type="radio" name="ba_Alpha" value="b"> 학사 </label>
			</c:when>
			<c:otherwise>
			<label><input type="radio" name="ba_Alpha" value="t" > 커뮤니티 </label> &nbsp;&nbsp; 
			<label><input type="radio" name="ba_Alpha" value="b" checked> 학사 </label>
			</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
			<c:when test="${bbs_List_AtrtyVO.bl_Use_Ennc=='y'}">
			<label><input type="radio" name="bl_Use_Ennc" value="y" checked> 사용 </label> &nbsp;&nbsp; 
			<label><input type="radio" name="bl_Use_Ennc" value="n"> 사용안함 </label>
			</c:when>
			<c:otherwise>
			<label><input type="radio" name="bl_Use_Ennc" value="y" > 사용 </label> &nbsp;&nbsp; 
			<label><input type="radio" name="bl_Use_Ennc" value="n" checked> 사용안함 </label>
			</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>
<br/>
</form>
</body>
</html>
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
<form name="formm" method="get" action="<%=request.getContextPath()%>/bbs_list/insertTable">
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
			<option value="3" >댓글가능</option>
			<option value="2" >쓰기가능</option>
			<option value="1" >읽기가능</option>
			<option value="0" >접근불가</option>
		</select>
		</td>
		<td>
		<select name="ba_Profsr" class="combobox-md custom-form-control">
			<option value="3" >댓글가능</option>
			<option value="2" >쓰기가능</option>
			<option value="1" >읽기가능</option>
			<option value="0" >접근불가</option>
		</select>
		</td>
		<td>
		<select name="ba_Stdnt" class="combobox-md custom-form-control">
			<option value="3" >댓글가능</option>
			<option value="2" >쓰기가능</option>
			<option value="1" >읽기가능</option>
			<option value="0" >접근불가</option>
		</select>
		</td>
	</tr>
	<tr>
		<th>게시판위치</th>
		<th>사용유무</th>
		<td rowspan="2">
		<input type="submit" value="추가" class="def-btn btn-md btn-color">
		<input type="button" value="목록" onclick="history.go(-1)" class="def-btn btn-md btn-color">
		</td>
	</tr>
	<tr>
		<td>
			<label><input type="radio" name="ba_Alpha" value="t" checked> 커뮤니티 </label> &nbsp;&nbsp; 
			<label><input type="radio" name="ba_Alpha" value="b"> 학사 </label>
		</td>
		<td>
			<label><input type="radio" name="bl_Use_Ennc" value="y" checked> 사용 </label> &nbsp;&nbsp; 
			<label><input type="radio" name="bl_Use_Ennc" value="n"> 사용안함 </label>
		</td>
	</tr>
</table>
<br/>
</form>
</body>
</html>
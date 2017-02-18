<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 학교내 건물을 등록하는 JSP
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH        최초작성
 * 2017.02.18      KJH        추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<script type="text/javascript">
/* go_save(){
var theForm = document.formm; */

/* 유효성 부분 아작스로 변경해야함 */
/* if (theForm.bd_No.value == '') {
	alert('건물번호 입력.');
	theForm.bd_No.focus();
} else if (theForm.bd_Nm.value == '') {
	alert('건물이름 입력.');
	theForm.bd_Nm.focus();
}

theForm.action = "/admin/buildingInsert";
theForm.submit(); */
	
/* } */
function go_building() {
	var bd_No = document.formm.bd_No.value;
	var bd_Nm = document.formm.bd_Nm.value;
	if(!bd_No=="" && !bd_Nm==""){
		document.formm.submit();
	}
}


</script>


<body>
<article>
<form method="post" name="formm">
<h1>건물 등록</h1>

	<table class="def-table tb-border">
		<tr><td>건물 번호</td><td><input type="text" class=".def-input-text-lg" name="bd_No"></td><td><input type="button" class="def-btn" value="중복 확인"></td><td>여기에 아작스로 사용가능여부</tr>
		<tr><td>건물 이름</td><td><input type="text" class=".def-input-text-lg" name="bd_Nm"></td><td><input type="button" class="def-btn" value="중복 확인"></td><td>여기에 아작스로 사용가능여부</tr>
	</table>

<br/>
<input type="button" class="def-btn" value="이전" onclick="history.go(-1);">&nbsp;&nbsp;<input type="submit" class="def-btn" value="등록" onclick="go_building()"> <!-- go_admin_page() -->


</form>
</article>
</body>
</html>

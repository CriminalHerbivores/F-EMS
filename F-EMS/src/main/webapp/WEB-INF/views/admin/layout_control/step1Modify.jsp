<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
 * <pre>
 * 이미 개설된 대학 웹페이지의 대학 정보를 수정하는 JSP
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

.navbar-inverse{
background-color:#fff;
border-color:#fff;
border:0;
}
</style>

</head>
<body>
<article>

<form id="step1Modify" action="/fems/admin/step2Modify" method="post" name="formm">
	
	<div class="set-layout">
	
	<!-- 상단 -->
	<nav class="navbar navbar-inverse">
  <!-- <div class="container-fluid"> -->
    <div class="navbar-header">
	
	<div class="set-layout-top">
	<img src="<%=request.getContextPath()%>/resources/images/step1.png">
	<h1>STEP1. 대학 정보 설정</h1>
	</div>
	</div>
	
	</nav>
	
	
	<div class="container-fluid text-center">    
  <div class="row content">
  
  
	<!-- 왼쪽 -->
    <div class="col-sm-2 sidenav">
	<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
	<input type="image" src="<%=request.getContextPath()%>/resources/images/left-arrow.png" alt="Submit" onclick="history.go(-1);">
	</div>
</div>	
	
	
	<!-- 중앙 -->
	<div class="col-sm-8 margin-auto"> 
		<div class="set-layout-center">
		<table class="def-table-full tb-border table-hover tr-child-color">
		<tr><th>대학 이름 : </th><td><input type="text" name="mng_Univ_Nm" class="def-input-text-lg custom-form-control"></td></tr>
		<tr><th>대학 영문 이름 : </th><td><input type="text" name="mng_Univ_Eng_Nm" class="def-input-text-lg custom-form-control"></td></tr>
		<tr><th>대학 로고 등록 : </th><td> ※ 첨부 파일 이미지 크기는 170*15px 권장 <input type="file" name="mng_Univ_Logo" ></td></tr> 
		<tr><th>우편번호 : </th><td><input type="text" name="mng_Post_No" class="def-input-text-md custom-form-control"><input type="button" class="def-btn" value="검색"></td></tr>
		<tr><th>주소 : </th><td><input type="text" name="mng_Adres1" class="def-input-text-lg custom-form-control"> <input type="text" name="mng_Adres2" class="def-input-text-xlg custom-form-control" ></td></tr>
		<tr><th>전화번호 : </th><td><select name="mng_Tlphon_No" class="combobox-sm custom-form-control">
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="032">032</option>
					<option value="033">033</option>
					<option value="041">041</option>
					<option value="042">042</option>
					<option value="043">043</option>
					<option value="051">051</option>
					<option value="052">052</option>
					<option value="053">053</option>
					<option value="054">054</option>
					<option value="055">055</option>
					<option value="061">061</option>
					<option value="062">062</option>
					<option value="063">063</option>
					<option value="064">064</option>
					<option value="010">010</option>
					<option value="012">012</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
				</select> 
				<input type="text" name="phoneNo1" class="def-input-text-sm custom-form-control">
				<input type="text" name="phoneNo2" class="def-input-text-sm custom-form-control"></td></tr> 
				<tr><th>저작권 : </th><td><input type="text" name="mng_Cpyr" class="def-input-text-full custom-form-control"></td></tr>
</table>
<a href="<%=request.getContextPath()%>/">메인으로 가기</a><br/>
			</div>
		</div>
<!-- 오른쪽 -->	
<div class="col-sm-2 sidenav">		
<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
	<input type="image" src="<%=request.getContextPath()%>/resources/images/right-arrow.png" alt="Submit" onclick="go_step2Modify()"><br>
	<input type="image" src="<%=request.getContextPath()%>/resources/images/left-arrow.png" alt="Submit" onclick="layoutPreview()">
	</div>
	</div>
</div>

</div>
<!-- 하단 -->



</div>
</form>
</article>

</body>
</html>
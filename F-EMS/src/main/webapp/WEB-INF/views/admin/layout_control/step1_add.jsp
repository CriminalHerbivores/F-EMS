<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<img scr="images/left-arrow.png">
	
	</div>
</div>	
	
	
	<!-- 중앙 -->
	<div class="col-sm-8 text-left"> 
		<div class="set-layout-center">
		<table class="tb-layout">
		<tr><td>대학 이름 : </td><td><input type="text" class=".def-input-text-lg"></td></tr>
		<tr><td>대학 영문 이름 : </td><td><input type="text" class=".def-input-text-lg"></td></tr>
		<tr><td>대학 로고 등록 : </td><td><input type="text" class=".def-input-text-lg"><input type="button" class="def-btn" value="찾기"></td></tr> 
		<tr><td colspan="2">※ 첨부 파일 이미지 크기는 170*15px 권장</td></tr>
		<tr><td colspan="2">
			<div class="preview-logo">
			
			</div></td></tr>
		<tr><td>우편번호 : </td><td><input type="text" class=".def-input-text-lg"><input type="button" class="def-btn" value="검색"></td></tr>
		<tr><td>주소 : </td><td><input type="text" class=".def-input-text-lg"></td></tr>
		<tr><td>전화번호 : </td><td><select name="선택" class="combobox-sm">
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
				<input type="text" class="def-input-text-sm">
				<input type="text" class="def-input-text-sm"></td></tr> 
				<tr><td>저작권 : </td><td><input type="text" class=".def-input-text-lg"></td></tr>
</table>
			</div>
		</div>
<!-- 오른쪽 -->	
<div class="col-sm-2 sidenav">		
<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
	<img scr="images/right-arrow.png">
	</div>
	</div>
</div>

</div>
<!-- 하단 -->



</div>

</body>
</html>
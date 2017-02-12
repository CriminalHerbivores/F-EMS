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
<article>

<form id="step1Add" action="/fems/admin/step2Add" method="post" name="formm">
	
	
	<!-- 상단 -->
  <div class="set-layout">
	<div class="set-layout-top">
	
	<img src="<%=request.getContextPath()%>/resources/images/step1.png"><br/>
	<h1>STEP1. 대학 정보 설정</h1>
	</div>
  
  
	<!-- 왼쪽 -->
    <div class="col-sm-2 sidenav">
	<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
	<input type="image" src="<%=request.getContextPath()%>/resources/images/left-arrow.png" alt="Submit" onclick="history.go(-1);">
	</div>
</div>	
	
	
	<!-- 중앙 -->
	<div class="col-sm-8 text-center"> 
		<div class="set-layout-center">
		<table class="tb-layout out-border">
		<tr><td>대학 이름 : </td><td><input type="text" class="def-input-text-lg custom-form-control"></td></tr>
		<tr><td>대학 영문 이름 : </td><td><input type="text" class="def-input-text-lg custom-form-control"></td></tr>
		<tr><td>대학 로고 등록 : </td><td><input type="text" class="def-input-text-lg custom-form-control"><input type="button" class="def-btn btn-sm btn-gray" value="찾기"></td></tr> 
		<tr><td></td><td>※ 첨부 파일 이미지 크기는 200*50px 권장</td></tr>
		<tr><td></td><td>
			<div class="preview-logo">
			
			</div></td></tr>
		<tr><td>우편번호 : </td><td><input type="text" class="def-input-text-md custom-form-control"><input type="button" class="def-btn btn-sm btn-gray" value="검색"></td></tr>
		<tr><td>주소 : </td><td><input type="text" class="def-input-text-lg custom-form-control"></td></tr>
		<tr><td>전화번호 : </td><td><select name="선택" class="combobox-sm custom-form-control">
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
				</select>&nbsp;-&nbsp;
				<input type="text" class="def-input-text-sm custom-form-control">&nbsp;-&nbsp;
				<input type="text" class="def-input-text-sm custom-form-control"></td></tr> 
				<tr><td>저작권 : </td><td><input type="text" class="def-input-text-lg custom-form-control"></td></tr>
</table>

			</div>
		</div>
<!-- 오른쪽 -->	
<div class="col-sm-2 sidenav">		
<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
	<input type="image" src="<%=request.getContextPath()%>/resources/images/right-arrow.png" alt="Submit" onclick="go_step2Add()">
	</div>
	</div>

<!-- 하단 -->

</div>

</form>
</article>
</body>
</html>
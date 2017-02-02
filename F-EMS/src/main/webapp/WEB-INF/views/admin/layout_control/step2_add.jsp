<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>
	
	<div class="set-layout">
	<div class="set-layout-top">
	<img scr="">
	<h1>STEP2. 메뉴 사용 설정</h1>
	</div>
	
	<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
	<img src="images/go_left">
	</div>
	
		<div class="set-layout-center">
			대학 이름 : <input type="text" class=".def-input-text-lg"><br /> 
			대학 영문 이름 : <input type="text" class=".def-input-text-lg"><br /> 
			대학 로고 등록 : <input type="text" class=".def-input-text-lg"><input type="button" class="def-btn" value="찾기"><br /> 
				※ 첨부 파일 이미지 크기는 170*15px 권장

			<div class="preview-logo">
				우편번호 : <input type="text" class=".def-input-text-lg"><input type="button" class="def-btn" value="검색"><br /> 
				주소 : <input type="text" class=".def-input-text-lg"><br /> 
				전화번호 : <select name="선택" class="combobox-sm">
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
				<input type="text" class="def-input-text-sm"><br /> 
				저작권 : <input type="text" class=".def-input-text-lg"><br />

			</div>
		</div>
			
<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
	</div>
	</div>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
<style type="text/css">
body {
 font-family: calibri;
}
input[type=radio], input[type=checkbox] {
		display:none;
	}

input[type=radio] + label, input[type=checkbox] + label {
		display:inline-block;
		margin:-2px;
		padding: 4px 12px;
		margin-bottom: 0;
		font-size: 14px;
		line-height: 20px;
		color: #333;
		text-align: center;
		text-shadow: 0 1px 1px rgba(255,255,255,0.75);
		vertical-align: middle;
		cursor: pointer;
		background-color: #f5f5f5;
		background-image: -moz-linear-gradient(top,#fff,#e6e6e6);
		background-image: -webkit-gradient(linear,0 0,0 100%,from(#fff),to(#e6e6e6));
		background-image: -webkit-linear-gradient(top,#fff,#e6e6e6);
		background-image: -o-linear-gradient(top,#fff,#e6e6e6);
		background-image: linear-gradient(to bottom,#fff,#e6e6e6);
		background-repeat: repeat-x;
		border: 1px solid #ccc;
		border-color: #e6e6e6 #e6e6e6 #bfbfbf;
		border-color: rgba(0,0,0,0.1) rgba(0,0,0,0.1) rgba(0,0,0,0.25);
		border-bottom-color: #b3b3b3;
		filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff',endColorstr='#ffe6e6e6',GradientType=0);
		filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
		-webkit-box-shadow: inset 0 1px 0 rgba(255,255,255,0.2),0 1px 2px rgba(0,0,0,0.05);
		-moz-box-shadow: inset 0 1px 0 rgba(255,255,255,0.2),0 1px 2px rgba(0,0,0,0.05);
		box-shadow: inset 0 1px 0 rgba(255,255,255,0.2),0 1px 2px rgba(0,0,0,0.05);
	}

	 input[type=radio]:checked + label, input[type=checkbox]:checked + label{
		   background-image: none;
		outline: 0;
		-webkit-box-shadow: inset 0 2px 4px rgba(0,0,0,0.15),0 1px 2px rgba(0,0,0,0.05);
		-moz-box-shadow: inset 0 2px 4px rgba(0,0,0,0.15),0 1px 2px rgba(0,0,0,0.05);
		box-shadow: inset 0 2px 4px rgba(0,0,0,0.15),0 1px 2px rgba(0,0,0,0.05);
			background-color:#e0e0e0;
	}
</style>


</head>
<body>
<table class="def-table-auto tb-border table-hover">
	<tr>
		<th>개설년도/학기</th>
		<td><input type="text" class="def-input-text-sm custom-form-control">년도
			<input type="text" class="def-input-text-sm custom-form-control">학기
		</td>
		<th>개설학과전공</th>
		<td><input type="text" class="def-input-text-md custom-form-control"></td>
	 </tr>
	 
	 <tr>
	 	<th>강의번호</th>
	 	<td><input type="text" class="def-input-text-md custom-form-control"></td>
	 	<th>분반번호</th>
	 	<td><input type="text" class="def-input-text-md custom-form-control"></td>
	 </tr>
	 
	 <tr>
	 	<th>교과목명</th>
	 	<td><input type="text" class="def-input-text-md custom-form-control"></td>
	 	<th>이수구분</th>
	 	<td>
	      <input type="radio" id="radio1" name="radios" value="" checked>
			<label for="radio1">전공</label>
    	  <input type="radio" id="radio2" name="radios"value="">
			<label for="radio2">교양</label>
    	  <input type="radio" id="radio3" name="radios" value="">
			<label for="radio3">선택</label>
		  <input type="radio" id="radio4" name="radios" value="">
			<label for="radio4">필수</label>
	 	</td>
	 </tr>
	 
	 <tr>
	 	<th>담당교수</th>
	 	<td><input type="text" class="def-input-text-md custom-form-control"></td>
	 	
	 	<th>강의정원</th>
	 	<td><input type="text" class="def-input-text-sm custom-form-control"></td>
	 </tr>
	 
	 <tr>
	 	<th>강의시간/강의실</th>
	 	<td><input type="text" class="def-input-text-md custom-form-control"> /
	 	<input type="text" class="def-input-text-md custom-form-control"></td>  
	 	
	 	
	 	<th>담당교수전화</th>
	 	<td><input type="text" class="def-input-text-sm custom-form-control">-
	 	<input type="text" class="def-input-text-sm custom-form-control">-
	 	<input type="text" class="def-input-text-sm custom-form-control">
	 	</td>
	 	
	 	
	 </tr>
	 
	  <tr>
	 	<th>교수 이메일 주소</th>
	 	<td><input type="text" class="def-input-text-lg custom-form-control"></td>
	 	
	 	<th>홈페이지</th>
	 	<td><input type="text" class="def-input-text-lg custom-form-control"></td>
	 </tr>
	 
	 <tr>
	 	<th>이수학점</th>
	 	<td><input type="text" class="def-input-text-sm custom-form-control">점</td>
	 	
	 	<th>선행과목</th>
	 	<td><input type="text" class="def-input-text-md custom-form-control"></td>
	 </tr>
	 
	 <tr>
	 	<th>학년</th>
	 	<td><input type="text" class="def-input-text-sm custom-form-control">학년</td>
	 	
	 	<th>강의평가</th>
	 	<td><input type="text" class="def-input-text-sm custom-form-control"></td>
	 </tr>
	 
	
	 
	 
</table>
<table class="def-table-auto tb-border table-hover">
	   <tr>
	      <th rowspan="2">학습평가방법(100%)</th>
	      <td>중간고사</td>
	      <td>기말고사</td>
	      <td>개인과제</td>
	      <td>팀별과제</td>
	      <td>발표</td>
	      <td>출석</td>
	      <td>태도</td>
	     </tr>
	     
	     <tr>
	     	<td><input type="text" class="def-input-text-sm custom-form-control"></td>
	     	<td><input type="text" class="def-input-text-sm custom-form-control"></td>
	     	<td><input type="text" class="def-input-text-sm custom-form-control"></td>
	     	<td><input type="text" class="def-input-text-sm custom-form-control"></td>
	     	<td><input type="text" class="def-input-text-sm custom-form-control"></td>
	     	<td><input type="text" class="def-input-text-sm custom-form-control"></td>
	     	<td><input type="text" class="def-input-text-sm custom-form-control"></td>
	     </tr>
	     
	     <tr>
	     	<th>강의 진행 형태</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"> </td>
	     </tr>
	     
	     <tr>
	     	<th>강의 목표</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"> </td>
	     </tr>
	     
	     <tr>
	     	<th>주교재</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"> </td>
	     </tr>
	     
	     <tr>
	     	<th>부교재</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"> </td>
	     </tr>
	     
	     <tr>
	     	<th colspan="8">강의 내용 및 학습 내용</th>
	     </tr>
	     
	     <tr>
	     	<th>1주차</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"></td>
	     </tr>
	     
	     <tr>
	     	<th>2주차</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"></td>
	     </tr>
	     
	     <tr>
	     	<th>3주차</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"></td>
	     </tr>
	     
	     <tr>
	     	<th>4주차</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"></td>
	     </tr>
	     
	     <tr>
	     	<th>5주차</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"></td>
	     </tr>
	     
	     <tr>
	     	<th>6주차</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"></td>
	     </tr>
	     
	     <tr>
	     	<th>7주차</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"></td>
	     </tr>
	     
	     <tr>
	     	<th>8주차</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"></td>
	     </tr>
	     
	     <tr>
	     	<th>9주차</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"></td>
	     </tr>
	     
	     <tr>
	     	<th>10주차</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"></td>
	     </tr>
	     
	     <tr>
	     	<th>11주차</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"></td>
	     </tr>
	     
	     <tr>
	     	<th>12주차</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"></td>
	     </tr>
	     
	     <tr>
	     	<th>13주차</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"></td>
	     </tr>
	     
	     <tr>
	     	<th>14주차</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"></td>
	     </tr>
	     
	     <tr>
	     	<th>15주차</th>
	     	<td colspan="7"><input type="text" class="def-input-text-lg custom-form-control"></td>
	     </tr>
	     
	     
	 </table>
</body>
</html>

















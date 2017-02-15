<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div style="position: inherit; background-color: #fff; height:1500px import!; z-index: 100;">
		<h1>작업 어느정도 함(버튼 색상 및 테이블 형태는 좀 더 손 볼 생각)</h1>	<input type="button" class="btn-lg btn-color" value="이전" onclick="history.go(-1);">
		※ 텍스트 크기는 13~15px를 기본으로 하고있음<br/><br/>
		
		<!-- 텍스트 입력창 -->
		<input type="text" class="def-input-text-sm custom-form-control" value=""><br /> 
		<input type="text" class="def-input-text-md custom-form-control" value=""><br />
		<input type="text" class="def-input-text-lg custom-form-control" value=""><br /> <br />
		
		<!-- 버튼 -->
		취소 버튼 외에는 컬러 입힐 예정임<br/>
		<input type="button" class="def-btn btn-sm btn-color" value="기본">&nbsp;&nbsp; 기본 작은 버튼<br />
		<input type="button" class="def-btn btn-md btn-color" value="등록">&nbsp;&nbsp; 수정, 등록 등 하단에 크게 들어가는 버튼<br />
		<input type="button" class="def-btn btn-md btn-gray" value="취소">&nbsp;&nbsp; 취소,이전 등 하단에 크게 들어가는 버튼<br />
		<input type="button" class="def-btn btn-lg btn-color" value="큰 버튼">&nbsp;&nbsp;특수한 경우의 큰 버튼, 로그인 등<br />
		<button class="def-btn btn-search btn-color" value="조회"><i class="glyphicon glyphicon-search"></i>&nbsp;조회</button>&nbsp;&nbsp;조회, 검색 등<br />
		<input type="button" class="def-ckbtn btn-sm ckbtn-color" value="체크">&nbsp;&nbsp;테이블 안에서 특수하게 사용할 버튼<br />
		
		
		
		<br />

		
		<!-- 콤보박스 -->
		<select name="선택" class="combobox-sm custom-form-control">
			<option value="">작음</option>
			<option value="">이건작은거임</option></select><br /> 
		<select name="선택" class="combobox-md custom-form-control">
			<option value="">중간</option>
			<option value="">이건중간거임</option></select><br /> 
		<select name="선택" class="combobox-lg custom-form-control">
			<option value="">큰거</option>
			<option value="">이건큰거임</option>
		</select><br /> <br />
		
		<!-- 테이블 : 자동 폭 조절 -->
		<div class="container">
			<table class="def-table-auto tb-border table-hover">
				<thead>
					<tr>
						<th>자동 폭 크기조절</th>
						<th>테이블</th>
						<th>입니다</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>이것</td>
						<td>저것</td>
						<td>요것</td>
					</tr>
					<tr>
						<td style="text-align: left;">왼쪽정렬은</td>
						<td>내부css로</td>
						<td>합시다</td>
					</tr>
					<tr>
						<td>테이블 폭도</td>
						<td>내부 CSS로</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		<br />

	</div>
	
	<!-- 테이블: 화면의 80% 폭 맞춤, 권장형 -->
	<div class="container">
			<table class="def-table-full tb-border table-hover">
				<thead>
					<tr>
						<th>꽉 찬 90% 폭</th>
						<th>테이블</th>
						<th>입니다</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="text-align: left;">강의명이나 게시글 등 왼쪽정렬</td>
						<td>저것</td>
						<td>요것</td>
					</tr>
					<tr>
						<td>이것</td>
						<td>저것</td>
						<td>요것</td>
					</tr>
					<tr>
						<td>이것</td>
						<td>저것</td>
						<td>요것</td>
					</tr>
				</tbody>
			</table>
		<br />

	</div>
<table><tr><td>
<select name="선택" class="combobox-md custom-form-control">
			<option value="">중간</option>
			<option value="">이건중간거임</option>
		</select>
		</td><td>
		<button class="def-btn btn-search btn-color" value="조회"><i class="glyphicon glyphicon-search"></i>&nbsp;조회</button>
		</td><td>
<input type="text" class="def-input-text-sm custom-form-control" value="">
</td></tr></table>
	
	<table class="non-border margin-auto">
	<tr><td>
	이 테이블은 각 페이지의 가장 겉에 둘러주면 맘에 들거임-공지게시판 참고
	</td></tr>
	</table>

	
</body>
</html>
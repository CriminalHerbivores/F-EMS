<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * F-EMS로 대학 웹페이지를 개설할 때 메뉴 사용 설정을 하는 JSP
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
</head>
<body>
<article>

<form id="step2Add" action="/fems/admin/step3Add" method="post" name="formm">

	
	<div class="set-layout">
	<div class="set-layout-top">
<img src="<%=request.getContextPath()%>/resources/images/step2.png"><br/>
	<h1>STEP2. 메뉴 사용 설정</h1>
	</div>
	
	<div class="col-sm-2 sidenav">
	<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
<input type="image" src="<%=request.getContextPath()%>/resources/images/left-arrow.png" alt="Submit" onclick="history.go(-1);">	</div>
	</div>
	
	<div class="col-sm-8 margin-auto"> 
		<div class="set-layout-center">
			<table class="tb-layout  out-border">
			<tr><td>
			왼쪽 메뉴 사용</td><td colspan="2"><label><input type="radio" name="sub-menu" value="use" checked="checked">사용</label>&nbsp;&nbsp;
						<label><input type="radio" name="sub-menu" value="unuse">사용 안함</label></td></tr>
			
			<tr><td>게시판 추가</td><td colspan="2"><input type="text" class="def-input-text-md custom-form-control">&nbsp;&nbsp;<input type="button" class="def-btn btn-sm btn-gray" value="추가"></td></tr>
			<tr><td></td><td colspan="2">
			<table class="def-table-auto tb-border" style="margin-left:0px !important">
				<tr><th>사용</th>
				<td></td>
				<th>미사용</th>
				<td></td>
				</tr>
				<tr><td>ㅇㅇ게시판</td>
				<td rowspan="3">▷<br>◁</td>
				<td>ㅇㅇ게시판</td>
				<td rowspan="3">△<br/>▽</td>
				</tr>
				<tr><td>ㅇㅇ게시판</td>
				<td>ㅇㅇ게시판</td>
				</tr>
				<tr><td>ㅇㅇ게시판</td>
				<td>ㅇㅇ게시판</td>
				</tr>
			</table>
			
			</td></tr>
			<tr><td><input type="text" class="def-input-text-md custom-form-control">&nbsp;&nbsp;<input type="button" class="def-btn btn-sm btn-gray" value="적용"></td><td>댓글 사용</td><td> 
				<label><input type="radio" name="sub-menu" value="use">사용</label>&nbsp;&nbsp;
						<label><input type="radio" name="sub-menu" value="unuse">사용 안함</label></td></tr>
			<tr><td></td><td>권한설정</td><td>
						
			<table class="def-table-auto tb-border">			
			<tr><th></th><th>읽기</th><th>쓰기</th><th>댓글</th></tr>
			<tr><td>학생</td><td><input type="checkbox" name="student" value="read"></td><td><input type="checkbox" name="student" value="write"></td><td><input type="checkbox" name="student" value="comment"></td></tr>
			<tr><td>교수</td><td><input type="checkbox" name="professor" value="read"></td><td><input type="checkbox" name="professor" value="write"></td><td><input type="checkbox" name="professor" value="comment"></td></tr>
			<tr><td>직원</td><td><input type="checkbox" name="manager" value="read"></td><td><input type="checkbox" name="manager" value="write"></td><td><input type="checkbox" name="manager" value="comment"></td></tr>
			</table>
			</td></tr>			
			</table>
		</div>
	</div>	
		
			
	<div class="col-sm-2 sidenav">		
<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
	<input type="image" src="<%=request.getContextPath()%>/resources/images/right-arrow.png" alt="Submit" onclick="go_step3Add()">
	</div>
	</div>
	
	
	</div>


</form>
</article>
</body>
</html>
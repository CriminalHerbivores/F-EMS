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
<article>


<form id="step2Modify" action="/fems/admin/step3Modify" method="post" name="formm">

	
	<div class="set-layout">
	<div class="set-layout-top">
<img src="<%=request.getContextPath()%>/resources/images/step2.png">
	<h1>STEP2. 메뉴 사용 설정</h1>
	</div>
	
	<div class="col-sm-2 sidenav">
	<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
<input type="image" src="<%=request.getContextPath()%>/resources/images/left-arrow.png" alt="Submit" onclick="history.go(-1);">	</div>
	</div>
	
	<div class="col-sm-8 margin-auto"> 
		<div class="set-layout-center">
			<table class="tb-layout def-table tb-border">
			<tr><td>
			왼쪽 메뉴 사용</td><td colspan="5"><input type="radio" name="sub-menu" value="use" checked="checked">사용&nbsp;&nbsp;
						<input type="radio" name="sub-menu" value="unuse">사용 안함</td></tr>
			
			<tr><td>게시판 추가</td><td colspan="5"><input type="text" class=".def-input-text-md">&nbsp;>&nbsp;<input type="button" class="def-btn" value="추가" onclick=""></td></tr>
			<tr><td colspan="6">
			<table class="def-table tb-border">
				<tr><td>사용</td>
				<td></td>
				<td>미사용</td>
				<td></td>
				</tr>
				<tr><td>ㅇㅇ게시판</td>
				<td>▷</td>
				<td>ㅇㅇ게시판</td>
				<td>△</td>
				</tr>
				<tr><td>ㅇㅇ게시판</td>
				<td>◁</td>
				<td>ㅇㅇ게시판</td>
				<td>▽</td>
				</tr>
			</table>
			
			</td></tr>
			<tr><td><input type="text" class=".def-input-text-md"></td><td>댓글 사용</td><td colspan="4"> 
				<input type="radio" name="sub-menu" value="use">사용&nbsp;&nbsp;
						<input type="radio" name="sub-menu" value="unuse">사용 안함</td></tr>
			<tr><td rowspan="5"></td><td>권한 설정</td><td></td><td>읽기</td><td>쓰기</td><td>댓글</td></tr>
			<tr><td rowspan="4"></td><td>학생</td><td><input type="checkbox" name="student" value="read"></td><td><input type="checkbox" name="student" value="write"></td><td><input type="checkbox" name="student" value="comment"></td></tr>
			<tr><td>교수</td><td><input type="checkbox" name="professor" value="read"></td><td><input type="checkbox" name="professor" value="write"></td><td><input type="checkbox" name="professor" value="comment"></td></tr>
			<tr><td>직원</td><td><input type="checkbox" name="manager" value="read"></td><td><input type="checkbox" name="manager" value="write"></td><td><input type="checkbox" name="manager" value="comment"></td></tr>
			
			</table>
		</div>
	</div>	
		
			
	<div class="col-sm-2 sidenav">		
<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
	<input type="image" src="<%=request.getContextPath()%>/resources/images/right-arrow.png" alt="Submit" onclick="go_step3Modify()"><br/>
	<input type="image" src="<%=request.getContextPath()%>/resources/images/left-arrow.png" alt="Submit" onclick="layoutPreview()">
	</div>
	</div>
	
	
	</div>


</form>
</article>
</body>
</html>
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
<article>
<form id="layout_preview" action="/fems" method="post" name="formm">
<!-- 대학홈페이지 메인 -->	
	
	
	<div class="set-layout">
	<div class="set-layout-top">
	<img src="<%=request.getContextPath()%>/resources/images/step4.png">
	<h1>레이아웃 미리보기</h1>
	</div>
	
	<div class="menu-control">
			<button type="button" onclick="$('.menu-set-control').slideDown()">메뉴 리모컨</button><br/>
	<div class="menu-set-control">
			<table class="tb-layout def-table tb-border" style="width:200px;">
				<tr><td>메뉴1</td><td>
					<select name="메뉴1" class="combobox-md">
					<option value="02">1게시판</option>
					<option value="031">2게시판</option>
					<option value="032">3게시판</option>
					</select>
				</td></tr>
				<tr><td>메뉴2</td><td>
					<select name="메뉴1" class="combobox-md">
					<option value="02">1게시판</option>
					<option value="031">2게시판</option>
					<option value="032">3게시판</option>
					</select>
				</td></tr>

			<tr><td colspan="2"><button type="button" onclick="$('.menu-set-control').slideUp()">닫기</button></td></tr>
			</table>
			
			
	</div>
	</div>
	
			
			<br><br><br><br><br>
			여기에 모달도 넣고 이것저것 해야함
			<br><br><br><br><br>
			<br><br><br><br><br>						
			<br><br><br><br><br>
			
    <div class="preview_layout_btn">
		<input type="submit" class="def-btn" value="이전" onclick="history.go(-1);">&nbsp;&nbsp;<input type="submit" class="def-btn" value="완료" onclick="go_index()"></div>
	
			<br><br><br><br><br>
			<br><br><br><br><br>
			<br><br><br><br><br>
			<br><br><br><br><br>
			<br><br><br><br><br>						
			<br><br><br><br><br>
			<br><br><br><br><br>
			<br><br><br><br><br>
		
		</div>



<footer class="footer container-fluid text-center">
		<p>Footer Text</p>
	</footer>
</form>
</article>
</body>
</html>
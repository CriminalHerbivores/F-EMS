<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 이미 개설된 대학 웹페이지의 레이아웃을 변경하는 JSP
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
<form id="step3Modify" action="/fems/admin/step4Modify" method="post" name="formm">
	
	<div class="set-layout">
	<div class="set-layout-top">
	<img src="<%=request.getContextPath()%>/resources/images/step3.png">
	<h1>STEP3. 레이아웃 선택</h1>
	</div>
	
	<div class="col-sm-2 sidenav">
	<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
<input type="image" src="<%=request.getContextPath()%>/resources/images/left-arrow.png" alt="Submit" onclick="history.go(-1);">	</div>
	</div>
	
	<div class="col-sm-8 margin-auto"> 
		<div class="set-layout-center">
			<table class="tb-layout def-table tb-border">
				<tr><td>1. Login형 <input type="checkbox" id="imgCheck" name="layout-select" value="layout_login" />
				</td><td>2.복합형 <input type="checkbox" id="imgCheck" name="layout-select" value="layout_multi" /></td></tr>
				<tr><td>
						<img src="<%=request.getContextPath()%>/resources/images/layout_login.png" title="blr" id="blr" class="" />
						</td><td>
						<img src="<%=request.getContextPath()%>/resources/images/layout_multi.png" title="blr" id="blr" class="" />
						</td></tr>
				<tr><td>3. 게시판형 <input type="checkbox" id="imgCheck" name="layout-select" value="layout_board" />
				</td><td>4. 메뉴 강조형 <input type="checkbox" id="imgCheck" name="layout-select" value="layout_menu" /></td></tr>
				<tr><td>
					<img src="<%=request.getContextPath()%>/resources/images/layout_board.png" title="blr" id="blr" class="" />
				</td><td>
					<img src="<%=request.getContextPath()%>/resources/images/layout_menu.png" title="blr" id="blr" class="" />
				</td></tr>
			</table>
			
			
		</div>
	</div>	
		

<div class="col-sm-2 sidenav">			
<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
	<input type="image" src="<%=request.getContextPath()%>/resources/images/right-arrow.png" alt="Submit" onclick="go_step4Modify()"><br>
	<input type="image" src="<%=request.getContextPath()%>/resources/images/left-arrow.png" alt="Submit" onclick="layoutPreview()">
	</div>
	</div>

</div>

</form>
</article>

</body>
</html>
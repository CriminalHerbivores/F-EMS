<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * F-EMS로 대학 웹페이지를 개설할 때 제안되는 메인 레이아웃을 선택하는 JSP
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
<form id="step3Add" method="post" enctype="multipart/form-data" name="formm">
	
	<div class="set-layout">
	<div class="set-layout-top">
	<img src="<%=request.getContextPath()%>/resources/images/step3.png"><br/><br/><br/>
	<h1>STEP3. 레이아웃 선택</h1>
	</div>
	
	<div class="col-sm-2 sidenav">
	<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
<input type="image" src="<%=request.getContextPath()%>/resources/images/left-arrow.png" alt="Submit" onclick="history.go(-1);">	</div>
	</div>
	
	<div class="col-sm-8 margin-auto"> 
		<div class="set-layout-center">
			<table class="def-table-full tb-border table-hover tr-child-color">
				<tr><th><label>1. Login형 <input type="radio" id="imgCheck" name="mng_Layout_Knd" value="1" /></label>
				</th><th><label>2.복합형 <input type="radio" id="imgCheck" name="mng_Layout_Knd" value="2" checked="checked"/></label></th></tr>
				<tr>
				<td>
						<img src="<%=request.getContextPath()%>/resources/images/layout_login.png" title="blr" id="blr" class="" />
						</td><td>
						<img src="<%=request.getContextPath()%>/resources/images/layout_multi.png" title="blr" id="blr" class="" />
						</td></tr>
				<tr><th><label>3. 게시판형 <input type="radio" id="imgCheck" name="mng_Layout_Knd" value="3" /></label>
				</th><th><label>4. 메뉴 강조형 <input type="radio" id="imgCheck" name="mng_Layout_Knd" value="4" /></label></th></tr>
				<tr><td>
					<img src="<%=request.getContextPath()%>/resources/images/layout_board.png" title="blr" id="blr" class="" />
				</td><td>
					<img src="<%=request.getContextPath()%>/resources/images/layout_menu.png" title="blr" id="blr" class="" />
				</td></tr>
				<tr>
					<th>좌측메뉴 사용유무</th>
						<td>예<input type="radio" name="mng_Left_Menu_Use_Ennc" value="y" checked> &nbsp;&nbsp;
							아니오 <input type="radio" name="mng_Left_Menu_Use_Ennc" value="n">
					</td>
				</tr>
					<tr>
						<th>대학 이미지</th>
						<td><input type="file" name="uploadUnivImg" value="${manageVO.mng_Univ_Logo}" ></td>
					</tr>
					
			</table>
			
			
		</div>
	</div>	
		

<div class="col-sm-2 sidenav">			
<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
	<input type="image" src="<%=request.getContextPath()%>/resources/images/right-arrow.png" alt="Submit" onclick="submitForm(this.form);">
	</div>
	</div>

</div>

</form>
</article>
</body>
</html>
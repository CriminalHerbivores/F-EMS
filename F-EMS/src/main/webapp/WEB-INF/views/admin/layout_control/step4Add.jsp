<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * F-EMS로 대학 웹페이지를 개설할 때 사용할 컬러 테마를 설정하는 JSP
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
<form id="step4Add" method="post" name="formm">
	
	<div class="set-layout">
	<div class="set-layout-top">
	<img src="<%=request.getContextPath()%>/resources/images/step4.png"><br/>
	<h1>STEP4. 컬러 테마 설정</h1>
	</div>
	
	<div class="col-sm-2 sidenav">
	<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
<input type="image" src="<%=request.getContextPath()%>/resources/images/left-arrow.png" alt="Submit" onclick="history.go(-1);">	</div>
	</div>
	
	
	<div class="col-sm-8 margin-auto"> 
		<div class="set-layout-center">
			
			<table class="tb-layout out-border">
				<tr><td>메인 컬러</td>
									<td><input type="color" name="mng_Main_Color" value="${manageVO.mng_Main_Color}">&nbsp;&nbsp;</td>
					<td>텍스트 컬러</td>
									<td><input type="color" name="mng_Main_Txtclr" value="${manageVO.mng_Main_Txtclr}">&nbsp;&nbsp;</td></tr>
				<tr><td>보조 컬러1</td>
									<td><input type="color" name="mng_Sub_Color1" value="${manageVO.mng_Sub_Color1}">&nbsp;&nbsp;</td>
					<td>텍스트 보조1 </td>
									<td><input type="color" name="mng_Sub_Txtclr1" value="${manageVO.mng_Sub_Txtclr1}">&nbsp;&nbsp;</td></tr>
				<tr><td>보조 컬러2</td>
									<td><input type="color" name="mng_Sub_Color2" value="${manageVO.mng_Sub_Color2}">&nbsp;&nbsp;</td>
					<td>텍스트 보조2</td>
									<td><input type="color" name="mng_Sub_Txtclr2" value="${manageVO.mng_Sub_Txtclr2}">&nbsp;&nbsp;</td></tr>					
				<tr><td>대학 이미지</td><td colspan="5"><div class="preview-layout margin-auto">여기에 미리보기</div></td></tr>
			</table>			
			

		</div>
		</div>
		
		
<div class="col-sm-2 sidenav">			
<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
	<input type="image" src="<%=request.getContextPath()%>/resources/images/right-arrow.png" alt="Submit" onclick="submitForm(this.form)">
	</div>
	</div>

</div>

</form>
</article>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%--
 * <pre>
 * 관리자 메뉴들이 포함되는 관리자 메인 JSP
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
<div class="text-center">
<h2><img src="<%=request.getContextPath()%>${manageVO.mng_Univ_Logo}"></h2><br/>
</div>
	<table class="def-table-full tb-border table-hover tr-child-color">
		<tr><th width="200px">대학 이름</th><td>${manageVO.mng_Univ_Nm }</td></tr>
		<tr><th>대학 영문 이름</th><td>${manageVO.mng_Univ_Eng_Nm }</td></tr>
		<tr><th>우편번호</th><td>${manageVO.mng_Post_No}</td></tr>
		<tr><th>주소</th><td>${manageVO.mng_Adres1}&nbsp;${manageVO.mng_Adres2}</td></tr>
		<tr><th>전화번호</th><td>${manageVO.mng_Tlphon_No}</td></tr>
		<tr><th>팩스번호</th><td>${manageVO.mng_Fax_No}</td></tr>	 
		<tr><th>저작권</th><td>${manageVO.mng_Cpyr}</td></tr>
	</table>
			<hr>
			<table class="def-table-full tb-border table-hover tr-child-color">
				<tr><th width="200px">레이아웃
				</th><td>
				<c:choose>
				<c:when test="${manageVO.mng_Layout_Knd eq 1}">
				로그인형
				</c:when>
				<c:when test="${manageVO.mng_Layout_Knd eq 2}">
				복합형
				</c:when>
				<c:when test="${manageVO.mng_Layout_Knd eq 3}">
				게시판형
				</c:when>
				<c:when test="${manageVO.mng_Layout_Knd eq 4}">
				메뉴형
				</c:when>
				<c:otherwise>
				</c:otherwise>
				</c:choose>
				</td></tr>
				<tr>
					<th>좌측메뉴 사용유무</th>
					<td>${manageVO.mng_Left_Menu_Use_Ennc}</td>
				</tr>
					<tr>
						<th colspan="2">대학 이미지</th>
					</tr>
					<tr>
						<td colspan="2"><img src="<%=request.getContextPath()%>${manageVO.mng_Univ_Img}"></td>
					</tr>
			</table>
			<hr>
			<table class="def-table-full tb-border table-hover tr-child-color">
				<tr><th>메인 컬러</th>
									<td><input type="color" name="mng_Main_Color" value="${manageVO.mng_Main_Color}">&nbsp;&nbsp;</td>
					<th>텍스트 컬러</th>
									<td><input type="color" name="mng_Main_Txtclr" value="${manageVO.mng_Main_Txtclr}">&nbsp;&nbsp;</td></tr>
				<tr><th>보조 컬러1</th>
									<td><input type="color" name="mng_Sub_Color1" value="${manageVO.mng_Sub_Color1}">&nbsp;&nbsp;</td>
					<th>텍스트 보조1 </th>
									<td><input type="color" name="mng_Sub_Txtclr1" value="${manageVO.mng_Sub_Txtclr1}">&nbsp;&nbsp;</td></tr>
				<tr><th>보조 컬러2</th>
									<td><input type="color" name="mng_Sub_Color2" value="${manageVO.mng_Sub_Color2}">&nbsp;&nbsp;</td>
					<th>텍스트 보조2</th>
									<td><input type="color" name="mng_Sub_Txtclr2" value="${manageVO.mng_Sub_Txtclr2}">&nbsp;&nbsp;</td></tr>					
			</table>
	<br/><br/>
	<table class="def-table-full tb-border table-hover tr-child-color">
	<tr>
		<th colspan="4"><h3>대학정보 수정</h3></th>
	</tr>
	<tr>
		<td><a href="step1Add">STEP 1</a></td>
		<td><a href="step2Add">STEP 2</a></td>
		<td><a href="step3Add">STEP 3</a></td>
		<td><a href="<%=request.getContextPath()%>/">INDEX</a></td>
	</tr>
	<tr>
		<th colspan="4"></th>
	</tr>
	</table>
<br/><br/><br/><br/><br/>
</body>
</html>
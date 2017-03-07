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
<form id="step3Add" method="post" enctype="multipart/form-data" name="formm">
<table class="def-table-full"><tr><td>
	<table class="def-table-full tb-border table-hover tr-child-color">
	<tr>
		<td><a href="step1Add">STEP 1</a></td>
		<td><a href="step2Add">STEP 2</a></td>
		<td><a href="step3Add">STEP 3</a></td>
	</tr>
	</table>
	<br/>
<h2>메뉴 관리</h2><br/>
	<table class="def-table-full tb-border table-hover tr-child-color">
		<tr>
			<th>레이아웃 형태</th>
			<td>
				
			</td>
		</tr>
	</table>
<table class="def-table-full"><tr><td style="text-align: right;">
	<input type="submit" value="등록" class="def-btn btn-md btn-color">
</td></tr></table>
</td></tr></table>
<br/><br/><br/>
</form>
</body>
</html>
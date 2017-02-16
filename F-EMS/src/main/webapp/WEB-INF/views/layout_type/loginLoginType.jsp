<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%--
 * <pre>
 * 레이아웃 중 로그인형 로그인화면 JSP
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
<meta charset=UTF-8">
<title></title>
</head>
<body>


<div class="custom-col-sm-10-top sidenav">
<div class=" array-center ">
	<table class="def-table-auto">
	<tr><td rowspan="4"><img src="<%=request.getContextPath()%>${manageVO.mng_Univ_Img}"></td>
	<td colspan="2"><img src="<%=request.getContextPath()%>${manageVO.mng_Univ_Logo}"></td></tr>
	<tr><td colspan="2">	
			<table class="def-table-auto">
				<tr><td>
				<input type="hidden" name="returl" value="${param.returl }" />
				<input type="text" class="def-input-text-md custom-form-control" name="userid" placeholder="아이디" value="${param.userid }"/></td>
					<td rowspan="2">
					<input type="submit" class="def-btn btn-lg btn-color" value="로그인"></td></tr>
				<tr><td><input type="password" class="def-input-text-md custom-form-control" name="password" placeholder="패스워드"></td></tr>
				<tr><td colspan="2"><!-- <span id='change'>여기 아작스</span> --></td></tr>
		<tr><td><input type="button" class="def-btn btn-sm btn-color" value="ID찾기" onclick="modal_find_id()"></td><td><input type="button" class="def-btn btn-sm btn-color" value="PW찾기" onclick="modal_find_pw()"></td></tr>
			</td></tr>
			</table>
	</table>
	</div>
	</div>

<!-- Footer 시작 -->
	<footer class="footer container-fluid text-center">
		<p>Footer Text</p>
	</footer>
	<!-- Footer 끝 -->
</body>
</html>
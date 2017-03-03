<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
 * <pre>
 * 레이아웃 중 게시판형 로그인화면 JSP
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


<!-- 상단바 시작 -->
<jsp:include page="../../../decorators/top_bar.jsp"/>
<!-- 상단바 끝 --> 

<!-- 상단 메뉴 -->
<jsp:include page="../../../decorators/top_menu.jsp"/>
<!-- 상단 메뉴 끝 -->

<form method="post" name="formm">


	<div class="container-fluid">
		<div class="row content">
			
			<div class="custom-col-sm-4 sidenav">
<c:choose>
<c:when test="${empty loginUser}">
			<table class="def-table-full out-border">
			<!-- <form action="login" id="loginForm" method="post"> -->
				<tr><td>
<input type="hidden" name="returl" value="${param.returl }" />
<input type="text" class="def-input-text-md custom-form-control" name="userid" placeholder="아이디" value="${param.userid }"/></td>
					<td rowspan="2">
					<input type="submit" class="def-btn btn-lg btn-color" value="로그인"></td></tr>
				<tr><td><input type="password" class="def-input-text-md custom-form-control" name="password" placeholder="패스워드"></td></tr>
				<!-- <tr><td colspan="2"><span id='change'>여기 아작스</span></td></tr> -->
<!-- </form> -->
		<tr><td><input type="button" class="def-btn btn-sm btn-color" value="ID찾기" onclick="modal_find_id()"></td><td><input type="button" class="def-btn btn-sm btn-color" value="PW찾기" onclick="modal_find_pw()"></td></tr>
			</table>
</c:when>
<c:otherwise>
<table class="def-table-full out-border">
<tr><td>
<span>${loginUser}</span>&nbsp;&nbsp;</td><td>
<a href="<%=request.getContextPath()%>/logout"><button class="def-btn float-right">Logout</button></a>
</td></tr>
</table>
</c:otherwise>
</c:choose>

			<div>
<br/>
			<table class="def-table-full tb-border"><tr><td>
			스케쥴러
			</td></tr></table>
			</div>
			</div>
			
			<div class="custom-col-sm-6 sidenav text-left">
			<table class="def-table-full tb-border">
				<tr><td>
				
				<table class="def-table-full tb-border table-hover">
			<tr><th>공지사항</th></tr>
			<tr><td>공지 게시글...........5</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........4</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........3</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........2</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........1</td><td>2017-02-10</td></tr>
		</table>
				
				</td><td>
					<table class="def-table-full tb-border table-hover">
			<tr><th>공지사항</th></tr>
			<tr><td>공지 게시글...........5</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........4</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........3</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........2</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........1</td><td>2017-02-10</td></tr>
		</table>
				</td></tr>
				<tr><td>
				<table class="def-table-full tb-border table-hover">
			<tr><th>공지사항</th></tr>
			<tr><td>공지 게시글...........5</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........4</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........3</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........2</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........1</td><td>2017-02-10</td></tr>
		</table>
				</td><td>
				<table class="def-table-full tb-border table-hover">
			<tr><th>공지사항</th></tr>
			<tr><td>공지 게시글...........5</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........4</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........3</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........2</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........1</td><td>2017-02-10</td></tr>
		</table>
				</td></tr>
			</table>
			
	</div></div>
	</div>

</form>
<!-- Footer 시작 -->
	<footer class="footer container-fluid text-center">
		<p>Footer Text</p>
	</footer>
	<!-- Footer 끝 -->

</body>
</html>
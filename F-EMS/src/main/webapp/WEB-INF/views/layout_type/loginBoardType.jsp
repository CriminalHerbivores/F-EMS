<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<meta charset="UTF-8">
<title></title>
<script>
	function get_msg(message) {
		jQuery('#message').text(message);
		$('#message').show(300).delay(500);
		$('#message').hide(300).delay(500);
	}
	<c:if test="${error == 'true'}">
	jQuery(function() {
		get_msg("로그인실패하였습니다.");
	});
	</c:if>
	function emptyMsg(){
		get_msg("");
	}
	function login_go() {
		$.ajax({
			url : 'login',
			data : $('form input').serialize(),
			type : 'POST',
			dataType : 'json',
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
			}
		}).done(function(body) {
			var message = body.response.message;
			var error = body.response.error;
			var returl=body.response.returl;			
			if (error)
				get_msg(message);
			if (error == false) {
				if (returl == '')
					returl = '<c:url value="/" />';
				location.href = returl;
			}
		});
	}
</script>
</head>
<body>

<!-- 상단바 시작 -->
<jsp:include page="../../../decorators/top_bar.jsp"/>
<!-- 상단바 끝 --> 
<!-- 상단 메뉴 -->
<jsp:include page="../../../decorators/top_menu.jsp"/>
<!-- 상단 메뉴 끝 -->

	<div class="container-fluid">
		<div class="row content">
			<div class="custom-col-sm-4 sidenav">
<c:choose>
<c:when test="${empty loginUser}">
<form action="login" id="loginForm" method="post">
<table class="def-table-full out-border">
<tr>
	<td width="200px">
<input type="hidden" name="returl" value="${param.returl }" />
<input type="text" class="def-input-text-md custom-form-control" name="userid" placeholder="아이디" value="${param.userid }"/>
	</td>
</tr>
<tr>
	<td>
	<input type="password" class="def-input-text-md custom-form-control" name="password" placeholder="패스워드">
	</td>
</tr>
<tr>
	<td>
	<input type="button" class="def-btn btn-sm btn-color" value="로그인" onclick="login_go(this.form)">
	<a href="findIdPw"><button class="def-btn btn-sm btn-color"><i class="glyphicon glyphicon-search"></i></button></a>
	</td>
</tr>
</table>
<table class="def-table-full"><tr><td colspan="2">
<span id='message'></span>
</td></tr></table>
</form>
</c:when>
<c:otherwise>
<table class="def-table-full out-border">
<tr>
	<td width="200px">
	<span>${loginUser}</span>&nbsp;&nbsp;
	</td>
</tr>
<tr>
	<td>
	<a href="logout"><input type="button" class="def-btn btn-sm btn-color" value="로그아웃"/></a>
	</td>
</tr>
</table>
</c:otherwise>
</c:choose>

</div>
			
	<div class="custom-col-sm-6 sidenav text-left">
	<table class="def-table-full out-border">
			<tr><td width="50%">
		<table class="def-table-auto tb-border table-hover">
			<tr><th>공지사항</th></tr>
			<c:forEach items="${nList}" var="nL" begin="0" end="4">
			<tr>
			<td>
				<c:choose>
					<c:when test="${fn:length(nL.nb_Sj) > 14}">
					<c:out value="${fn:substring(nL.nb_Sj,0,13)}"/>....
					</c:when>
					<c:otherwise>
					<c:out value="${nL.nb_Sj}"/>
					</c:otherwise> 
		       </c:choose>
			</td>
			<td>${fn:substring(nL.nb_Writng_Dt,0,10)}</td>
			</tr>
			</c:forEach>
		</table>
			</td><td width="50%">
		<table class="def-table-auto tb-border table-hover">
			<tr><th>학사일정</th></tr>
			<c:forEach items="${schd}" var="sch" begin="0" end="4">
			<tr>
			<td>${fn:substring(sch.sd_Bgndt,0,10)}</td>
			<td>${fn:substring(sch.sd_Enddt,0,10)}</td>
			<td>
				<c:choose>
					<c:when test="${fn:length(sch.sd_Schdul_Sumry) > 14}">
					<c:out value="${fn:substring(sch.sd_Schdul_Sumry,0,13)}"/>....
					</c:when>
					<c:otherwise>
					<c:out value="${sch.sd_Schdul_Sumry}"/>
					</c:otherwise> 
		       </c:choose>
			</c:forEach>
		</table>
			</td></tr>
			<tr>
			<td>
		<c:if test="${not empty list0}">
		<table class="def-table-full tb-border table-hover">
			<c:forEach items="${list0}" var="nL" begin="0" end="4">
			<tr>
			<c:forEach items="${menuList}" var="mL" begin="0" end="1">
			<tr><th>${mL.mn_Nm}</th></tr>
			</c:forEach>
			<td>
				<c:choose>
					<c:when test="${fn:length(nL.bb_Sj) > 14}">
					<c:out value="${fn:substring(nL.bb_Sj,0,13)}"/>....
					</c:when>
					<c:otherwise>
					<c:out value="${nL.bb_Sj}"/>
					</c:otherwise> 
		       </c:choose>
			</td>
			<td>${fn:substring(nL.bb_Writng_dt,0,10)}</td>
			</tr>
			</c:forEach>
		</table>
		</c:if>
			</td>
			<td>
		<c:if test="${not empty list1}">
		<table class="def-table-full tb-border table-hover">
			<c:forEach items="${list1}" var="nL" begin="0" end="4">
			<tr>
			<c:forEach items="${menuList}" var="mL" begin="1" end="2">
			<tr><th>${mL.mn_Nm}</th></tr>
			</c:forEach>
			<td>
				<c:choose>
					<c:when test="${fn:length(nL.bb_Sj) > 14}">
					<c:out value="${fn:substring(nL.bb_Sj,0,13)}"/>....
					</c:when>
					<c:otherwise>
					<c:out value="${nL.bb_Sj}"/>
					</c:otherwise> 
		       </c:choose>
			</td>
			<td>${fn:substring(nL.bb_Writng_dt,0,10)}</td>
			</tr>
			</c:forEach>
		</table>
		</c:if>
			</td>
		</tr>
	</table>
	</div>
	</div>
</div>

<!-- Footer 시작 -->
	<footer class="footer container-fluid text-center">
		<p>Footer Text</p>
	</footer>
	<!-- Footer 끝 -->

</body>
</html>
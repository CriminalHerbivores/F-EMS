<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--
 * <pre>
 * 레이아웃 중 복합형형 로그인화면 JSP
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/sweetalert.css">
<script>
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
				swal("", "로그인에 실패하였습니다.", "error");
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

<!-- <form id="" method="post" name="formm"> -->
<!-- <div class="custom-col-sm-10-top sidenav text-left"> -->
<div class="array-center">
<table class="def-table-auto">
	<tr>
		<td colspan="2">
		<img src="<%=request.getContextPath()%>${manageVO.mng_Univ_Logo}" height="40px">
		</td>
		<td rowspan="3">
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
		</td></tr>
	<tr>
	<td colspan="2">	
<c:choose>
<c:when test="${empty loginUser}">
<form action="login" id="loginForm" method="post">
<table class="def-table-auto out-border ">
	<tr>
		<td width="150px">
<input type="hidden" name="returl" value="${param.returl }" />
<input type="text" class="def-input-text-md custom-form-control" name="userid" placeholder="아이디" value="${param.userid }"/>
		</td>
		<td rowspan="2">
<input type="button" class="def-btn btn-lg btn-color" value="로그인" onclick="login_go(this.form)">
		</td>
	</tr>
	<tr>
<td><input type="password" class="def-input-text-md custom-form-control" name="password" placeholder="패스워드"></td>
	</tr>
	<!-- <tr><td colspan="2"><span id='change'>여기 아작스</span></td></tr> -->
</table>
</form>
</c:when>
<c:otherwise>
<form action="logout">
<table class="def-table-auto out-border ">
	<tr>
		<td width="150px">
${loginUser}
		</td>
		<td>
<input type="submit" class="def-btn btn-lg btn-color" value="로그아웃">
		</td>
	</tr>
	<!-- <tr><td colspan="2"><span id='change'>여기 아작스</span></td></tr> -->
</table>
</form>
</c:otherwise>
</c:choose>
	</td></tr>
	<tr>
		<td>
		<a href="findIdPw">
		<input type="button" class="def-btn btn-sm btn-color" value="ID/PW찾기">
		</a>
		</td>
		<td>
		<a href="main">
		<input type="button" class="def-btn btn-sm btn-color" value="메인으로">
		</a>
		</td>
	</tr>
	<tr>
		<td colspan="3">
			<table class="def-table-full tb-border td-odd"  style="width:100% !important;">
				<tr>
				<c:forEach items="${menuList}" var="mn">
				<c:choose>
				<c:when test="${mn.mn_Se_Code=='etc'}">
				<td><a href="${mn.mn_Cours}">${mn.mn_Nm}</a></td>
				</c:when>
				<c:when test="${mn.mn_Se_Code=='aa'}">
				<td><a href="#"></a></td>
				</c:when>
				<c:otherwise>
				<td><a href="<%=request.getContextPath()%>/${mn.mn_Cours}">${mn.mn_Nm}</a></td>
				</c:otherwise>
				</c:choose>
				</c:forEach>
				</tr>
			</table>		
		</td>
	</tr>
</table>
</div>
<!-- </div>	 -->
<!-- </form> -->
<!-- Footer 시작 -->
<!-- 	<footer class="footer container-fluid text-center">
		<p>Footer Text</p>
	</footer> -->
	<!-- Footer 끝 -->

</body>
</html>
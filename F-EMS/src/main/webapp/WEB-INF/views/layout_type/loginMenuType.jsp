<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%--
 * <pre>
 * 레이아웃 중 메뉴강조형 로그인화면 JSP
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
<script type="text/javascript">
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
<div id="header">

<div class=" array-center ">			
<form action="login" id="loginMenuForm" method="post">
<table class="def-table-auto">
	<tr><td rowspan="5"><img src="<%=request.getContextPath()%>${manageVO.mng_Univ_Img}"></td>
	<td colspan="2" ><img src="<%=request.getContextPath()%>${manageVO.mng_Univ_Logo}"></td></tr>
	<!-- 만약 로그인유저가 널이라면 이거 보여주고 아닐경우 다른거 보여주고픔 -->
	<c:choose>
	
	<c:when test="${empty loginUser}" >
	<tr><td class="vertical-bottom">	
<input type="hidden" name="returl" value="${param.returl }" />
<input type="text" class="def-input-text-md custom-form-control" name="userid" placeholder="아이디" value="${param.userid }"/></td>
<td rowspan="2"><input type="button" class="def-btn btn-lg btn-color" value="로그인" onclick="login_go();"/></td></tr>
<tr><td class="vertical-top"><input type="password" class="def-input-text-md custom-form-control" name="password" placeholder="패스워드"></td></tr>
<tr><td colspan="2">
<button onclick="document.getElementById('id01').style.display='block'" class="def-btn btn-sm btn-color">ID찾기</button>
<input type="button" value="PW찾기" class="def-btn btn-sm btn-color" onclick="modal_find_pw()"></td></tr>
<tr  style="height:50px;"><td colspan="2"><div><span id="message"></span></div></td></tr>
	</c:when>
	<c:otherwise>
		
		
			<tr><td class="vertical-bottom">	
<input type="hidden" name="returl" value="${param.returl }" />
${loginUser} </td>
<td rowspan="2"><input type="button" class="def-btn btn-lg btn-color" value="로그인" onclick="login_go();"/></td></tr>
<tr><td class="vertical-top"><input type="password" class="def-input-text-md custom-form-control" name="password" placeholder="패스워드"></td></tr>
<tr><td colspan="2">
<button onclick="document.getElementById('id01').style.display='block'" class="def-btn btn-sm btn-color">ID찾기</button>
<input type="button" value="PW찾기" class="def-btn btn-sm btn-color" onclick="modal_find_pw()"></td></tr>
<tr  style="height:50px;"><td colspan="2"><div><span id="message"></span></div></td></tr>
		
		
	</c:otherwise>
	</c:choose>

</form>
  <tr><td colspan="5">
		<table class="def-table-full tb-border" style="width:100% !important;">
		<tr><td class="login-menu-gray"><div>메뉴1</div></td><td  class="login-menu"><div>메뉴2</div></td><td class="login-menu-gray"><div>메뉴3</div></td><td class="login-menu"><div>메뉴4</div></td><td class="login-menu-gray"><div>메뉴5</div></td></tr>	
		<tr><td class="login-menu"><div>메뉴6</div></td><td  class="login-menu-gray"><div>메뉴7</div></td><td class="login-menu"><div>메뉴8</div></td><td class="login-menu-gray"><div>메뉴9</div></td><td class="login-menu"><div>메뉴10</div></td></tr>	
		<tr><td class="login-menu-gray"><div>메뉴11</div></td><td  class="login-menu"><div>메뉴12</div></td><td class="login-menu-gray"><div>메뉴13</div></td><td class="login-menu"><div>메뉴14</div></td><td class="login-menu-gray"><div>메뉴15</div></td></tr>	
	</table></td></tr></table>
	</div>
	
	</div>
		<!-- </div> -->



<!-- Footer 시작 -->
<!-- 	<footer class="footer container-fluid text-center">
		<p>Footer Text</p>
	</footer> -->
	<!-- Footer 끝 -->

</body>
</html>
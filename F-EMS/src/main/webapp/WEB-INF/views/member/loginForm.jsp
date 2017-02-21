<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
	<div id="header">
		<h3>로그인</h3>
	</div>
	<div id="section">
		<form action="login" id="loginForm" method="post">
			<input type="hidden" name="returl" value="${param.returl }" />
			<input type="text" class="def-input-text-md custom-form-control" name="userid" placeholder="아이디" value="${param.userid }"/><br/><br/>		
			<input type="password" class="def-input-text-md custom-form-control" name="password" placeholder="패스워드"/><br /><br/>
			<input class="def-btn btn-sm btn-color" type="button" value="로그인" onclick="login_go();"/>
			<a href="findIdPw"><input class="def-btn btn-sm btn-color" type="button" value="아이디/비밀번호 찾기"/></a>
			<!-- <input style="background: #eeeeff;" type="submit" value="로그인(html)"  /> --> 
			<div><span id="message"></span></div>
		</form>
	</div>
	
</body>
</html>


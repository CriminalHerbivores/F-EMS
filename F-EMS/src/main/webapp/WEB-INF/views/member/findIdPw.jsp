<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
<script>
function findId() {
	var idName = $('#idName').val().trim();
	var idEmail = $('#idEmail').val().trim();
	if(idName=="" || idName==null){
		swal("이름을 입력해 주세요");
		return;
	}
	if(idEmail=="" || idEmail ==null){
		swal("이메일을 입력해 주세요");
		return;
	}
	$.ajax({
		url : 'findId',
		data : $('#idformm input').serialize(),
		type : 'POST',
		dataType : 'text',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
		}
	}).done(function(id) {
		if(id=="" || id==null){
			swal("아이디를 찾을 수 없습니다.");
		}else{
			swal("아이디는 "+id+"입니다.");
		}
	});
}
function findPw() {
	var pwId = $('#pwId').val().trim();
	var pwName = $('#pwName').val().trim();
	var pwEmail = $('#pwEmail').val().trim();
	if(pwId=="" || pwId==null){
		swal("아이디를 입력해 주세요");
		return;
	}
	if(pwName=="" || pwName ==null){
		swal("이름을 입력해 주세요");
		return;
	}
	if(pwEmail=="" || pwEmail ==null){
		swal("이메일을 입력해 주세요");
		return;
	}
	$.ajax({
		url : 'findPw',
		data : $('#pwformm input').serialize(),
		type : 'POST',
		dataType : 'text',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
		}
	}).done(function(pw) {
		if(pw=="" || pw==null){
			swal("비밀번호를 찾을 수 없습니다.");
		}else{
			swal("비밀번호는 "+pw+"입니다.");
		}
	});
}
</script>
</head>
<body>
	<h3>아이디 찾기</h3>
	<div id="sectionId">
		<form id="idformm" method="post">
			이름 : <input type="text" id="idName" class="def-input-text-md custom-form-control" name="name"/><br/><br/>		
			이메일 : <input type="text" id="idEmail" class="def-input-text-md custom-form-control" name="email"/><br/><br/>
			<input class="def-btn btn-sm btn-color" type="button" value="아이디/비밀번호 찾기" onclick="findId();"/>
			<div><span id="messageId"></span></div>
		</form>
	</div>
	<h3>비밀번호 찾기</h3>
	<div id="pwformm" id="sectionPw">
		<form method="post">
			아이디 : <input type="text" id="pwId" class="def-input-text-md custom-form-control" name="id"/><br/><br/>		
			이름 : <input type="text" id="pwName" class="def-input-text-md custom-form-control" name="name"/><br/><br/>		
			이메일 : <input type="text" id="pwEmail" class="def-input-text-md custom-form-control" name="email"/><br/><br/>
			<input class="def-btn btn-sm btn-color" type="button" value="비밀번호 찾기" onclick="findPw();"/>
			<div><span id="message"></span></div>
		</form>
	</div>
</body>
</html>


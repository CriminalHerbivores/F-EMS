<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 관리자가 직원 등록을 할 수 있는 JSP
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
/* 
function userNo_check(){	
	
	var stf_Sklstf_No = document.formm.stf_Sklstf_No.value;
	var stfNo_ck = /^[0-9]{1-9}$/;		//영소문자로 시작, 영소문, 영대문, 숫자로 8~20글자 사이
	
	if(stfNo_ck.test(stf_Sklstf_No)==false){
		alert("직원번호는 9글자 숫자로 가능");
	}
} */

function submit_sklstf(){

if(true){
	

	
// id검사 버튼 위에서 안 눌렀을 때를 위한 유효성 검사
	var stf_Sklstf_No = document.formm.stf_Sklstf_No.value;
	var stfNo_ck = /^[0-9]{9}$/;		//영소문자로 시작, 영소문, 영대문, 숫자로 8~20글자 사이
	
	if(stfNo_ck.test(stf_Sklstf_No)==false){
		alert("직원번호는 9글자 숫자로 가능");
}
	
// 학과 선택
if(document.formm.sit_Subjct.value==""){
	alert("학부 선택 필수");
}

// 패스워드1 유효성 검증
var pwd1 = document.formm.stf_Pw.value;	
var pwdck = /^[a-zA-Z0-9!~@#$%^&*_+|\=.,;?:`-]{8,20}$/;		//영소문, 영대문, 숫자, 특수문자로 8~20글자 사이
if(pwdck.test(pwd1)==false){
	alert("비밀번호는  영소문자, 영대문자, 숫자, 특수문자 8~20글자로 이루어지도록 입력");
}


// 패스워드1, 2 일치 확인
var pwd2 = document.formm.stf_Pw_ck.value;		
if(pwd1 != pwd2){
	alert("패스워드가 일치하지 않습니다.");
}

//주민등록번호 검증
var jm_no = document.formm.stf_Ihidnum.value;		
var jm_no_ck = /^[0-9]{13}$/;	
if(jm_no_ck.test(jm_no)==false){	
	alert("주민등록번호는 숫자로만 입력");
}


// 이름 유효성 검증
var irum = document.formm.stf_Nm.value;		
var irumck = /^[가-힇]{2,5}$/;		// 한글 2~5자
if(irumck.test(irum)==false){	
	alert("한글이름은 한글로 2~5자 입력 해주세요.");
}

//영문이름 유효성 검증
var en_irum = document.formm.stf_Eng_Nm.value;		
var en_irumck = /^[a-zA-Z]{2,30}$/;		// 영어 2~30자
if(en_irumck.test(en_irum)==false){	
	alert("영문이름은 영문으로 2~30자 입력 해주세요.");
}

// 이메일 유효성 검증
var email = document.formm.stf_Email.value;		
var emailck = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9--]+(\.[a-zA-Z0-9]+){1,2}$/;		// 이메일 형식에 맞게
if(emailck.test(email)==false){
	alert("이메일 양식에 맞게 입력 해주세요.\n 예)example@gmail.com ");
}


//휴대폰 번호 유효성 검증
var mobile = document.formm.stf_Moblphon_No.value;		
var mobileck = /^(01[16789][1-9][0-9]{6,7})|(010[1-9][0-9]{7})$/;		// 숫자만...010은 뒤에 숫자 8개 와야함
if(mobileck.test(mobile)==false){
	alert("휴대폰 번호는 숫자로만 입력");
}

//직원 전화번호 유효성 검증
var mobile = document.formm.stf_Sklstf_Tlphon_No.value;		
var mobileck = /^(0[1-9][0-9]{6,9})$/;
if(mobileck.test(mobile)==false){
	alert("직원 전화번호는 숫자로만 입력");
}

//집 번호 유효성 검증
var mobile = document.formm.stf_House_Tlphon_No.value;		
var mobileck = /^(0[1-9][0-9]{6,9})$/;
if(mobileck.test(mobile)==false){
	alert("집 전화번호는 숫자로만 입력");
}

//우편번호
if(document.formm.stf_Post_No.value==""){
	alert("우편번호 선택 필수");
}

//학과 선택
if(document.formm.stf_Adres2.value==""){
	alert("주소 입력 필수");
}

}else{
document.formm.submit();
	
}	

}


/* function get_msg(message) {
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
} */

</script>

</head>
<body>
<form id="formm" name="formm" method="post" enctype="multipart/form-data">
<table class="non-border margin-auto">
 	<tr><td><h2>직원 등록</h2></td></tr>
 	<tr><td colspan="2">
 	<table class="def-table-auto tb-border table-hover">
      <tr>
        <th>직원 번호</th>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Sklstf_No">&nbsp;
        <input type="hidden" name="sa_Sklstf_No"></td>
        <th>학부</th>
        <td><input type="text" class="def-input-text-md custom-form-control" name="fc_Faculty_Nm" readonly>
        <input type="hidden" name="coleg_Nm" > 
        <input type="hidden" name="stf_Subject_Code"> 
        </td>
        <th>학과</th>
        <td><input type="text" class="def-input-text-md custom-form-control" name="sit_Subjct" readonly>&nbsp;<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchSubjct()"></td>
      </tr>
      
      <tr>
        <th>이름</th>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Nm"></td>
        <th>영문이름</th>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Eng_Nm"></td>
        <th>이메일</th>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Email"></td>
      </tr>
      
      <tr>
        <th>비밀번호</th>
        <td><input type="password" class="def-input-text-md custom-form-control" name="stf_Pw"></td>
        <th>비밀번호 확인</th>
        <td><input type="password" class="def-input-text-md custom-form-control" name="stf_Pw_ck"></td>
        <th>주민등록번호</th>
        <td><input type="password" class="def-input-text-md custom-form-control" name="stf_Ihidnum" ></td>
      </tr>
      <tr>
        <th>우편번호</th>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Post_No" readonly>&nbsp;<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchZipNum()"></td>
        <th>주소</th>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Adres1" readonly></td>
        <th>상세 주소</th>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Adres2"></td>
      </tr>
      <tr>
        <th>핸드폰 번호</th>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Moblphon_No"></td>
        <th>집 전화번호</th>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_House_Tlphon_No"></td>
        <th>직원 전화번호</th>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Sklstf_Tlphon_No" ></td>
      </tr>
      <tr><th>권한</th><td><input type="radio" name="sa_Atrty" value="ROLE_STF" checked="checked">직원&nbsp;&nbsp;<input type="radio" name="sa_Atrty" value="ROLE_ADMIN">관리자</td>
      <th>근무여부</th><td><input type="radio" name="stf_Useyn" value="1" checked="checked">근무&nbsp;&nbsp;<input type="radio" name="stf_Useyn" value="0">근무 안함</td>
      <td></td><td></td></tr>
  </table>
  	</td></tr>
	<tr><td>파일 경로:&nbsp;<input type="text" class="def-input-text-lg custom-form-control" name="file"></td><td rowspan="2"><span id="message" class="text-right"></span></td></tr><tr><td><input type="file" name="f"></td></tr>
	<tr><td colspan="2">
   <div id="buttons" class="float-right">
   <input type="button" class="def-btn btn-md btn-color"  value="등록" onclick="submit_sklstf()">&nbsp;&nbsp; <input type="button" class="def-btn btn-md btn-gray"  value="취소" onclick="go.history(-1)"></div></td></tr>
   </table>
  </form>
</body>
</html>
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
<h2>직원 등록</h2><br/>
<table class="def-table-full tb-border table-hover">
 	<tr>
 	    <th>주민번호</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="stf_Ihidnum" ></td>
 		<th>권한</th><td><label><input type="radio" name="sa_Atrty" value="ROLE_STF" checked="checked">직원</label>&nbsp;&nbsp;<label><input type="radio" name="sa_Atrty" value="ROLE_ADMIN">관리자</label></td>
        <th>학과 검색</th>
		<td>
		<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchSubjct()">
		<input type="hidden" id="subjct_Code" name="stf_Subject_Code" class="def-input-text-lg custom-form-control" readonly>
		</td>
      </tr>
      <tr>
        <th>단과대학</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="coleg_Nm" name="coleg_Nm" readonly>
        <th>학부</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="faculty_Nm" name="fc_Faculty_Nm" readonly>
        </td>
        <th>학과</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="subjct_Nm" name="sit_Subjct" readonly>
        </td>
      </tr>
      
      <tr>
        <th>이름</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="stf_Nm"></td>
        <th>영문이름</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="stf_Eng_Nm"></td>
        <th>이메일</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="stf_Email"></td>
      </tr>
      
      <tr>
        <th>우편번호</th>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Post_No" id="zipNum" readonly >&nbsp;<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchZipNum()"></td>
        <th>주소</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="stf_Adres1" id="addres1" readonly></td>
        <th>상세 주소</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="stf_Adres2"></td>
      </tr>
      <tr>
        <th>핸드폰 번호</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="stf_Moblphon_No"></td>
        <th>집 전화번호</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="stf_House_Tlphon_No"></td>
        <th>직원 전화번호</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="stf_Sklstf_Tlphon_No" ></td>
      </tr>
      <tr>
        <th>등록양식</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name=""></td>
        <th>업로드</th>
        <td colspan="3"><input type="file" name="f"></td>
      </tr>
  </table>
<table class="def-table-full"><tr><td style="text-align: right;">
   <input type="button" class="def-btn btn-sm btn-color" value="등록" onclick="submit_sklstf(this.form);">&nbsp;&nbsp; 
   <input type="button" class="def-btn btn-sm btn-color"  value="취소" onclick="go.history(-1)">
</td></tr></table>
</form>
</body>
</html>
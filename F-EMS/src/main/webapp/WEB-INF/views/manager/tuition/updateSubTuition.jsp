<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
* <pre>
* 
* </pre>
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 2. 22.      JAR      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://code.jquery.com/jquery.min.js"></script>

<script>
$(function(){
	$('#sit_Tut').keyup(function(){
		var inc = $(this).val();
		var ori = $('#orig').val();
		var per = Math.round((inc-ori)/ori*10000)/100+"%";
		
		$('#perTut').html(per);
	});
})
</script>
</head>
<body>
<table class="non-border margin-auto"><tr><td>
	<h2>학과 정보 조회</h2><br/>
	<form name="formm" method="post">
	<table class="def-table-full tb-border table-hover">
		<tr>
			<th>단과</th>
			<th>학부</th>
			<th>학과</th>
			<th>등록금</th>
			<th>학과 전화번호</th>
		</tr>
		<tr>
			<td>${tut.coleg_Nm}</td>
			<td>${tut.fc_Faculty_Nm}</td>
			<td>${tut.sit_Subjct}</td>
			<td><fmt:formatNumber value="${tut.sit_Tut}"/> 원</td>
			<td>${tut.sit_Subjct_Tlphon_No}</td>
		</tr>
		<tr>
			<th colspan="3">등록금 수정</th>
			<th>상승률</th>
			<th>수정 / 목록</th>
		</tr>
		<tr>
			<td colspan="3">
				<input type="number" id="sit_Tut" name="sit_Tut" class="def-input-text-full custom-form-control">
			</td>
			<td>
				<input type="hidden" id="orig" value="${tut.sit_Tut}">
				<div id="perTut"></div>
			</td>
			<td>
				<input type="button" value="수정" onclick="submitForm(this.form)" class="def-btn btn-sm btn-color">
				&nbsp;&nbsp;
				<input type="button" value="목록" onclick="history.go(-1)" class="def-btn btn-sm btn-color">
			</td>
		</tr>
	</table>
	</form>
</td></tr></table>
</body>
</html>
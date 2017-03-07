<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
* [[개정이력(Modification Information)]]
* 수정일      수정자      수정내용
* ----------  ---------  -----------------
* 2017.01.24.    KJS      최초작성
* 2017.02.15.    JAR      추가작성
* 2017.03.07.    KJS      추가작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var Useyn = "${skn_Useyn}";
	var skn_Type = "${skn_Type}";
	var Stdnt_No = "${Stdnt_No}";
	if(Stdnt_No == "%")
		Stdnt_No = "";
	$('input:radio[name=rSkn_Useyn]:input[value="'+Useyn+'"]').attr("checked", true);
	$('select[name=sskn_Type]>option[value="'+skn_Type+'"]').attr("selected", true);
	$('input[name="key"]').val(Stdnt_No);
});
function list_get(){
	var skn_Useyn = $(':radio[name="rSkn_Useyn"]:checked').val();
	var skn_Type = $("select[name='sskn_Type']").val();
	var st_Stdnt_No = $('input[name="key"]').val();
	
	location.href="<%=request.getContextPath() %>/sklstf/sknrgListForm?skn_Useyn="
			+skn_Useyn+"&skn_Type="+skn_Type+"&Stdnt_No="+st_Stdnt_No;
	
}
</script>
</head>
<body>
	<form name="formm" method="POST">
		<h2>학적 관리</h2>
		<br />
<table class="def-table-full"><tr><td></td><td style="text-align: center;">
	<input type="radio" name="rSkn_Useyn" value="%">전체 &nbsp;&nbsp;
	<input type="radio" name="rSkn_Useyn" value="o">미정&nbsp;&nbsp;
	<input type="radio" name="rSkn_Useyn" value="y">승인&nbsp;&nbsp;
	<input type="radio" name="rSkn_Useyn" value="n">불가&nbsp;&nbsp;
	
	</td>
				<td style="text-align: right;">
				
				<select name="sskn_Type"
					class="combobox-md custom-form-control">
						<option value="%">선택</option>
						<option value="입학">입학</option>
						<option value="휴학">휴학</option>
						<option value="복학">복학</option>
						<option value="졸업">졸업</option>
						<option value="제적">제적</option>
						<option value="퇴학">퇴학</option>
						<option value="조기졸업">조기졸업</option>
						<option value="졸업연기">졸업연기</option>
				</select>&nbsp;&nbsp; 학번 : <input type="text" name="key"
					class="def-input-text-lg custom-form-control">&nbsp;&nbsp;
					<input type="button" value="조회"
						class="def-btn btn-sm btn-color" onclick="list_get();"></td>
			</tr></table>
		<table class="def-table-full tb-border table-hover">
			<tr>
				<th>번호</th>
				<th>학번</th>
				<th>학과</th>
				<th>이름</th>
				<th>신청 사유</th>
				<th>학적 변동</th>
				<th>파일</th>
				<th>승인여부</th>
			</tr>
			<c:forEach var="sknrgs" items="${sknrgsVOList}">
				<tr>
				
					<td>${sknrgs.skn_No}
					<td>${sknrgs.st_Stdnt_No}</td>
					<td>${sknrgs.sit_Subjct}</td>
					<td>${sknrgs.st_Nm}</td>
					<td>${sknrgs.skn_Content}</td>
					<td>${sknrgs.skn_Type}</td>
					<td><a href="<%=request.getContextPath() %>/download/file/list?filename=${sknrgs.skn_File}">${sknrgs.skn_File}</a></td>
					<td>
					<input type="hidden" name="skn_No" value="${sknrgs.skn_No}"> 
					<c:choose>
					<c:when test="${sknrgs.skn_Useyn=='y'}">
					<select name="skn_Useyn" class="combobox-md custom-form-control">
						<option value="o">미정</option>
						<option value="n">불가</option>
						<option value="y" selected>승인</option>
					</select>
					</c:when>
					<c:when test="${sknrgs.skn_Useyn=='n'}">
					<select name="skn_Useyn" class="combobox-md custom-form-control">
						<option value="o">미정</option>
						<option value="n" selected>불가</option>
						<option value="y">승인</option>
					</select>
					</c:when>
					<c:otherwise>
					<select name="skn_Useyn" class="combobox-md custom-form-control">
						<option value="o" selected>미정</option>
						<option value="n">불가</option>
						<option value="y">승인</option>
					</select>
					</c:otherwise>
					</c:choose>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8" style="text-align: center;">${paging}</td>
			</tr>
		</table>
		<table class="def-table-full"><tr><td style="text-align: right;">
		<input type="submit"  value="등록" class="def-btn btn-sm btn-color"/>
		</td></tr></table>
	</form>

</body>
</html>

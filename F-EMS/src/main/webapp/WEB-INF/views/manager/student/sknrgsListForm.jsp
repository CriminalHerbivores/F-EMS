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
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>

<body>
	<form name="formm" method="POST">
		<div class="container">
			<h2>학적 관리</h2>
			<table class="table table-bordered">
				<tr>
					<td colspan="6" class="text-right">
					<select name="skn_Type" class="combobox-sm">
							<option value="선택">선택</option>
							<option value="입학">입학</option>
							<option value="휴학">휴학</option>
							<option value="복학">복학</option>
							<option value="졸업">졸업</option>
							<option value="제적">제적</option>
							<option value="퇴학">퇴학</option>
							<option value="조기졸업">조기졸업</option>
							<option value="졸업연기">졸업연기</option>
					</select>&nbsp;&nbsp; 
					<input type="text" name="key" class="def-input-text-sm">&nbsp;&nbsp; 
					<input type="button" class="def-btn" value="조회" onclick="submitForm(this.form);">&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<th>학번</th>
					<th>학과</th>
					<th>이름</th>
					<th>신청 사유</th>
					<th>학적 변동</th>
					<th>승인여부</th>
				</tr>
				<c:forEach var="sknrgs" items="${sknrgsVOList}">
					<tr>
						<td>${sknrgs.st_Stdnt_No}</td>
						<td>${sknrgs.sit_Subjct}</td>
						<td>${sknrgs.st_Nm}</td>
						<td>${sknrgs.skn_Content}</td>
						<td>${sknrgs.skn_Type}</td>
						<td>
							<input type="hidden"name="skn_No" value="${sknrgs.skn_No}"> 
							<input class="checkbox" type="checkbox" name="skn_Useyn" value="y">
							가능
							<input class="checkbox" type="checkbox" name="skn_Useyn" value="n">
							불가능
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6" style="text-align: center;">${paging }</td>
				</tr>
			</table>
		</div>
		<input type="button" class="btn btn-default" onClick="submitForm(this.form);" value="등록"/>
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 직원목록 및 직원의 관리자 권한여부 목록을 조회할 수 있는 JSP
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
</head>
<body>

<form name="formm" mehtod="post">
	

<div class="text-center">
	<!-- <div class="container out-border"> -->
	<!-- <table class="def-table-full tb-border"> -->
	<h2>직원 등록</h2>
	<table class="def-table-full">
	<tr><td class="text-right">
					<select name="선택" class="combobox-md custom-form-control">
					<option value="032">전공</option>
					<option value="033">교양</option>
					<option value="02">강의</option>
					<option value="031">학과</option>
					<option value="041">담당교수</option>
				</select>&nbsp;&nbsp;
					<input type="text" class="def-input-text-md custom-form-control">&nbsp;&nbsp;
					<button class="def-btn btn-search btn-color" value="조회"><i class="glyphicon glyphicon-search"></i>&nbsp;조회</button>&nbsp;&nbsp;
					<input type="button" class="def-btn btn-search btn-color" value="상세검색">&nbsp;&nbsp;
	</td></tr>
	</table>
			<table class="def-table-full tb-border table-hover">
				<!-- <tr>
					<td colspan="12"  class="text-right">
					</td>
				</tr> -->
				<tr><th colspan="13"><h4>개설 강의 목록</h4></th></tr>
				<tr>
					<th>직원번호</th>
					<th>단과대학</th>
					<th>학부</th>
					<th>학과</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>연락처</th>
					<th>구분</th>
				</tr>
				
				<c:forEach items="${userSubjctVO}" var="subjct" begin="0" end="9">
				<tr>
					<td>
			
					
						</td>
					
					<td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="관심추가"></td>
					<td>${subjct.stf_Sklstf_No}</td>
					<td>${subjct.coleg_Nm}</td>
					<td>${subjct.fc_Faculty_Nm}</td>
					<td>${subjct.sit_Subjct }</td>
					<td>${subjct.stf_Nm}</td>
					<td>${subjct.stf_Ihidnum}</td>
					<td>${subjct.stf_Sklstf_Tlphon_No}</td>
					<td>${subjct.}</td>
					<td>${subjct.stf_Useyn}</td>
					
				</tr>
			</c:forEach>
				
			</table>
</div>
	</form>

</body>
</html>
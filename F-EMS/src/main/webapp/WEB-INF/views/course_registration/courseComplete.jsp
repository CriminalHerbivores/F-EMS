<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 수강신청이 완료된 강의 목록을 보여주는 JSP
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
<style>
body {
	/* background: #D9E5FF; */
}
</style>

</head>
<body class="course-list-l-bottom">
	<form>
<div class="text-center">
			<table  class="def-table-full tb-border table-hover">
				<tr>
					<th colspan="13"><h4>수강 신청 완료 목록</h4></th>
				</tr>
				<tr>
					<th>수강해제</th>
					<th>관심강의</th>
					<th>개설학과</th>
					<th>강의코드</th>
					<th>분반</th>
					<th>학년</th>
					<th>강의명</th>
					<th>이수구분</th>
					<th>학점/시수</th>
					<th>담당교수</th>
					<th>강의시간</th>
					<th>수강인원</th>
					<th>제한인원</th>
				</tr>

	 			<c:forEach items="${lctre_SearchVO}" var="lctre">
				<%-- <c:choose>
				<c:when test="{ requestVO.re_NO}" > --%>
				<tr>
					<td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="수강해제"></td>
					<td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="관심추가"></td>
					<td>${lctre.sit_Subjct}</td>
					<td>${lctre.lu_Lctre_Code}</td>
					<td>${lctre.lc_Split}</td>
					<td>${lctre.lu_Grade }</td>
					<td>${lctre.lu_Lctre_Nm}</td>
					<td>${lctre.lu_Compl_Se}</td>
					<td>${lctre.lu_Pnt}</td>
					<td>${lctre.pr_Nm}</td>
					<td>${lctre.lc_Lctre_Time}</td>
					<td>${lctre.lc_Lctre_Nmpr}</td>
					<td>${lctre.lr_Accept_Nmpr}</td> 
				</tr>
				<%-- </c:when>
				<c:otherwise>
				
				</c:otherwise>
				</c:choose> --%>
			</c:forEach> 
				
				
			</table>

</div>
	</form>
</body>
</html>
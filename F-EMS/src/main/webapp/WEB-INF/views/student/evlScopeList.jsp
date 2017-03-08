<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.03.08    KJS            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<h2>강의 평가</h2>
	<br />

	<form name="formm">
		<table class="def-table-full tb-border table-hover">
			<tr>
				<td>강의명</td>
				<td>점수</td>
				<td>참여여부</td>
			</tr>
			<c:forEach var="lctre_Search" items="${lctre_SearchVO}">
				<c:choose>
					<c:when test="${empty lctre_Search.re_Lctre_Evl_Scope}">
						<tr>
							<td><a
								href="evlScope?re_Stdnt_No=${lctre_Search.re_Stdnt_No }&re_Lctre_No=${lctre_Search.re_Lctre_No }&tpage=${tpage}">${lctre_Search.lu_Lctre_Nm }</a>
							</td>
							<td>${lctre_Search.re_Lctre_Evl_Scope }</td>
							<td>미참여</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td>${lctre_Search.lu_Lctre_Nm }</td>
							<td>${lctre_Search.re_Lctre_Evl_Scope }</td>
							<td>참여</td>
						</tr>
					</c:otherwise>
				</c:choose>

			</c:forEach>
			<tr>
				<td colspan="3" style="text-align: center;">${paging }</td>
			</tr>
		</table>
	</form>

</body>
</html>

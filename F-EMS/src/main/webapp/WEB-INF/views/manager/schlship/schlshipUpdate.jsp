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
<h2>등록금 정보 수정</h2>
	<form method="POST" enctype="multipart/form-data" name="formm">
		<table class="table table-bordered">
			<tr>
				<td>장학금 명 :</td>
				<td><input type="text" name="ss_Schlship_Nm" value="${schlshipVO.ss_Schlship_Nm}"></td>
			</tr>
			<tr>
				<td>유형 :</td>
				<td><input type="text" name="ss_Schlship_Type" value="${schlshipVO.ss_Schlship_Type}"></td>
			</tr>
			<tr>
				<td>금액 :</td>
				<td><input type="text" name="ss_Amount" value="${schlshipVO.ss_Amount}"></td>
			</tr>
			<tr>
				<td>내용 :</td>
				<td>
<textarea name="ss_Papers_Content">
${schlshipVO.ss_Papers_Content}
</textarea>
				</td>
			</tr>
			<tr>
				<td>첨부파일 :</td>
				<td><input type="file" name="f" value=""></td>
			</tr>
		</table>
		<input type="button" value="수정" onclick="submitForm(this.form);" class="def-btn btn-sm btn-color">
		<a href="deleteSchlship?ss_Schlship_Code=${param.ss_Schlship_Code}&tpage=${tpage}"> 
		<c:choose>
		<c:when test="${schlshipVO.ss_useyn eq 'y'}">
		<input type="button" value="삭제" class="def-btn btn-sm btn-color">
		</c:when>
		<c:otherwise>
		<input type="button" value="복구" class="def-btn btn-sm btn-color">
		</c:otherwise>
		</c:choose>
		</a>
		<input type="button" class="def-btn btn-sm btn-color" value="이전" onclick="history.go(-1);">
	</form>
</body>
</html>
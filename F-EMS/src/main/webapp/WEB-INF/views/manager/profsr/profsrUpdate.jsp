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
	<h2>교수 정보 수정</h2>
	<form method="POST" name="formm">
		<input type="hidden" name="tpage" value="${tpage}">
		<table class="table table-bordered">
			<tr>
				<td>교수 번호</td>
				<td><input type="text" class="form-control" id="pr_Profsr_No" name="pr_Profsr_No" value="${profsrVO.pr_Profsr_No}"></td>
				<td>학부</td>
				<td><input type="text" class="form-control" id="" name="" value=""></td>
				<td>학과</td>
				<td><input type="text" class="form-control" id="" name="" value=""></td>
			</tr>

			<tr>
				<td>이름</td>
				<td><input type="text" class="form-control" id="pr_Nm" name="pr_Nm" value="${profsrVO.pr_Nm }"></td>
				<td>영문이름</td>
				<td><input type="text" class="form-control" id="pr_Eng_Nm" name="pr_Eng_Nm" value="${profsrVO.pr_Nm }"></td>
				<td>이메일</td>
				<td><input type="text" class="form-control" id="pr_Email" name="pr_Email" value="${ profsrVO.pr_Email}"></td>
			</tr>

			<tr>
				<td>비밀번호</td>
				<td><input type="text" class="form-control" id="pr_Pw" name="pr_Pw" value="${profsrVO.pr_Pw }"></td>
				<td>비밀번호 확인</td>
				<td><input type="text" class="form-control" id="pr_Pw_on" name="pr_Pw_on" value="${profsrVO.pr_Pw }"></td>
				<td>주민 번호</td>
				<td><input type="text" class="form-control" id="pr_Ihidnum" name="pr_Ihidnum" value="${profsrVO.pr_Ihidnum }"></td>
			</tr>
			<tr>
				<td>우편주소</td>
				<td><input type="text" class="form-control" id="pr_Post_No" name="pr_Post_No" value="${profsrVO.pr_Post_No }"></td>
				<td>주소</td>
				<td><input type="text" class="form-control" id="pr_Adres1" name="pr_Adres1" value="${profsrVO.pr_Adres1 }"></td>
				<td>상세 주소</td>
				<td><input type="text" class="form-control" id="pr_Adres2" name="pr_Adres2" value="${profsrVO.pr_Adres2 }"></td>
			</tr>
			<tr>
				<td>핸드폰 번호</td>
				<td><input type="text" class="form-control" id="pr_Moblphon_No" name="pr_Moblphon_No" value="${profsrVO.pr_Moblphon_No }"></td>
				<td>집 전화번호</td>
				<td><input type="text" class="form-control" id="pr_House_Tlphon_No" name="pr_House_Tlphon_No" value="${profsrVO.pr_House_Tlphon_No }"></td>
				<td>교수 번호</td>
				<td><input type="text" class="form-control" id="pr_Profsr_Tlphon_No" name="pr_Profsr_Tlphon_No" value="${profsrVO.pr_Profsr_Tlphon_No }"></td>
			</tr>
		</table>
		<button type="button" class="btn btn-default" onclick="go_profsrUpdate()">수정</button>
		<button type="button" class="btn btn-default" onclick="history.go(-1);">취소</button>
	</form>
</body>
</html>
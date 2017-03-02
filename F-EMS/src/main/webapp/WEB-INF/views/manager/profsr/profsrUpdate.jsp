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
	<h2>교수 정보 수정</h2><br/>
	<form method="POST" name="formm">
		<input type="hidden" name="tpage" value="${tpage}">
<table class="def-table-auto tb-border table-hover">
	<tr>
		<th>교수 번호</th>
		<td colspan="3"><input type="text" class="def-input-text-lg custom-form-control" value="${profsrVO.pr_Profsr_No}" readonly></td>
		<th>학과 검색</th>
		<td>
		<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchSubjct()">
		<input type="hidden" id="subjct_Code" name="psa_Subjct_Code" value="${profsrVO.psa_Subjct_Code}" class="def-input-text-lg custom-form-control" readonly>
		</td>
	</tr>
	<tr>
		<th>단과</th>
		<td><input type="text" id="coleg_Nm" name="coleg_Nm" value="${profsrVO.coleg_Nm}" class="def-input-text-lg custom-form-control" readonly></td>
		<th>학부</th>
		<td><input type="text" id="faculty_Nm" name="fc_Faculty_Nm" value="${profsrVO.fc_Faculty_Nm}" class="def-input-text-lg custom-form-control" readonly></td>
		<th>학과</th>
		<td><input type="text" id="subjct_Nm" name="sit_Subjct" value="${profsrVO.sit_Subjct}" class="def-input-text-lg custom-form-control" readonly></td>
	</tr>

	<tr>
		<th>이름</th>
		<td><input type="text" class="def-input-text-lg custom-form-control" id="pr_Nm" name="pr_Nm" value="${profsrVO.pr_Nm }"></td>
		<th>영문이름</th>
		<td><input type="text" class="def-input-text-lg custom-form-control" id="pr_Eng_Nm" name="pr_Eng_Nm" value="${profsrVO.pr_Nm }"></td>
		<th>이메일</th>
		<td><input type="text" class="def-input-text-lg custom-form-control" id="pr_Email" name="pr_Email" value="${ profsrVO.pr_Email}"></td>
	</tr>

	<tr>
		<th>비밀번호</th>
		<td><input type="password" class="def-input-text-lg custom-form-control" id="pr_Pw" name="pr_Pw" value="${profsrVO.pr_Pw }"></td>
		<th>비밀번호 확인</th>
		<td><input type="password" class="def-input-text-lg custom-form-control" id="pr_Pw_on" name="pr_Pw_on" value=""></td>
		<th>주민 번호</th>
		<td><input type="text" class="def-input-text-lg custom-form-control" id="pr_Ihidnum" name="pr_Ihidnum" value="${profsrVO.pr_Ihidnum }" readonly></td>
	</tr>
	<tr>
		<th>우편번호</th>
		<td><input type="text" class="def-input-text-md custom-form-control" id="zipNum" name="pr_Post_No" value="${profsrVO.pr_Post_No }" readonly>&nbsp;<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchZipNum()"></td>
		<th>주소</th>
		<td><input type="text" class="def-input-text-lg custom-form-control" id="addres1" name="pr_Adres1" value="${profsrVO.pr_Adres1 }" readonly></td>
		<th>상세 주소</th>
		<td><input type="text" class="def-input-text-lg custom-form-control" id="pr_Adres2" name="pr_Adres2" value="${profsrVO.pr_Adres2 }"></td>
	</tr>
	<tr>
		<th>핸드폰 번호</th>
		<td><input type="text" class="def-input-text-lg custom-form-control" id="pr_Moblphon_No" name="pr_Moblphon_No" value="${profsrVO.pr_Moblphon_No }"></td>
		<th>집 전화번호</th>
		<td><input type="text" class="def-input-text-lg custom-form-control" id="pr_House_Tlphon_No" name="pr_House_Tlphon_No" value="${profsrVO.pr_House_Tlphon_No }"></td>
		<th>교수 전화번호</th>
		<td><input type="text" class="def-input-text-lg custom-form-control" id="pr_Profsr_Tlphon_No" name="pr_Profsr_Tlphon_No" value="${profsrVO.pr_Profsr_Tlphon_No }"></td>
	</tr>
</table>
<table class="def-table-full"><tr><td style="text-align: right;">
	<button type="button" class="def-btn btn-sm btn-color" onclick="go_profsr()">수정</button>
	<button type="button" class="def-btn btn-sm btn-color" onclick="history.go(-1);">취소</button>
</td></tr></table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spting" uri="http://www.springframework.org/tags"%>
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
<h2>직원 정보 수정</h2><br/>
<form method="post" name="formm">
<input type="hidden" name="tpage" value="${tpage}">
<table class="def-table-auto tb-border table-hover">
      <tr>
        <th>직원 번호</th>
        <td colspan="3"><input type="text" class="def-input-text-lg custom-form-control" id="stf_Sklstf_No" name="stf_Sklstf_No" value="${sklstfVO.stf_Sklstf_No}" readonly></td>
        <th>학과 검색</th>
        <td>
		<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchSubjct()">
		<input type="hidden" id="subjct_Code" name="stf_Subject_Code" value="${sklstfVO.stf_Subject_Code}" class="def-input-text-lg custom-form-control" readonly>
		</td>
      </tr>
      <tr>
        <th>단과</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="coleg_Nm" name="coleg_Nm" value="${sklstfVO.coleg_Nm}" readonly></td>
        <th>학부</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="faculty_Nm" name="fc_Faculty_Nm" value="${sklstfVO.fc_Faculty_Nm}" readonly></td>
        <th>학과</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id ="subjct_Nm" name="sit_Subjct" value="${sklstfVO.sit_Subjct}" readonly></td>
      </tr>
      <tr>
      	<th>이름</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="stf_Nm" name="stf_Nm" value="${sklstfVO.stf_Nm }"></td>
        <th>영문이름</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="stf_Eng_Nm" name="stf_Eng_Nm" value="${sklstfVO.stf_Eng_Nm }"></td>
        <th>이메일</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="stf_Email" name="stf_Email" value="${sklstfVO.stf_Email }"></td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td><input type="password" class="def-input-text-lg custom-form-control" id="stf_Pw" name="stf_Pw" value="${sklstfVO.stf_Pw }"></td>
        <th>비밀번호 확인</th>
        <td><input type="password" class="def-input-text-lg custom-form-control" id="stf_Pw_on" name="stf_Pw_on" value=""></td>
        <th>주민번호</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="stf_Ihidnum" name="stf_Ihidnum" value="${sklstfVO.stf_Ihidnum }" readonly></td>
      </tr>
      <tr>
        <th>우편번호</th>
        <td><input type="text" class="def-input-text-md custom-form-control" id="zipNum" name="stf_Post_No" value="${sklstfVO.stf_Post_No }" readonly>&nbsp;<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchZipNum()"></td>
        <th>주소</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="addres1" name="stf_Adres1" value="${sklstfVO.stf_Adres1 }" readonly></td>
        <th>상세주소</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="stf_Adres2" name="stf_Adres2" value="${sklstfVO.stf_Adres2 }"></td>
      </tr>
      <tr>
        <th>핸드폰 번호</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="stf_Moblphon_No" name="stf_Moblphon_No" value="${sklstfVO.stf_Moblphon_No }"></td>
        <th>집 전화번호</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="stf_House_Tlphon_No" name="stf_House_Tlphon_No" value="${sklstfVO.stf_House_Tlphon_No }"></td>
        <th>직원 전화번호</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="stf_Sklstf_Tlphon_No" name="stf_Sklstf_Tlphon_No" value="${sklstfVO.stf_Sklstf_Tlphon_No }"></td>
      </tr>
  </table>
  <table class="def-table-full"><tr><td style="text-align: right;">
    <input type="button" class="def-btn btn-sm btn-color" onclick="go_sklstf()" value="수정">
    <button type="button" class="def-btn btn-sm btn-color" onclick="history.go(-1)">취소</button>
  </td></tr></table>
</form>
</body>
</html>
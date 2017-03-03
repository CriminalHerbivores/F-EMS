<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<h2>학생 정보 수정</h2><br/>
<form method="POST" name="formm">
<input type="hidden" name="tpage" value="${tpage}">
 <input type="hidden" name="st_Subjct_Code" value="${stdntVO.st_Subjct_Code}" readonly>
<table class="def-table-auto tb-border table-hover">
      <tr>
        <th>학생 번호</th>
        <td colspan="3"><input type="text" value="${stdntVO.st_Stdnt_No}" class="def-input-text-lg custom-form-control" readonly></td>
        <th>학과 검색</th>
        <td>
		<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchSubjct()">
		<input type="hidden" id="subjct_Code" name="st_Subjct_Code" value="${stdntVO.st_Subjct_Code}" class="def-input-text-lg custom-form-control" readonly>
		</td>
      </tr>
      <tr>
        <th>단과</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="coleg_Nm" name="coleg_Nm" value="${stdntVO.coleg_Nm}" readonly></td>
        <th>학부</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="faculty_Nm" name="fc_Faculty_Nm" value="${stdntVO.fc_Faculty_Nm}" readonly></td>
        <th>학과</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id ="subjct_Nm" name="sit_Subjct" value="${stdntVO.sit_Subjct}" readonly></td>
      </tr>
      
      <tr>
        <th>이름</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="st_Nm" value="${stdntVO.st_Nm}"></td>
        <th>영문이름</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="st_Eng_Nm" value="${stdntVO.st_Eng_Nm}"></td>
        <th>이메일</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="st_Email" value="${stdntVO.st_Email}"></td>
      </tr>
      
      <tr>
        <th>비밀번호</th>
        <td><input type="password" class="def-input-text-lg custom-form-control" name="st_Pw" value="${stdntVO.st_Pw}"></td>
        <th>비밀번호 확인</th>
        <td><input type="password" class="def-input-text-lg custom-form-control" name="st_Pw_on" value=""></td>
        <th>주민 번호</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="st_Ihidnum" value="${stdntVO.st_Ihidnum}" readonly></td>
      </tr>
      <tr>
      	<th>우편번호</th>
        <td><input type="text" class="def-input-text-md custom-form-control" id="zipNum" name="st_Post_No" value="${stdntVO.st_Post_No}" readonly>&nbsp;<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchZipNum()"></td>
        <th>주소</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" id="addres1" name="st_Adres1" value="${stdntVO.st_Adres1}" readonly></td>
        <th>상세 주소</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="st_Adres2" value="${stdntVO.st_Adres2}" value="${stdntVO.st_Adres2}"></td>
      </tr>
      <tr>
        <th>핸드폰 번호</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="st_Moblphon_No" value="${stdntVO.st_Moblphon_No}"></td>
        <th>집 전화번호</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="st_House_Tlphon_No" value="${stdntVO.st_House_Tlphon_No}"></td>
        <th>담당 교수</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="st_Profsr_No" value="${stdntVO.st_Profsr_No}" readonly></td>
      </tr>
      <tr>
        <th>보호자 이름</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="st_Prtctor_Nm" value="${stdntVO.st_Prtctor_Nm}"></td>
        <th>가족관계</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="st_Family_Relate" value="${stdntVO.st_Family_Relate}"></td>
        <th>입학일</th>
        <td><input type="text" class="def-input-text-lg custom-form-control" name="st_Entsch_Dt" value="${stdntVO.st_Entsch_Dt}" readonly></td>
      </tr>
      
  </table>
   <table class="def-table-full"><tr><td style="text-align: right;">
   <button type="button" class="def-btn btn-sm btn-color" onclick="go_stdnt()">수정</button>
    <button type="button" class="def-btn btn-sm btn-color" onclick="history.go(-1)">취소</button>
  </td></tr></table>
  </form>
</body>
</html>

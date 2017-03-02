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
<h2>학생 정보 수정</h2>
<form method="POST" name="formm">
<input type="hidden" name="tpage" value="${tpage}">
 <input type="hidden" name="st_Subjct_Code" value="${stdntVO.st_Subjct_Code}" readonly>
 <table class="table table-bordered">
      <tr>
        <td>학생 번호</td>
        <td><input type="text" class="form-control" readonly value="${stdntVO.st_Stdnt_No}" readonly></td>
        <td>학부</td>
        <td><input type="text" class="form-control" id="faculty_Nm" name="fc_Faculty_Nm" value="${stdntVO.fc_Faculty_Nm}" readonly></td>
        <td>학과</td>
        <td><input type="text" class="form-control" id ="subjct_Nm" name="st_Subjct_Nm" value="${stdntVO.sit_Subjct}" readonly></td>
      </tr>
      
      <tr>
        <td>이름</td>
        <td><input type="text" class="form-control" name="st_Nm" value="${stdntVO.st_Nm}"></td>
        <td>영문이름</td>
        <td><input type="text" class="form-control" name="st_Eng_Nm" value="${stdntVO.st_Eng_Nm}"></td>
        <td>이메일</td>
        <td><input type="text" class="form-control" name="st_Email" value="${stdntVO.st_Email}"></td>
      </tr>
      
      <tr>
        <td>비밀번호</td>
        <td><input type="password" class="form-control" name="st_Pw" value="${stdntVO.st_Pw}"></td>
        <td>비밀번호 확인</td>
        <td><input type="password" class="form-control" name="st_Pw_on" value="${stdntVO.st_Pw}"></td>
        <td>주민 번호</td>
        <td><input type="text" class="form-control" name="st_Ihidnum" value="${stdntVO.st_Ihidnum}" readonly></td>
      </tr>
      <tr>
      	<td>우편번호</td>
        <td><input type="text" class="form-control def-input-text-md" id="zipNum" name="st_Post_No" value="${stdntVO.st_Post_No}" readonly>&nbsp;<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchZipNum()"></td>
        <td>주소</td>
        <td><input type="text" class="form-control" id="addres1" name="st_Adres1" value="${stdntVO.st_Adres1}" readonly></td>
        <td>상세 주소</td>
        <td><input type="text" class="form-control" name="st_Adres2" value="${stdntVO.st_Adres2}"></td>
      </tr>
      <tr>
        <td>핸드폰 번호</td>
        <td><input type="text" class="form-control " name="st_Moblphon_No" value="${stdntVO.st_Moblphon_No}"></td>
        <td>집 전화번호</td>
        <td><input type="text" class="form-control" name="st_House_Tlphon_No" value="${stdntVO.st_House_Tlphon_No}"></td>
        <td>담당 교수</td>
        <td><input type="text" class="form-control" name="st_Profsr_No" value="${stdntVO.st_Profsr_No}" readonly></td>
      </tr>
      <tr>
        <td>보호자 이름</td>
        <td><input type="text" class="form-control" name="st_Prtctor_Nm" value="${stdntVO.st_Prtctor_Nm}"></td>
        <td>가족관계</td>
        <td><input type="text" class="form-control" name="st_Family_Relate" value="${stdntVO.st_Family_Relate}"></td>
        <td>입학일</td>
        <td><input type="text" class="form-control" name="st_Entsch_Dt" value="${stdntVO.st_Entsch_Dt}" readonly></td>
      </tr>
      
  </table>
   <button type="button" class="btn btn-default" onclick="go_stdnt()">수정</button>
    <button type="button" class="btn btn-default" onclick="history.go(-1)">취소</button>
  </form>
</body>
</html>
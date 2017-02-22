<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 관리자가 직원 등록을 할 수 있는 JSP
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
<form id="formm" name="formm" method="post" enctype="multipart/form-data">
<table class="non-border margin-auto">
 	<h2>직원 등록</h2>
 	<tr><td>
 	<table class="def-table-auto tb-border table-hover">
      <tr>
        <td>직원 번호</td>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Sklstf_No"></td>
        <td>학부</td>
        <td><input type="text" class="def-input-text-md custom-form-control" name="fc_Faculty_Nm" readonly>
        <input type="hidden" name="coleg_Nm" > 
        <input type="hidden" name="stf_Subject_Code"> 
        </td>
        <td>학과</td>
        <td><input type="text" class="def-input-text-md custom-form-control" name="sit_Subjct" readonly>&nbsp;<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchSubjct()"></td>
      </tr>
      
      <tr>
        <td>이름</td>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Nm"></td>
        <td>영문이름</td>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Eng_Nm"></td>
        <td>이메일</td>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Email"></td>
      </tr>
      
      <tr>
        <td>비밀번호</td>
        <td><input type="password" class="def-input-text-md custom-form-control" name="stf_Pw"></td>
        <td>비밀번호 확인</td>
        <td><input type="password" class="def-input-text-md custom-form-control" name="stf_Pw"></td>
        <td>주민등록번호</td>
        <td><input type="password" class="def-input-text-md custom-form-control" name="stf_Ihidnum" ></td>
      </tr>
      <tr>
        <td>우편번호</td>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Post_No" readonly>&nbsp;<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchZipNum()"></td>
        <td>주소</td>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Adres1" readonly></td>
        <td>상세 주소</td>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Adres2"></td>
      </tr>
      <tr>
        <td>핸드폰 번호</td>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Moblphon_No"></td>
        <td>집 전화번호</td>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_House_Tlphon_No"></td>
        <td>교수 번호</td>
        <td><input type="text" class="def-input-text-md custom-form-control" name="stf_Sklstf_Tlphon_No" ></td>
      </tr>
      <tr><td>근무여부</td><td colspan="5"><input type="radio" name="stf_Useyn" value="1" checked="checked">근무&nbsp;&nbsp;<input type="radio" name="stf_Useyn" value="0">근무 안함</td></tr>
  </table>
  	</td></tr>
  	<tr><td>단체등록 미구현 상태</td></tr>
	<tr><td>	파일 경로: <input type="text" name="file"></td><td> 파일경로: <input type="file" name="f"></td><td>
   <div id="buttons" class="float-right">
   <input type="button" class="def-btn btn-md btn-color"  value="등록" onclick="submitForm(this.form)">&nbsp;&nbsp; <input type="button" class="def-btn btn-md btn-gray"  value="취소" onclick="go.history(-1)"></div></td></tr>
   </table>
  </form>
</body>
</html>
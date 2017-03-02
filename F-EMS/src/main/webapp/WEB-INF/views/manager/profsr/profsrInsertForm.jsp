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
<%-- <form action="multipartFile" method="POST"enctype="multipart/form-data" name="frm"> --%>
<form method="POST" enctype="multipart/form-data" name="formm">
 	<h2>교수 정보 등록</h2>
 <table class="table table-bordered">
      <tr>
        <td>교수 번호</td>
        <td><input type="text" class="form-control" id="pr_Profsr_No" name="pr_Profsr_No"></td>
        <td>학부</td>
        <td>
        <input type="hidden" id="coleg_Nm" name="" value="" readonly>
        <input type="hidden" id="subjct_Code" name="" value="" readonly>
        <input type="text" class="form-control" id="faculty_Nm" name="" value="" readonly>
        </td>
        <td>학과</td>
        <td><input type="text" class="form-control" id="subjct_Nm" name="" readonly>&nbsp;<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchSubjct()"></td>
      </tr>
      
      <tr>
        <td>이름</td>
        <td><input type="text" class="form-control" id="pr_Nm" name="pr_Nm"></td>
        <td>영문이름</td>
        <td><input type="text" class="form-control" id="pr_Eng_Nm" name="pr_Eng_Nm"></td>
        <td>이메일</td>
        <td><input type="text" class="form-control" id="pr_Email" name="pr_Email"></td>
      </tr>
      
      <tr>
        <td>비밀번호</td>
        <td><input type="password" class="form-control" id="pr_Pw" name="pr_Pw"></td>
        <td>비밀번호 확인</td>
        <td><input type="password" class="form-control" id="pr_Pw_on" name="pr_Pw_on"></td>
        <td>주민 번호</td>
        <td><input type="text" class="form-control" id="pr_Ihidnum" name="pr_Ihidnum" ></td>
      </tr>
      <tr>
        <td>우편번호</td>
        <td><input type="text" class="form-control" id="zipNum" name="pr_Post_No" readonly>&nbsp;<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchZipNum()"></td>
        <td>주소</td>
        <td><input type="text" class="form-control" id="addres1" name="pr_Adres1" readonly></td>
        <td>상세 주소</td>
        <td><input type="text" class="form-control" id="st_Adres2" name="pr_Adres2"></td>
      </tr>
      <tr>
        <td>핸드폰 번호</td>
        <td><input type="text" class="form-control" id="pr_Moblphon_No" name="pr_Moblphon_No"></td>
        <td>집 전화번호</td>
        <td><input type="text" class="form-control" id="pr_House_Tlphon_No" name="pr_House_Tlphon_No"></td>
        <td>교수 전화 번호</td>
        <td><input type="text" class="form-control" id="pr_Profsr_Tlphon_No" name="pr_Profsr_Tlphon_No" ></td>
      </tr>
  </table>
		교수등록양식: <a href="<%=request.getContextPath() %>/download/file/list?filename=교수등록.xlsx">다운로드</a><br /> 
		<input type="file" name="f"><br />
   <button type="button" class="btn btn-default" onclick="go_profsr()">등록</button>
   <button type="button" class="btn btn-default" onclick="history.go(-1)">취소</button>
  </form>
</body>
</html>
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
<form method="post" name="frm">

 <table class="table table-bordered">
      <tr>
        <td>직원 번호</td>
        <td><input type="text" class="form-control" id="stf_Sklstf_No" name="stf_Sklstf_No" value="${sklstfVO.stf_Sklstf_No}"></td>
        <td>소속</td>
        <td><input type="text" class="form-control" id="" name="" value=""></td>
        <td>구분</td>
        <td><input type="text" class="form-control" id="" name="" value=""></td>
      </tr>
      
      <tr>
        <td>이름</td>
        <td><input type="text" class="form-control" id="stf_Nm" name="stf_Nm" value="${sklstfVO.stf_Nm }"></td>
        <td>영문이름</td>
        <td><input type="text" class="form-control" id="stf_Eng_Nm" name="stf_Eng_Nm" value="${sklstfVO.stf_Eng_Nm }"></td>
        <td>이메일</td>
        <td><input type="text" class="form-control" id="stf_Email" name="stf_Email" value="${sklstfVO.stf_Email }"></td>
      </tr>
      
      <tr>
        <td>비밀번호</td>
        <td><input type="text" class="form-control" id="stf_Pw" name="stf_Pw" value="${sklstfVO.stf_Pw }"></td>
        <td>비밀번화 확인</td>
        <td><input type="text" class="form-control" id="stf_Pw_on" name="stf_Pw_on" value="${sklstfVO.stf_Pw }"></td>
        <td>생년월일</td>
        <td><input type="text" class="form-control" id="stf_Ihidnum" name="stf_Ihidnum" value="${sklstfVO.stf_Ihidnum }"></td>
      </tr>
      <tr>
        <td>나이</td>
        <td><input type="text" class="form-control" id="" name="" value=""></td>
        <td>핸드폰 번호</td>
        <td><input type="text" class="form-control" id="stf_Moblphon_No" name="stf_Moblphon_No" value="${sklstfVO.stf_Moblphon_No }"></td>
        <td>집 전화번호</td>
        <td><input type="text" class="form-control" id="stf_House_Tlphon_No" name="stf_House_Tlphon_No" value="${sklstfVO.stf_House_Tlphon_No }"></td>
      </tr>
      <tr>
        <td>우편주소</td>
        <td><input type="text" class="form-control" id="stf_Post_No" name="stf_Post_No" value="${sklstfVO.stf_Post_No }"></td>
        <td>주소1</td>
        <td><input type="text" class="form-control" id="stf_Adres1" name="stf_Adres1" value="${sklstfVO.stf_Adres1 }"></td>
        <td>주소2</td>
        <td><input type="text" class="form-control" id="stf_Adres2" name="stf_Adres2" value="${sklstfVO.stf_Adres2 }"></td>
      </tr>
  </table>
    <input type="button" class="btn btn-default" onclick="go_sklstfUpdate('<%=request.getContextPath() %>')" value="수정">
    <button type="button" class="btn btn-default" onclick="go_home()">취소</button>

</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spting" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/stdnt.js"></script>
</head>
<body>
<%-- <form action="multipartFile" method="POST"enctype="multipart/form-data" name="frm"> --%>
<form method="POST" enctype="multipart/form-data" name="frm">
 <table class="table table-bordered">
      <tr>
        <td>학생 번호</td>
        <td><input type="text" class="form-control" id="st_Stdnt_No" name="st_Stdnt_No"></td>
        <td>학부</td>
        <td><input type="text" class="form-control" id="" name="" value=""></td>
        <td>학과</td>
        <td><input type="text" class="form-control" id="st_Subjct_Code" name="st_Subjct_Code" value=""></td>
      </tr>
      
      <tr>
        <td>이름</td>
        <td><input type="text" class="form-control" id="st_Nm" name="st_Nm"></td>
        <td>영문이름</td>
        <td><input type="text" class="form-control" id="st_Eng_Nm" name="st_Eng_Nm"></td>
        <td>이메일</td>
        <td><input type="text" class="form-control" id="st_Email" name="st_Email"></td>
      </tr>
      
      <tr>
        <td>비밀번호</td>
        <td><input type="text" class="form-control" id="st_Pw" name="st_Pw"></td>
        <td>비밀번화 확인</td>
        <td><input type="text" class="form-control" id="st_Pw_on" name="st_Pw_on"></td>
        <td>주민 번호</td>
        <td><input type="text" class="form-control" id="st_Ihidnum" name="st_Ihidnum" ></td>
      </tr>
      <tr>
        <td>우편주소</td>
        <td><input type="text" class="form-control" id="st_Post_No" name="st_Post_No"></td>
        <td>주소1</td>
        <td><input type="text" class="form-control" id="st_Adres1" name="st_Adres1"></td>
        <td>주소2</td>
        <td><input type="text" class="form-control" id="st_Adres2" name="st_Adres2"></td>
      </tr>
      <tr>
        <td>핸드폰 번호</td>
        <td><input type="text" class="form-control" id="st_Moblphon_No" name="st_Moblphon_No" value=""></td>
        <td>집 전화번호</td>
        <td><input type="text" class="form-control" id="st_House_Tlphon_No" name="st_House_Tlphon_No"></td>
        <td>교수 번호</td>
        <td><input type="text" class="form-control" id="st_Profsr_No" name="st_Profsr_No" ></td>
      </tr>
      <tr>
        <td>보호자 이름</td>
        <td><input type="text" class="form-control" id="st_Prtctor_Nm" name="st_Prtctor_Nm" value=""></td>
        <td>가족관계</td>
        <td><input type="text" class="form-control" id="st_Family_Relate" name="st_Family_Relate"></td>
        <td>입학일</td>
        <td><input type="text" class="form-control" id="st_Entsch_Dt" name="st_Entsch_Dt" ></td>
      </tr>
      
  </table>
		파일 경로: <input type="text" name="file"><br /> 파일경로: <input
			type="file" name="f"><br />
   <button type="button" class="btn btn-default" onclick="go_stdntInsert('<%=request.getContextPath() %>')">등록</button>
    <button type="button" class="btn btn-default" onclick="go_home()">취소</button>
  </form>
</body>
</html>
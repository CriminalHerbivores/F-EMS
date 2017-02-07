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

</head>
<body>
<%-- <form action="multipartFile" method="POST"enctype="multipart/form-data" name="frm"> --%>
<form method="POST" enctype="multipart/form-data" name="frm">
 <table class="table table-bordered">
      <tr>
        <td>교수 번호</td>
        <td><input type="text" class="form-control" id="pr_Profsr_No" name="pr_Profsr_No"></td>
        <td>학부</td>
        <td><input type="text" class="form-control" id="" name="" value=""></td>
        <td>학과</td>
        <td><input type="text" class="form-control" id="" name=""></td>
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
        <td><input type="text" class="form-control" id="pr_Pw" name="pr_Pw"></td>
        <td>비밀번화 확인</td>
        <td><input type="text" class="form-control" id="pr_Pw_on" name="pr_Pw_on"></td>
        <td>주민 번호</td>
        <td><input type="text" class="form-control" id="pr_Ihidnum" name="pr_Ihidnum" ></td>
      </tr>
      <tr>
        <td>우편주소</td>
        <td><input type="text" class="form-control" id="pr_Post_No" name="pr_Post_No"></td>
        <td>주소1</td>
        <td><input type="text" class="form-control" id="pr_Adres1" name="pr_Adres1"></td>
        <td>주소2</td>
        <td><input type="text" class="form-control" id="pr_Adres2" name="pr_Adres2"></td>
      </tr>
      <tr>
        <td>핸드폰 번호</td>
        <td><input type="text" class="form-control" id="pr_Moblphon_No" name="pr_Moblphon_No"></td>
        <td>집 전화번호</td>
        <td><input type="text" class="form-control" id="pr_House_Tlphon_No" name="pr_House_Tlphon_No"></td>
        <td>교수 번호</td>
        <td><input type="text" class="form-control" id="pr_Profsr_Tlphon_No" name="pr_Profsr_Tlphon_No" ></td>
      </tr>
      
      
  </table>
		파일 경로: <input type="text" name="file"><br /> 파일경로: <input
			type="file" name="f"><br />
   <button type="button" class="btn btn-default" onclick="go_profsrInsert('<%=request.getContextPath() %>')">등록</button>
    <button type="button" class="btn btn-default" onclick="go_home()">취소</button>
  </form>
</body>
</html>
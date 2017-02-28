<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
<h2>학생 정보 조회</h2>
 <table class="table table-bordered">
      <tr>
        <td>학생 번호</td>
        <td>${stdntVO.st_Stdnt_No}</td>
        <td>학부</td>
        <td></td>
        <td>학과</td>
        <td>${stdntVO.st_Subjct_Code}</td>
      </tr>
      
      <tr>
        <td>이름</td>
        <td>${stdntVO.st_Nm}</td>
        <td>영문이름</td>
        <td>${stdntVO.st_Eng_Nm}</td>
        <td>이메일</td>
        <td>${stdntVO.st_Email}</td>
      </tr>
      
      <tr>
        <td>비밀번호</td>
        <td>${stdntVO.st_Pw}</td>
        <td>비밀번호 확인</td>
        <td>${stdntVO.st_Pw}</td>
        <td>주민 번호</td>
        <td>${stdntVO.st_Ihidnum}</td>
      </tr>
      <tr>
        <td>우편번호</td>
        <td>${stdntVO.st_Post_No}</td>
        <td>주소</td>
        <td>${stdntVO.st_Adres1}</td>
        <td>상세주소</td>
        <td>${stdntVO.st_Adres2}</td>
      </tr>
      <tr>
        <td>핸드폰 번호</td>
        <td>${stdntVO.st_Moblphon_No}</td>
        <td>집 전화번호</td>
        <td>${stdntVO.st_House_Tlphon_No}</td>
        <td>담당 교수</td>
        <td>${stdntVO.st_Profsr_No}</td>
      </tr>
      <tr>
        <td>보호자 이름</td>
        <td>${stdntVO.st_Prtctor_Nm}</td>
        <td>가족관계</td>
        <td>${stdntVO.st_Family_Relate}</td>
        <td>입학일</td>
        <td>${stdntVO.st_Entsch_Dt}</td>
      </tr>
      
  </table>
  <!--버튼들  -->
<div id="buttons" style="float:right">
	<a href="stdntUpdate?st_Stdnt_No=${stdntVO.st_Stdnt_No}&tpage=${tpage}"> <input type="button" value="수정" class="def-btn"> </a>
	<sec:authorize access="hasAnyRole('ROLE_STF,ROLE_ADMIN')">
	<input type="button" class="def-btn" data-target="#layerpop" data-toggle="modal" value="삭제">
	<a href="stdntList?tpage=${tpage}"> <input type="button" class="def-btn" value="목록"> </a>
	</sec:authorize>
</div>
<!--모달부분  -->
<div class="modal fade" id="layerpop" >
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- header -->
      <div class="modal-header">
        <!-- 닫기(x) 버튼 -->
        <button type="button" class="close" data-dismiss="modal">×</button>
        <!-- header title -->
        <h4 class="modal-title" style="text-align: center">삭제확인</h4>
      </div>
      <!-- body -->
      <div class="modal-body" style="text-align: center">
            삭제하시겠습니까?
      </div>
      <!-- Footer -->
      <div class="modal-footer" style="text-align:center;">
        <a href="deleteStdnt?st_Stdnt_No=${stdntVO.st_Stdnt_No}&tpage=${tpage}"> <!--삭제 모달  -->
        <input type="button" class="btn btn-default" value="예">
        </a>
        <input type="button" class="btn btn-default" data-dismiss="modal" value="아니오">
      </div>
    </div>
  </div>
</div>
</body>
</html>
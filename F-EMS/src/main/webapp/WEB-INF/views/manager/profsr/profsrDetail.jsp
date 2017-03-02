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
	<h2>교수 정보 조회</h2><br/>
 <table class="def-table-full tb-border table-hover">
      <tr>
        <th>단과</th>
        <td>${profsrVO.coleg_Nm}</td>
        <th>학부</th>
        <td>${profsrVO.fc_Faculty_Nm}</td>
        <th>학과</th>
        <td>${profsrVO.sit_Subjct}</td>
      </tr>
      
      <tr>
        <th>교수 번호</th>
        <td>${profsrVO.pr_Profsr_No}</td>
        <th>이름</th>
        <td>${profsrVO.pr_Nm}</td>
        <th>영문이름</th>
        <td>${profsrVO.pr_Eng_Nm}</td>
      </tr>
      
      <tr>
        <th>재직상태</th>
        <td>${profsrVO.pr_Work}</td>
        <th>이메일</th>
        <td>${profsrVO.pr_Email}</td>
        <th>주민 번호</th>
        <td>${profsrVO.pr_Ihidnum}</td>
      </tr>
      <tr>
        <th>우편번호</th>
        <td>${profsrVO.pr_Post_No}</td>
        <th>주소</th>
        <td>${profsrVO.pr_Adres1}</td>
        <th>상세주소</th>
        <td>${profsrVO.pr_Adres2}</td>
      </tr>
      <tr>
        <th>핸드폰 번호</th>
        <td>${profsrVO.pr_Moblphon_No}</td>
        <th>집 전화번호</th>
        <td>${profsrVO.pr_House_Tlphon_No}</td>
        <th>교수 전화번호</th>
        <td>${profsrVO.pr_Profsr_Tlphon_No}</td>
      </tr>
      
  </table>
  <!--버튼들  -->
<table class="def-table-full"><tr><td style="text-align: right;">
	<a href="profsrUpdate?pr_Profsr_No=${profsrVO.pr_Profsr_No}&tpage=${tpage}"> <input type="button" value="수정" class="def-btn btn-sm btn-color""> </a>
	<sec:authorize access="hasAnyRole('ROLE_STF,ROLE_ADMIN')">
	<input type="button" class="def-btn btn-sm btn-color" data-target="#layerpop" data-toggle="modal" value="삭제">
	<a href="profsrList?&tpage=${tpage}"> <input type="button" class="def-btn btn-sm btn-color" value="목록"> </a>
	</sec:authorize>
</td></tr></table>
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
        <a href="deleteProfsr?pr_Profsr_No=${profsrVO.pr_Profsr_No}&tpage=${tpage}"> <!--삭제 모달  -->
        <input type="button" class="btn btn-default" value="예">
        </a>
        <input type="button" class="btn btn-default" data-dismiss="modal" value="아니오">
      </div>
    </div>
  </div>
</div>
</body>
</html>
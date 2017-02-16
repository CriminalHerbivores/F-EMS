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
	<h2>교수 정보 조회</h2>
 <table class="table table-bordered">
      <tr>
        <td>교수 번호</td>
        <td>${profsrVO.pr_Profsr_No}</td>
        <td>학부</td>
        <td></td>
        <td>학과</td>
        <td></td>
      </tr>
      
      <tr>
        <td>이름</td>
        <td>${profsrVO.pr_Nm}</td>
        <td>영문이름</td>
        <td>${profsrVO.pr_Eng_Nm}</td>
        <td>이메일</td>
        <td>${profsrVO.pr_Email}</td>
      </tr>
      
      <tr>
        <td>비밀번호</td>
        <td>${profsrVO.pr_Pw}</td>
        <td>비밀번호 확인</td>
        <td>${profsrVO.pr_Pw}</td>
        <td>주민 번호</td>
        <td>${profsrVO.pr_Ihidnum}</td>
      </tr>
      <tr>
        <td>우편번호</td>
        <td>${profsrVO.pr_Post_No}</td>
        <td>주소</td>
        <td>${profsrVO.pr_Adres1}</td>
        <td>상세주소</td>
        <td>${profsrVO.pr_Adres2}</td>
      </tr>
      <tr>
        <td>핸드폰 번호</td>
        <td>${profsrVO.pr_Moblphon_No}</td>
        <td>집 전화번호</td>
        <td>${profsrVO.pr_House_Tlphon_No}</td>
        <td>교수 번호</td>
        <td>${profsrVO.pr_Profsr_No}</td>
      </tr>
      
  </table>
  <!--버튼들  -->
<div id="buttons" style="float:right">
	<a href="profsrUpdate?pr_Profsr_No=${profsrVO.pr_Profsr_No}&tpage=${tpage}"> <input type="button" value="수정" class="def-btn"> </a>
	<sec:authorize access="hasAnyRole('ROLE_STF,ROLE_ADMIN')">
	<input type="button" class="def-btn" data-target="#layerpop" data-toggle="modal" value="삭제">
	<a href="profsrList?&tpage=${tpage}"> <input type="button" class="def-btn" value="목록"> </a>
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
        <a href="deleteNotice?no=${notice.nb_Bbs_No}&tpage=${tpage}"> <!--삭제 모달  -->
        <input type="button" class="btn btn-default" value="예">
        </a>
        <input type="button" class="btn btn-default" data-dismiss="modal" value="아니오">
      </div>
    </div>
  </div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 관리자 메뉴들이 포함되는 관리자 메인 JSP
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


<h2>관리자 페이지</h2>

<div class="admin-dropdown">
  <button class="admin-dropbtn">레이아웃 설정</button>
  <div class="admin-dropdown-content">
    <a href="<%=request.getContextPath()%>/admin/step1Add">대학 정보 설정</a>
    <a href="<%=request.getContextPath()%>/admin/step2Add">메뉴 사용 설정</a>
    <a href="<%=request.getContextPath()%>/admin/step3Add">레이아웃 선택</a>
    <a href="<%=request.getContextPath()%>/admin/step4Add">컬러 테마 설정</a>
  </div>
 </div> 
  <br/>

  <div class="admin-dropdown">
   <button class="admin-dropbtn">관리자/직원 관리</button>
  <div class="admin-dropdown-content">
    <a href="<%=request.getContextPath()%>/admin/sklstfList">직원 조회</a>
    <a href="<%=request.getContextPath()%>/admin/sklstfInsert">직원 등록</a>
    <a href="<%=request.getContextPath()%>/admin/sklstfAtrtyList">관리자 설정</a>
  </div>
</div>
<br/>

  <div class="admin-dropdown">
   <button class="admin-dropbtn">강의실 관리</button>
  <div class="admin-dropdown-content">
    <a href="<%=request.getContextPath()%>/admin/buildingInsert">건물 등록</a>
    <a href="<%=request.getContextPath()%>/admin/buildingUpdate">건물 수정</a>
    <a href="<%=request.getContextPath()%>/admin/lctrumInsert">강의실 등록</a>
    <a href="<%=request.getContextPath()%>/admin/lctrumUpdate">강의실 수정</a>
    <a href="<%=request.getContextPath()%>/admin/lctrumUseUpdate">강의실 설정</a>
  </div>
</div>
<br/>

  <div class="admin-dropdown">
   <button class="admin-dropbtn">학부·학과 관리</button>
  <div class="admin-dropdown-content">
    <a href="<%=request.getContextPath()%>/admin/subjectInsert">학부·학과 등록</a>
    <a href="<%=request.getContextPath()%>/adminsubjectUpdate">학부·학과 수정</a>
    <a href="<%=request.getContextPath()%>/admin/subjectUseUpdate">학부·학과 설정</a>
  </div>
</div>
<br/>

  <div class="admin-dropdown">
   <button class="admin-dropbtn">강의 관리</button>
  <div class="admin-dropdown-content">
    <a href="#">상대평가 설정</a>
  </div>
</div>
<br/>

  <div class="admin-dropdown">
   <button class="admin-dropbtn">게시판 관리</button>
  <div class="admin-dropdown-content">
    <a href="#">메뉴1</a>
    <a href="#">메뉴2</a>
  </div>
</div>
<br/>


</body>
</html>
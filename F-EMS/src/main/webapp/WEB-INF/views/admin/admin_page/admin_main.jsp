<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>


<h2>관리자 페이지</h2>

<div class="dropdown">
  <button class="dropbtn">레이아웃 설정</button>
  <div class="dropdown-content">
    <a href="<%=request.getContextPath()%>/admin/step1_modify">대학 정보 설정</a>
    <a href="<%=request.getContextPath()%>/admin/step2_modify">메뉴 사용 설정</a>
    <a href="<%=request.getContextPath()%>/admin/step3_modify">레이아웃 선택</a>
    <a href="<%=request.getContextPath()%>/admin/step4_modify">컬러 테마 설정</a>
  </div>
 </div> 
  <br/>

  <div class="dropdown">
   <button class="dropbtn">관리자/직원 관리</button>
  <div class="dropdown-content">
    <a href="#">직원 조회</a>
    <a href="#">직원 등록</a>
    <a href="#">관리자 설정</a>
  </div>
</div>
<br/>

  <div class="dropdown">
   <button class="dropbtn">강의실 관리</button>
  <div class="dropdown-content">
    <a href="<%=request.getContextPath()%>/admin/add_building">건물 등록</a>
    <a href="<%=request.getContextPath()%>/admin/modify_building">건물 수정</a>
    <a href="<%=request.getContextPath()%>/admin/add_classroom">강의실 등록</a>
    <a href="<%=request.getContextPath()%>/admin/modify_classroom">강의실 수정</a>
    <a href="<%=request.getContextPath()%>/admin/set_classroom">강의실 설정</a>
  </div>
</div>
<br/>

  <div class="dropdown">
   <button class="dropbtn">학부·학과 관리</button>
  <div class="dropdown-content">
    <a href="<%=request.getContextPath()%>/admin/add_subject">학부·학과 등록</a>
    <a href="<%=request.getContextPath()%>/admin/modify_subject">학부·학과 수정</a>
    <a href="<%=request.getContextPath()%>/admin/set_subject">학부·학과 설정</a>
  </div>
</div>
<br/>

  <div class="dropdown">
   <button class="dropbtn">강의 관리</button>
  <div class="dropdown-content">
    <a href="#">상대평가 설정</a>
  </div>
</div>
<br/>

  <div class="dropdown">
   <button class="dropbtn">게시판 관리</button>
  <div class="dropdown-content">
    <a href="#">메뉴1</a>
    <a href="#">메뉴2</a>
  </div>
</div>
<br/>


</body>
</html>
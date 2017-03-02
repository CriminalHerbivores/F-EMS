<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

</head>
<body>
<table>
<tr>
<td>
<h2><a href="<%=request.getContextPath() %>/sample">jsp 샘플 보기</a></h2><br/>
<h2><a href="<%=request.getContextPath() %>/cssExample">CSS 예시 보기</a></h2><br/>
※ 각각 메뉴에 반영하고 싶은 url 및 메뉴 이름(순서 맞춰서) 해당영역에 넣어두면 데코레이터에 반영 ※<br/>
--------- 기타 ---------<br/>
<a href="<%=request.getContextPath() %>/index">메인으로 가기</a><br/>
--------- 직원 ---------<br/>
<a href="<%=request.getContextPath() %>/sklstf/sklstfUpdate" class="no-uline">직원 정보 수정</a><br/>
<a href="<%=request.getContextPath() %>/sklstf/stdntInsert" class="no-uline">학생 등록</a><br/>
<a href="<%=request.getContextPath() %>/sklstf/stdntList" class="no-uline">학생 관리</a><br/>
<a href="<%=request.getContextPath() %>/sklstf/sknrgListForm" class="no-uline">학적 관리</a><br/>
<a href="<%=request.getContextPath() %>/sklstf/profsrInsert" class="no-uline">교수 등록</a><br/>
<a href="<%=request.getContextPath() %>/sklstf/profsrList" class="no-uline">교수 관리</a><br/>
<a href="<%=request.getContextPath() %>/sklstf/profsrLctreList" class="no-uline">교수 이력 관리</a><br/>
<a href="<%=request.getContextPath() %>/sklstf/tuitionList">등록금 조회</a><br/>
<a href="<%=request.getContextPath() %>/sklstf/stdTuitionList">등록금 내역 조회</a><br/>
<a href="<%=request.getContextPath() %>/sklstf/schlshipInsert" class="no-uline">장학금 등록</a><br/>
<a href="<%=request.getContextPath() %>/sklstf/schlshipList" class="no-uline">장학금 관리</a><br/>
<a href="<%=request.getContextPath() %>/sklstf/requestschlship" class="no-uline">장학금 신청 내역</a><br/>
<a href="<%=request.getContextPath() %>/sklstf/stdntBrhs" class="no-uline">기숙사 관리</a><br/>
--------- 교수 ---------<br/>
<a href="<%=request.getContextPath() %>/profsr/profsrDetail" class="no-uline">교수 정보 조회</a><br/>
<a href="<%=request.getContextPath() %>/profsr/profsrUpdate" class="no-uline">교수 정보 수정</a><br/>
<a href="<%=request.getContextPath() %>/profsr/requestLctre" class="no-uline">강의 등록 요청</a><br/>
<a href="<%=request.getContextPath() %>/profsr/openLctreList" class="no-uline">개설 강의 조회</a><br/>
<a href="<%=request.getContextPath() %>/profsr/ongoingLctreList" class="no-uline">진행 강의 조회</a><br/>
--------- 학생 ---------<br/>
<a href="<%=request.getContextPath() %>/stdnt/stdntDetail" class="no-uline">학생 정보 조회</a><br/>
<a href="<%=request.getContextPath() %>/stdnt/stdntUpdate" class="no-uline">학생 정보 수정</a><br/>
<a href="<%=request.getContextPath() %>/stdnt/sknrgsList" class="no-uline">학적 조회</a><br/>
<a href="<%=request.getContextPath() %>/stdnt/viewGrade" class="no-uline">성적 조회</a><br/>
<a href="<%=request.getContextPath() %>/stdnt/fromStdTuition" class="no-uline">등록금 조회</a><br/>
<a href="<%=request.getContextPath() %>/stdnt/schlshipList" class="no-uline">장학금 조회</a><br/>
<a href="<%=request.getContextPath() %>/stdnt/atBrhs" class="no-uline">기숙사 조회</a><br/>
--------- 학사 ---------<br/>
<a href="<%=request.getContextPath() %>/notice_bbs/noticeList" class="no-uline">공지 게시판</a><br/>
<a href="<%=request.getContextPath() %>/schafs_schdul/schdulList" class="no-uline">학사 일정</a><br/>
--------- 수강신청 ---------<br/>
<a href="<%=request.getContextPath() %>/course/courseList">수강신청목록</a><br/>
--------- 강의 ---------<br/>
<a href="<%=request.getContextPath() %>/lctre/lctreList">강의목록</a><br/>
<a href="<%=request.getContextPath() %>/lctre/noticeList">공지게시판</a><br/>
<a href="<%=request.getContextPath() %>/lctre/fileList">자료게시판</a><br/>
<a href="<%=request.getContextPath() %>/lctre/qnaList">질의응답 게시판</a><br/>
<a href="<%=request.getContextPath() %>/lctre/hwList">과제 게시판</a><br/>
<a href="<%=request.getContextPath() %>/lctre/mediaList">동영상 게시판</a><br/>
<a href="<%=request.getContextPath() %>/lctre/attendList">시청 여부 게시판</a><br/>
--------- 커뮤니티 ---------<br/>
--------- 관리자 ---------<br/>
<a href="<%=request.getContextPath() %>/adminJoin">관리자 가입</a><br/>
<a href="<%=request.getContextPath() %>/lgLogin">로그인형</a><br/>
<a href="<%=request.getContextPath() %>/lgMulti">복합형</a><br/>
<a href="<%=request.getContextPath() %>/lgBoard">게시판형</a><br/>
<a href="<%=request.getContextPath() %>/lgMenu">메뉴강조형</a><br/>
<a href="<%=request.getContextPath() %>/admin/eventHandler">일정 관리</a><br/>
--------- 임시 ---------<br/>

</td>
</tr>
</table>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
* <pre>
* 상단 메뉴
* </pre>
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 3. 3.      JAR      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!-- 상단메뉴 시작 -->
	<nav class="navbar custom-navbar-inverse">
		<div class="container-fluid top-menu" style="padding-left: 11.5%;">
	 		<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-left">
					<!-- 권한 관련 추후에 설정 -->
					<sec:authorize access="hasAnyRole('ROLE_STF,ROLE_ADMIN')">
						<div class="menu-dropdown">
							<button class="menu-dropbtn">
								<a href="#">직원</a>
							</button>
							<div class="menu-dropdown-content">
<a href="<%=request.getContextPath() %>/sklstf/sklstfUpdate" class="no-uline">직원 정보 수정</a>
<a href="<%=request.getContextPath() %>/sklstf/stdntInsert" class="no-uline">학생 등록</a>
<a href="<%=request.getContextPath() %>/sklstf/stdntList" class="no-uline">학생 관리</a>
<a href="<%=request.getContextPath() %>/sklstf/sknrgListForm" class="no-uline">학적 관리</a>
<a href="<%=request.getContextPath() %>/sklstf/profsrInsert" class="no-uline">교수 등록</a>
<a href="<%=request.getContextPath() %>/sklstf/profsrList" class="no-uline">교수 관리</a>
<a href="<%=request.getContextPath() %>/sklstf/profsrLctreList" class="no-uline">교수 이력 관리</a>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="<%=request.getContextPath() %>/admin/tuitionList">등록금 조회</a>
</sec:authorize>
<a href="<%=request.getContextPath() %>/sklstf/stdTuitionList">등록금 내역 조회</a>
<a href="<%=request.getContextPath() %>/sklstf/schlshipInsert" class="no-uline">장학금 등록</a>
<a href="<%=request.getContextPath() %>/sklstf/schlshipList" class="no-uline">장학금 관리</a>
<a href="<%=request.getContextPath() %>/sklstf/requestschlship" class="no-uline">장학금 신청 내역</a>
<a href="<%=request.getContextPath() %>/sklstf/stdntBrhs" class="no-uline">기숙사 관리</a>
							</div>
						</div>
					</sec:authorize>

					<sec:authorize access="hasRole('ROLE_PRO')">
						<div class="menu-dropdown">
							<button class="menu-dropbtn">
								<a href="#">교수</a>
							</button>
							<div class="menu-dropdown-content">
<a href="<%=request.getContextPath() %>/profsr/profsrDetail" class="no-uline">교수 정보 조회</a>
<a href="<%=request.getContextPath() %>/profsr/profsrUpdate" class="no-uline">교수 정보 수정</a>
<a href="<%=request.getContextPath() %>/profsr/requestLctre" class="no-uline">강의 등록 요청</a>
<a href="<%=request.getContextPath() %>/profsr/openLctreList" class="no-uline">개설 강의 조회</a>
<a href="<%=request.getContextPath() %>/profsr/ongoingLctreList" class="no-uline">진행 강의 조회</a>
							</div>
						</div>
					</sec:authorize>

					<sec:authorize access="hasRole('ROLE_STD')">
						<div class="menu-dropdown">
							<button class="menu-dropbtn">
								<a href="#">학생</a>
							</button>
							<div class="menu-dropdown-content">
<a href="<%=request.getContextPath() %>/stdnt/stdntDetail" class="no-uline">학생 정보 조회</a>
<a href="<%=request.getContextPath() %>/stdnt/stdntUpdate" class="no-uline">학생 정보 수정</a>
<a href="<%=request.getContextPath() %>/stdnt/sknrgsList" class="no-uline">학적 조회</a>
<a href="<%=request.getContextPath() %>/stdnt/viewGrade" class="no-uline">성적 조회</a>
<a href="<%=request.getContextPath() %>/stdnt/fromStdTuition" class="no-uline">등록금 조회</a>
<a href="<%=request.getContextPath() %>/stdnt/schlshipList" class="no-uline">장학금 조회</a>
<a href="<%=request.getContextPath() %>/stdnt/atBrhs" class="no-uline">기숙사 조회</a>
							</div>
						</div>
					</sec:authorize>
					<!-- 여기까지 -->


					<div class="menu-dropdown">
						<button class="menu-dropbtn">
							<a href="#">학사</a>
						</button>
						<div class="menu-dropdown-content">
<a href="<%=request.getContextPath() %>/notice_bbs/noticeList" class="no-uline">공지 게시판</a>
<a href="<%=request.getContextPath() %>/schafs_schdul/schdulList" class="no-uline">학사 일정</a>
<c:if test="${not empty noticeBBS}">
<c:forEach items="${noticeBBS}" var="bbs">
<a href="<%=request.getContextPath() %>/bbs_gnt/bbsList?bl_Bbs_No=${bbs.bl_Bbs_No}">${bbs.bl_Bbs_Nm}</a>
</c:forEach>
</c:if>
						</div>
					</div>

					<sec:authorize access="isAuthenticated()">
						<div class="menu-dropdown">
							<button class="menu-dropbtn">
								<a href="#">수강신청</a>
							</button>
							<div class="menu-dropdown-content">
<a href="<%=request.getContextPath()%>/course/courseList">수강신청목록</a>
							</div>
						</div>
					</sec:authorize>

					<sec:authorize access="isAuthenticated()">
						<div class="menu-dropdown">
							<button class="menu-dropbtn">
								<a href="#">강의</a>
							</button>
							<div class="menu-dropdown-content">
<a href="<%=request.getContextPath()%>/lctre/lctreList">강의목록</a>
<a href="<%=request.getContextPath()%>/lctre/noticeList?table_Nm=test">공지</a>
<a href="<%=request.getContextPath()%>/lctre/dateList?table_Nm=test">자료</a>
<a href="<%=request.getContextPath()%>/lctre/taskList?table_Nm=test">과제</a>
<a href="<%=request.getContextPath()%>/lctre/qnaList?table_Nm=test">질의응답</a>
<sec:authorize access="hasRole('ROLE_PRO')">
<a href="<%=request.getContextPath()%>/lctre/videoList?table_Nm=test">동영상 강의</a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_STD')">
<a href="<%=request.getContextPath()%>/lctre/video_StdntList?table_Nm=test">동영상 강의</a>
</sec:authorize>
<a href="<%=request.getContextPath()%>/lctre/testList">온라인 시험</a>
							</div>
						</div>
					</sec:authorize>
					
					<c:if test="${not empty bbsList}">
					
					<div class="menu-dropdown">
						<button class="menu-dropbtn">
							<a href="#">커뮤니티</a>
						</button>
						<div class="menu-dropdown-content">
<c:forEach items="${bbsList}" var="bbs">
<a href="<%=request.getContextPath() %>/bbs_gnt/bbsList?bl_Bbs_No=${bbs.bl_Bbs_No}">${bbs.bl_Bbs_Nm}</a>
</c:forEach>
						</div>
					</div>
					
					</c:if>
					
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<div class="menu-dropdown">
							<button class="menu-dropbtn">
								<a href="#" onclick="op_menu_admin()">관리자</a>
							</button>
							<div class="menu-dropdown-content">
<a href="<%=request.getContextPath() %>/admin/main">관리자 페이지</a>								
<a href="<%=request.getContextPath() %>/adminJoin">관리자 가입</a>
<a href="<%=request.getContextPath() %>/lgLogin">로그인형</a>
<a href="<%=request.getContextPath() %>/lgMulti">복합형</a>
<a href="<%=request.getContextPath() %>/lgBoard">게시판형</a>
<a href="<%=request.getContextPath() %>/lgMenu">메뉴강조형</a>
<a href="<%=request.getContextPath() %>/admin/eventHandler">일정 관리</a>
<a href="<%=request.getContextPath() %>/bbs_list/generator" class="no-uline">게시판 생성</a>
							</div>
						</div>
					</sec:authorize>
					<c:if test="${not empty loginUser}">
					<c:if test="${loginUser eq 'baskin'}">
					<div class="menu-dropdown">
						<button class="menu-dropbtn">
							<a href="#">31</a>
						</button>
						<div class="menu-dropdown-content">
							<a href="<%=request.getContextPath()%>/baskin/robbins">베스킨 라빈스</a>
						</div>
					</div>
					</c:if>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
<!-- 상단 메뉴 끝 -->

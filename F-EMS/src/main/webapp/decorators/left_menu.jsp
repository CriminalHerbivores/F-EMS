<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
* <pre>
* 좌측 메뉴
* </pre>
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 3. 3.      JAR      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

	<!-- 좌측메뉴 시작 -->
	

<div class="custom-col-sm-2 sidenav">
	<div>
		<!-- ////////////////// -->
		<ul class="accordion-menu" id="accordionMenu1">
			<sec:authorize access="hasAnyRole('ROLE_STF,ROLE_ADMIN')">
				<li data-extension="close">
					<div class="main-title">
						<span class="folder main_menu"></span><a href="#">직원</a>
					</div>
					<ul class="sub sub_meun">
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/sklstfUpdate" class="no-uline">직원 정보 수정</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/stdntInsert" class="no-uline">학생 등록</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/stdntList" class="no-uline">학생 관리</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/profsrInsert" class="no-uline">교수 등록</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/profsrList" class="no-uline">교수 관리</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/stdnt_ProfsrForm" class="no-uline">학생 교수 배정</a></li></div>
					</ul>
				</li>
				<li data-extension="close">
					<div class="main-title">
						<span class="folder main_menu"></span><a href="#">학교</a>
					</div>
					<ul class="sub sub_meun">
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/sknrgListForm" class="no-uline">학적 관리</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/profsrRequestLectre" class="no-uline">개설 강의</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/profsrLctreList" class="no-uline">강의 조회</a></li></div>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/admin/tuitionList">등록금 조회</a></li></div>
</sec:authorize>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/stdTuitionList">등록금 내역</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/schlshipInsert" class="no-uline">장학금 등록</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/schlshipList" class="no-uline">장학금 관리</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/requestschlship" class="no-uline">장학금 내역</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/stdntBrhs" class="no-uline">기숙사 관리</a></li></div>
					</ul>
				</li>
			</sec:authorize>

			<sec:authorize access="hasRole('ROLE_PRO')">
				<li>
					<div class="main-title">
						<span class="folder main_menu"> </span><a href="#">교수</a>
					</div>
					<ul class="sub sub_meun">
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/profsr/profsrDetail" class="no-uline">교수 정보 조회</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/profsr/profsrUpdate" class="no-uline">교수 정보 수정</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/profsr/requestLctre" class="no-uline">강의 등록 요청</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/profsr/openLctreList" class="no-uline">개설 강의 조회</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/profsr/ongoingLctreList" class="no-uline">진행 강의 조회</a></li></div>
					</ul>
				</li>
			</sec:authorize>

			<sec:authorize access="hasRole('ROLE_STD')">
				<li>
					<div class="main-title">
						<span class="folder main_menu"> </span><a href="#">학생</a>
					</div>
					<ul class="sub sub_meun">
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/stdnt/stdntDetail" class="no-uline">학생 정보 조회</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/stdnt/stdntUpdate" class="no-uline">학생 정보 수정</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/stdnt/sknrgsList" class="no-uline">학적 조회</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/stdnt/viewGrade" class="no-uline">성적 조회</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/stdnt/fromStdTuition" class="no-uline">등록금 조회</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/stdnt/schlshipList" class="no-uline">장학금 조회</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/stdnt/atBrhs" class="no-uline">기숙사 조회</a></li></div>
					</ul>
				</li>
			</sec:authorize>

			<li>
				<div class="main-title">
					<span class="folder main_menu"> </span><a href="#">학사</a>
				</div>
				<ul class="sub sub_meun">
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/notice_bbs/noticeList">공지게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/schafs_schdul/schdulList" class="no-uline">학사 일정</a></li></div>
<c:if test="${not empty noticeBBS}">
<c:forEach items="${noticeBBS}" var="bbs">
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/bbs_gnt/bbsList?bl_Bbs_No=${bbs.bl_Bbs_No}">${bbs.bl_Bbs_Nm}</a></li></div>
</c:forEach>
</c:if>
				</ul>
			</li>

			<sec:authorize access="isAuthenticated()">
				<li>
					<div class="main-title">
						<span class="folder main_menu"> </span><a href="<%=request.getContextPath()%>/course/courseList">수강신청</a>
					</div>
					<ul class="sub sub_meun">
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/course/courseList">수강신청목록</a></li></div>
					</ul>
				</li>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<li>
					<div class="main-title">
						<span class="folder main_menu"> </span><a href="<%=request.getContextPath()%>/lctre/lctreList">강의</a>
					</div>
					<ul class="sub sub_meun">
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/lctreList">강의목록</a></li></div>
<%-- <div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/noticeList?table_Nm=test"">공지게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/dateList?table_Nm=test">자료게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/qnaList?table_Nm=test">질의응답게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/taskList?table_Nm=test">과제 게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/videoList?table_Nm=test">동영상게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/video_StdntList?table_Nm=test">시청여부 게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/testList">온라인 시험 게시판</a></li></div> --%>
					</ul>
				</li>
			</sec:authorize>
						
			<c:if test="${not empty bbsList}">
				<li>
					<div class="main-title">
						<span class="folder main_menu"> </span><a href="#">커뮤니티</a>
					</div>
					<ul class="sub sub_meun">
<c:forEach items="${bbsList}" var="bbs">
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/bbs_gnt/bbsList?bl_Bbs_No=${bbs.bl_Bbs_No}">${bbs.bl_Bbs_Nm}</a></li></div>
</c:forEach>
					</ul>
				</li>
			</c:if>
						
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li>
					<div class="main-title">
						<span class="folder main_menu"> </span><a href="#">관리자</a>
					</div>
					<ul class="sub sub_meun">
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/admin/main">대학 정보</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/admin/generatorList">게시판 관리</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/admin/sklstfList">직원 관리</a></li></div>								
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/admin/eventHandler">학교 관리</a></li></div>
					</ul>
				</li>
			</sec:authorize>
		</ul>
	</div>
</div>
<!-- ////////////////// -->

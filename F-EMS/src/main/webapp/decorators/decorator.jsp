<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%--
 * <pre>
 * 상단바, 상단메뉴, 좌측메뉴, Footer, js, css를 포함하는 JSP
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH        최초작성
 * 2017.01.30      KJH        추가작성 
 * 2017.02.10      KJH        추가작성
 * 2017.02.16      KJH        dynamicCSS
 * Copyright (c) 2017 by DDIT All right reserved
 --%>


<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 1L);
%>


<!DOCTYPE html>
<html>
<head>
<title>${manageVO.mng_Univ_Nm}<decorator:title /></title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<decorator:head />
</head>
<body>

	<!-- 상단바 시작 -->
	<nav class="navbar top-navbar-inverse" id="topnav">
		<div id="toptable"><!-- class="container-fluid" -->
			<div class="navbar-header" style="width: 100%;">
				<table id="topnav-table" style="width: 100%;">
					<tr style="width: 900px;">
					
						<td><a href="<%=request.getContextPath()%>/"> <img
								src="<%=request.getContextPath()%>${manageVO.mng_Univ_Logo}"
								id="logo"></a></td>
				</table> 
				
				
				<div class="float-right">
					<c:choose>
						<c:when test="${empty loginUser}">
							<input class="def-btn btn-sm btn-color" type="button" value="31"
								onclick="login_baskin();" />&nbsp;&nbsp;
							<input class="def-btn btn-sm btn-color" type="button" value="관리자"
								onclick="login_admin();" />&nbsp;&nbsp;
		<input class="def-btn btn-sm btn-color" type="button" value="직원"
								onclick="login_staff();" />&nbsp;&nbsp;
		<input class="def-btn btn-sm btn-color" type="button" value="교수"
								onclick="login_professor();" />&nbsp;&nbsp;
		<input class="def-btn btn-sm btn-color" type="button" value="학생"
								onclick="login_student();" />&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/loginForm" class="no-uline"><button
									class="def-btn">Login</button></a>&nbsp;&nbsp;
				</c:when>
						<c:otherwise>
							<span>${loginUser}</span>&nbsp;&nbsp;
				<a href="<%=request.getContextPath()%>/logout"><button
									class="def-btn float-right">Logout</button></a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</nav>
	<!-- 상단바 끝 --> 


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
<a href="<%=request.getContextPath() %>/sklstf/tuitionList">등록금 조회</a>
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
<a href="<%=request.getContextPath() %>/bbs_list/generator" class="no-uline">게시판 생성</a>	
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
<a href="<%=request.getContextPath()%>/lctre/noticeList?table_Nm=test">공지게시판</a>
<a href="<%=request.getContextPath()%>/lctre/dateList?table_Nm=test">자료게시판</a>
<a href="<%=request.getContextPath()%>/lctre/qnaList?table_Nm=test">질의응답게시판</a>
<a href="<%=request.getContextPath()%>/lctre/taskList?table_Nm=test">과제게시판</a>
<a href="<%=request.getContextPath()%>/lctre/videoList?table_Nm=test">동영상게시판</a>
<a href="<%=request.getContextPath()%>/lctre/attendList?table_Nm=test">시청여부 게시판</a>
<a href="<%=request.getContextPath()%>/lctre/testList">온라인 시험 게시판</a>
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
<a href="<%=request.getContextPath() %>/adminJoin">관리자 가입</a>
<a href="<%=request.getContextPath() %>/lgLogin">로그인형</a>
<a href="<%=request.getContextPath() %>/lgMulti">복합형</a>
<a href="<%=request.getContextPath() %>/lgBoard">게시판형</a>
<a href="<%=request.getContextPath() %>/lgMenu">메뉴강조형</a>
<a href="<%=request.getContextPath() %>/admin/eventHandler">일정 관리</a>
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



	<!-- 좌측메뉴 시작 -->
	
	<div class="container-fluid-side-menu">
		<div class="row content">

	<c:if test="${manageVO.mng_Left_Menu_Use_Ennc=='y'||'Y'}">
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
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/sknrgListForm" class="no-uline">학적 관리</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/profsrInsert" class="no-uline">교수 등록</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/profsrList" class="no-uline">교수 관리</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/profsrLctreList" class="no-uline">교수 이력 관리</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/tuitionList">등록금 조회</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/stdTuitionList">등록금 내역 조회</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/schlshipInsert" class="no-uline">장학금 등록</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/schlshipList" class="no-uline">장학금 관리</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/requestschlship" class="no-uline">장학금 신청 내역</a></li></div>
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
									<span class="folder main_menu"> </span><a href="#">수강신청</a>
								</div>
								<ul class="sub sub_meun">
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/course/courseList">수강신청목록</a></li></div>
								</ul>
							</li>
						</sec:authorize>

						<sec:authorize access="isAuthenticated()">
							<li>
								<div class="main-title">
									<span class="folder main_menu"> </span><a href="#">강의</a>
								</div>
								<ul class="sub sub_meun">
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/lctreList">강의목록</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/noticeList?table_Nm=test"">공지게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/dateList?table_Nm=test">자료게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/qnaList?table_Nm=test">질의응답게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/taskList?table_Nm=test">과제 게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/videoList?table_Nm=test">동영상게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/attendList?table_Nm=test">시청여부 게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/testList">온라인 시험 게시판</a></li></div>
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
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/adminJoin">관리자 가입</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/lgLogin">로그인형</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/lgMulti">복합형</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/lgBoard">게시판형</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/lgMenu">메뉴강조형</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/admin/eventHandler">일정 관리</a></li></div>
								</ul>
							</li>
						</sec:authorize>
					</ul>
				</div>
			</div>
			<!-- ////////////////// -->
			</c:if>
			

	<c:choose>
	<c:when test="${manageVO.mng_Left_Menu_Use_Ennc=='y'||'Y'}">
			<div class="custom-col-sm-8 sidenav text-left">
				<decorator:body />
				</div>
		</c:when>
	<c:otherwise>
			<div class="custom-col-sm-10 sidenav text-left">
			<decorator:body />
			</div>
		</c:otherwise>	
		</c:choose>	
				
		</div>
	</div>

	<!-- 좌측메뉴 끝 -->

	<!-- Footer 시작 -->
	<!-- <footer class="footer container-fluid text-center"> -->
	<footer class="footer text-center">
		<p>${manageVO.mng_Post_No}&nbsp;&nbsp;${manageVO.mng_Adres1}&nbsp;${manageVO.mng_Adres2}&nbsp;|&nbsp;Tel:${manageVO.mng_Tlphon_No}&nbsp;|&nbsp;Fax:${manageVO.mng_Fax_No}</p>
		<p>Copyright (C)&nbsp;${manageVO.mng_Cpyr }&nbsp;All Rights
			Reserved.</p>

	</footer>
	<!-- Footer 끝 -->


</body>


<!--  ============= css =============  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/accordion.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/board.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/course.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/layout_setup.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/main.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/menu.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/scheduler.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/w3.css">

<!-- Calendar -->
<%-- <link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/examples-offline.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/kendo.common.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/kendo.rtl.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/kendo.default.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/kendo.default.mobile.min.css"> --%>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/calendarstyle.css">
	
<!--  ============= css =============  -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/dynamicCss/menu.do" />

<!--alert css  -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/sweetalert.css">	

<!--  ============= js =============  -->
	
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/accordion.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.easing.1.3.js"></script>
	<!--  ============= js ============= 
<%-- <script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script> --%>
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->



<!-- //////////////////////////////////// -->

<!-- calendar js  -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/calendarscript.js"></script>


<!--alert js  -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/sweetalert.min.js"></script>


<!-- ssh 추가 -->	
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jszip.min.js"></script>
<%-- <script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/kendo.all.min.js"></script> --%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/console.js"></script>


<script src="<%=request.getContextPath()%>/resources/js/answer.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/atrty.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/atrty.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/attendance.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bbs_atrty.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bbs_flpth.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bbs_list.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/building.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/chatting.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/cnslt_bbs.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/colege.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/compl_pnt.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/consultation.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/faculty.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/files.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/grade.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/intrst_list.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/kind.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/lctre.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/lctre_actpln.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/lctre_flpth.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/lctre_unq_no.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/lctrum.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/manage.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/menu.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/menu_se.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/notice_bbs.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/profsr.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/profsr_schedl.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/profsr_subjct_asnm.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/pymnt.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/reqst.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/schafs_schdul.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/schlship.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/sklstf.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/sklstf_atrty.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/sknrgs.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/stdnt.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/subjct_info_table.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/test.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/test_paper.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/tuition.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/use.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/users.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/work.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/member.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bbs_gnt.js"></script>
<!-- //////////////////////////////////// -->


</html>

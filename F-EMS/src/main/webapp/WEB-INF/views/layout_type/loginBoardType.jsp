<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%--
 * <pre>
 * 레이아웃 중 게시판형 로그인화면 JSP
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
<meta charset=UTF-8">
<title></title>
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



<form id="" method="post" name="formm">


	<div class="container-fluid">
		<div class="row content">
			
			<div class="custom-col-sm-4 sidenav">
			
			<table class="def-table-full out-border">
			<!-- <form action="login" id="loginForm" method="post"> -->
				<tr><td>
<input type="hidden" name="returl" value="${param.returl }" />
<input type="text" class="def-input-text-md custom-form-control" name="userid" placeholder="아이디" value="${param.userid }"/></td>
					<td rowspan="2">
					<input type="submit" class="def-btn btn-lg btn-color" value="로그인"></td></tr>
				<tr><td><input type="password" class="def-input-text-md custom-form-control" name="password" placeholder="패스워드"></td></tr>
				<!-- <tr><td colspan="2"><span id='change'>여기 아작스</span></td></tr> -->
<!-- </form> -->
		<tr><td><input type="button" class="def-btn btn-sm btn-color" value="ID찾기" onclick="modal_find_id()"></td><td><input type="button" class="def-btn btn-sm btn-color" value="PW찾기" onclick="modal_find_pw()"></td></tr>
			</table>
			<div>
<br/>
			<table class="def-table-full tb-border"><tr><td>
			스케쥴러
			</td></tr></table>
			</div>
			</div>
			
			<div class="custom-col-sm-6 sidenav text-left">
			<table class="def-table-full tb-border">
				<tr><td>
				
				<table class="def-table-full tb-border table-hover">
			<tr><th>공지사항</th></tr>
			<tr><td>공지 게시글...........5</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........4</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........3</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........2</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........1</td><td>2017-02-10</td></tr>
		</table>
				
				</td><td>
					<table class="def-table-full tb-border table-hover">
			<tr><th>공지사항</th></tr>
			<tr><td>공지 게시글...........5</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........4</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........3</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........2</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........1</td><td>2017-02-10</td></tr>
		</table>
				</td></tr>
				<tr><td>
				<table class="def-table-full tb-border table-hover">
			<tr><th>공지사항</th></tr>
			<tr><td>공지 게시글...........5</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........4</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........3</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........2</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........1</td><td>2017-02-10</td></tr>
		</table>
				</td><td>
				<table class="def-table-full tb-border table-hover">
			<tr><th>공지사항</th></tr>
			<tr><td>공지 게시글...........5</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........4</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........3</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........2</td><td>2017-02-10</td></tr>
			<tr><td>공지 게시글...........1</td><td>2017-02-10</td></tr>
		</table>
				</td></tr>
			</table>
			
	</div></div>
	</div>

</form>
<!-- Footer 시작 -->
	<footer class="footer container-fluid text-center">
		<p>Footer Text</p>
	</footer>
	<!-- Footer 끝 -->

</body>
</html>
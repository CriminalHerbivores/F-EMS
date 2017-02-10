<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>
</title>
</head>
<body>

<!-- 상단바 시작 -->
	<nav class="navbar top-navbar-inverse" id="topnav">
		<div class="container-fluid" id="toptable">
			<div class="navbar-header" style="width: 100%;">
				<table id="topnav-table">
					<tr>
						<td><a href="<%=request.getContextPath()%>/"><img
								src="<%=request.getContextPath()%>/resources/images/uni_logo.png"
								id="logo"></a></td>
						<td></td>
					</tr>
				</table>

				<!-- 로그인한 사용자 정보 받아오는건 추후에 쿼리로 받아오거나 해야함 -->

				<a href="<%=request.getContextPath()%>/logout"><button
						class="def-btn float-right">Logout</button></a>
			</div>
		</div>
	</nav>
	<!-- 상단바 끝 -->


	<!-- 상단메뉴 시작 -->
	<nav class="navbar custom-navbar-inverse">
		<div class="container-fluid top-menu" style="padding-left:18.5%;">
			<div class="collapse navbar-collapse" id="myNavbar">

				<ul class="nav navbar-nav navbar-left">

					<!-- 권한 관련 추후에 설정 -->
					<div class="menu-dropdown">
						<button class="menu-dropbtn"><a href="#">직원</a></button>
							<div class="menu-dropdown-content">
							<a href="<%=request.getContextPath() %>/sklstf/sklstfUpdate" class="no-uline">직원 정보 수정</a>
							<a href="<%=request.getContextPath() %>/stdnt/stdntInsert" class="no-uline">학생 등록 </a>
							<a href="<%=request.getContextPath() %>/stdnt/stdntList" class="no-uline">학생 조회 </a>
							<a href="<%=request.getContextPath() %>/stdnt/sknrgListForm" class="no-uline">학적 관리 </a>
							<a href="<%=request.getContextPath() %>/schlship/schlshipList" class="no-uline">장학금 양식</a>
							<a href="#" class="no-uline">메뉴1 </a>
							</div>
						</div>

					<div class="menu-dropdown">
						<button class="menu-dropbtn"><a href="#">교수</a></button>
							<div class="menu-dropdown-content">
							<a href="#">교수메뉴1 </a>
							<a href="#">메뉴2 </a>
							<a href="<%=request.getContextPath() %>/profsr/profsrInsert" class="no-uline">교수 등록 </a>
							<a href="<%=request.getContextPath() %>/profsr/profsrList" class="no-uline">교수 조회 </a>
						</div>
						</div>

					<div class="menu-dropdown">
						<button class="menu-dropbtn"><a href="#">학생</a></button>
							<div class="menu-dropdown-content">
							<a href="<%=request.getContextPath() %>/stdnt/sknrgsList" class="no-uline">학생/학적관리</a>
							<a href="<%=request.getContextPath() %>/stdnt/atBrhs" class="no-uline">학생/기숙사신청</a>
						</div></div>
					<!-- 여기까지 -->


					<div class="menu-dropdown">
						<button class="menu-dropbtn"><a href="#">학사</a></button>
							<div class="menu-dropdown-content">
							<a href="<%=request.getContextPath() %>/notice_bbs/noticeList" class="no-uline">공지 게시판</a>
							<a href="<%=request.getContextPath() %>/schafs_schdul/schdulList" class="no-uline">학사 일정</a>
						</div></div>
						
						
					<div class="menu-dropdown">
						<button class="menu-dropbtn"><a href="#">수강신청</a></button>
							<div class="menu-dropdown-content">
							<a href="<%=request.getContextPath() %>/course/course_list">수강신청목록</a>
							<a href="#">메뉴2 </a>
						</div></div>
						
					<div class="menu-dropdown">
						<button class="menu-dropbtn"><a href="#">강의</a></button>
							<div class="menu-dropdown-content">
							<a href="#">강의메뉴1 </a>
							<a href="#">메뉴2 </a>
						</div></div>
						
					<div class="menu-dropdown">
						<button class="menu-dropbtn"><a href="#">커뮤니티</a></button>
							<div class="menu-dropdown-content">
							<a href="#">커뮤니티메뉴1 </a>
							<a href="#">메뉴2 </a>
						</div></div>


					<div class="menu-dropdown">
						<button class="menu-dropbtn"><a href="#" onclick="op_menu_admin()">관리자</a></button>
							<div class="menu-dropdown-content">
							<a href="<%=request.getContextPath()%>/admin/step1Add">레이아웃 설정</a>
							<a href="<%=request.getContextPath()%>/admin/main">관리자 페이지</a>
							<a href="#">메뉴2 </a>
						</div></div>

				</ul>

			</div>
		</div>
	</nav>


	<!-- 상단 메뉴 끝 -->


</body>
</html>

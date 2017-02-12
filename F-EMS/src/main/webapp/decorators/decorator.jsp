<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 1L);
%>


<!DOCTYPE html>
<html>
<head>
<title>
<decorator:title default="F-EMS"/>
</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<decorator:head />
</head>
<body>


<!-- 상단바 시작 -->
	<nav class="navbar top-navbar-inverse" id="topnav">
		<div class="container-fluid" id="toptable">
			<div class="navbar-header" style="width: 100%;">
				<table id="topnav-table" style="width: 100%;">
					<tr  style="width: 900px;">
						<td><a href="<%=request.getContextPath()%>/"><img
								src="<%=request.getContextPath()%>/resources/images/uni_logo.png"
								id="logo"></a></td>
				</table>
<div class="float-right">
					<c:choose>
						<c:when test="${empty loginUser}">
		<a href="<%=request.getContextPath() %>/loginForm" class="no-uline"><button
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
		<div class="container-fluid top-menu" style="padding-left:11.5%;">
			<div class="collapse navbar-collapse" id="myNavbar">

				<ul class="nav navbar-nav navbar-left">

					<!-- 권한 관련 추후에 설정 -->
					<div class="menu-dropdown">
						<button class="menu-dropbtn"><a href="#">직원</a></button>
							<div class="menu-dropdown-content">
							<a href="<%=request.getContextPath() %>/sklstf/sklstfUpdate" class="no-uline">직원 정보 수정</a>
							<a href="<%=request.getContextPath() %>/sklstf/stdntInsert" class="no-uline">학생 등록 </a>
							<a href="<%=request.getContextPath() %>/sklstf/stdntList" class="no-uline">학생 조회 </a>
							<a href="<%=request.getContextPath() %>/sklstf/sknrgListForm" class="no-uline">학적 관리 </a>
							<a href="<%=request.getContextPath() %>/sklstf/stdntBrhs" class="no-uline">기숙사 신청 </a>
							<a href="<%=request.getContextPath() %>/sklstf/profsrInsert" class="no-uline">교수 등록 </a>
							<a href="<%=request.getContextPath() %>/sklstf/profsrList" class="no-uline">교수 조회 </a>
							<a href="<%=request.getContextPath() %>/sklstf/schlshipList" class="no-uline">장학금 양식</a>
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
							<a href="<%=request.getContextPath() %>/course/courseList">수강신청목록</a>
							<a href="#">메뉴2 </a>
						</div></div>
						
					<div class="menu-dropdown">
						<button class="menu-dropbtn"><a href="#">강의</a></button>
							<div class="menu-dropdown-content">
							
							<a href="<%=request.getContextPath() %>/lctre/lctreList">강의목록</a>
	<a href="<%=request.getContextPath() %>/lctre/noticeList">공지게시판</a>
	<a href="<%=request.getContextPath() %>/lctre/fileList">자료게시판</a>
	<a href="<%=request.getContextPath() %>/lctre/qnaList">질의응답 게시판</a>
	<a href="<%=request.getContextPath() %>/lctre/hwList">과제 게시판</a>
	<a href="<%=request.getContextPath() %>/lctre/mediaList">동영상 게시판</a>
	<a href="<%=request.getContextPath() %>/lctre/attendList">시청 여부 게시판</a>
							
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



<!-- 좌측메뉴 시작 -->
	<div class="container-fluid">
		<div class="row content">
			
			<div class="custom-col-sm-2 sidenav">

				<!-- ////////////////// -->
				<ul class="accordion-menu" id="accordionMenu1">
					<li data-extension="close">
						<div class="main-title">
							<span class="folder main_menu"></span><a href="#">직원</a>
						</div>
						<ul class="sub sub_meun">
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/sklstfUpdate" class="no-uline">직원 정보 수정</a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/stdntInsert" class="no-uline">학생 등록 </a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/stdntList" class="no-uline">학생 조회 </a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/sknrgListForm" class="no-uline">학적 관리 </a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/stdntBrhs" class="no-uline">기숙사 신청 </a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/profsrInsert" class="no-uline">교수 등록 </a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/profsrList" class="no-uline">교수 조회 </a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/sklstf/schlshipList" class="no-uline">장학금 양식</a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="#" class="no-uline">메뉴1 </a></li></div>
							
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								>교수</a>
						</div>
						<ul class="sub sub_meun">
							<div class="inherit-size"><li class="sub-menu-li"><a href="#">학생메뉴1
							</a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="#">메뉴2
							</a></li></div>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								>학생</a>
						</div>
						<ul class="sub sub_meun">
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/stdnt/sknrgsList" class="no-uline">학생/학적관리</a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/stdnt/atBrhs" class="no-uline">학생/기숙사신청</a></li></div>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								>학사</a>
						</div>
						<ul class="sub sub_meun">
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/notice_bbs/noticeList" >공지 게시판
							</a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="#" >메뉴2
							</a></li></div>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								>수강신청</a>
						</div>
						<ul class="sub sub_meun">
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/course/courseList" >수강신청 목록
							</a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="#" >메뉴2
							</a></li></div>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								>강의</a>
						</div>
						<ul class="sub sub_meun">
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/lctre/lctreList">강의목록</a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/lctre/noticeList">공지게시판</a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/lctre/fileList">자료게시판</a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/lctre/qnaList">질의응답 게시판</a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/lctre/hwList">과제 게시판</a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/lctre/mediaList">동영상 게시판</a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/lctre/attendList">시청 여부 게시판</a></li></div>
							
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								>커뮤니티</a>
						</div>
						<ul class="sub sub_meun">
							<div class="inherit-size"><li class="sub-menu-li"><a href="#" >커뮤니티메뉴1
							</a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="#" >메뉴2
							</a></li></div>
							
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#">관리자</a>
						</div>
						<ul class="sub sub_meun">
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath() %>/admin/step1Add" >레이아웃 설정
							</a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/admin/main">관리자 페이지</a></li></div>
							<div class="inherit-size"><li class="sub-menu-li"><a href="#" >메뉴2
							</a></li></div>
						</ul>
					</li>



				</ul>

			</div>
			<!-- ////////////////// -->

			<div class="custom-col-sm-8 sidenav text-left">
				<decorator:body />
			</div>
		</div>

	</div>

	<!-- 좌측메뉴 끝 -->
	
<!-- Footer 시작 -->
	<footer class="footer container-fluid text-center">
		<p>Footer Text</p>
	</footer>
	<!-- Footer 끝 -->



</body>


<!--  ============= css =============  -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/accordion.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/board.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/course.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/layout_setup.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/menu.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/scheduler.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/w3.css">
<!--  ============= css =============  -->


<!--  ============= js =============  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/accordion.js"></script>
<!--  ============= js =============  -->


<!-- //////////////////////////////////// -->

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
<script src="<%=request.getContextPath()%>/resources/js/profsr_schedl.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/profsr_subjct_asnm.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/pymnt.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/reqst.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/schafs_schdul.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/schlship.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/sklstf.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/sklstf_atrty.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/sknrgs.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/stdnt.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/subjct_info_table.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/test.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/test_paper.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/tuition.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/use.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/users.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/work.js"></script>
<!-- //////////////////////////////////// -->


</html>
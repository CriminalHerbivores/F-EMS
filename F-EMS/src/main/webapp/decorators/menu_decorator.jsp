<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html>
<head>
<title>
<decorator:title default="F-EMS"/>
</title>

<style>
body{
	font-size:9pt;
}	

</style>

<decorator:head />
</head>
<body>
<!-- 상단바 시작 -->
	<nav class="navbar navbar-inverse" id="topnav">
		<div class="container-fluid" id="toptable">
			<div class="navbar-header" style="width: 100%;">
				<table id="topnav-table">
					<tr>
						<td><a href="<%=request.getContextPath()%>/"><img
								src="<%=request.getContextPath()%>/resources/images/logo.png"
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
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- <button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button> -->
		
			<div class="collapse navbar-collapse" id="myNavbar">

				<ul class="nav navbar-nav navbar-left">

					<!-- 권한 관련 추후에 설정 -->
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">직원 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=request.getContextPath() %>/sklstf/sklstfUpdate" class="no-uline">직원 정보 수정</a></li>
							<li><a href="<%=request.getContextPath() %>/stdnt/stdntInsert" class="no-uline">학생 수정 </a></li>
							<li><a href="<%=request.getContextPath() %>/stdnt/stdntList" class="no-uline">학생 조회 </a></li>
							<li><a href="<%=request.getContextPath() %>/stdnt/sknrgListForm" class="no-uline">학적 관리 </a></li>
							<li><a href="#" class="no-uline">메뉴1 </a></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">교수 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">교수메뉴1 </a></li>
							<li><a href="#">메뉴2 </a></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">학생 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">학생메뉴1 </a></li>
							<li><a href="#">메뉴2 </a></li>
						</ul></li>
					<!-- 여기까지 -->


					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">학사 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=request.getContextPath() %>/notice_bbs/noticeList" class="no-uline">공지 게시판</a></li>
							<li><a href="#">메뉴2 </a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">수강신청 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=request.getContextPath() %>/course/course_list">수강신청목록</a></li>
							<li><a href="#">메뉴2 </a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">강의 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">강의메뉴1 </a></li>
							<li><a href="#">메뉴2 </a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">커뮤니티 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">커뮤니티메뉴1 </a></li>
							<li><a href="#">메뉴2 </a></li>
						</ul></li>


					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">관리자 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=request.getContextPath()%>/admin/step1_add">레이아웃 설정</a></li>
							<li><a href="<%=request.getContextPath()%>/admin/main">관리자 페이지</a></li>
							<li><a href="#">메뉴2 </a></li>
						</ul></li>

				</ul>

			</div>
		</div>
	</nav>


	<!-- 상단 메뉴 끝 -->

	<!-- 좌측메뉴 시작 -->
	<div class="container-fluid">
		<div class="row content">
			
			<div class="custom-col-sm-2 sidenav">
				<!-- <p>1</p>
				<p class="main_menu">
				<a href="#">상위메뉴</a></p>
				
				<p class="sub_meun">
				<a href="#">하위메뉴</a>
				</p>
				<p>2</p> -->

				<!-- ////////////////// -->
				<ul class="accordion-menu" id="accordionMenu1">
					<li data-extension="open">
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								class="no-uline">직원</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;">
								<a href="<%=request.getContextPath() %>/sklstf/sklstfUpdate" class="no-uline">직원 정보 수정
							</a></li>
							<li style="margin-left: 2em;"><a href="<%=request.getContextPath() %>/stdnt/stdntInsert" class="no-uline">학생 등록
							</a></li>
							<li style="margin-left: 2em;"><a href="#" class="no-uline">직원 메뉴1
							</a></li>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								class="no-uline">교수</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;"><a href="#" class="no-uline">학생메뉴1
							</a></li>
							<li style="margin-left: 2em;"><a href="#" class="no-uline">메뉴2
							</a></li>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								class="no-uline">학생</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;"><a href="#" class="no-uline">학생메뉴1
							</a></li>
							<li style="margin-left: 2em;"><a href="#" class="no-uline">메뉴2
							</a></li>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								class="no-uline">학사</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;"><a href="<%=request.getContextPath() %>/notice_bbs/noticeList" class="no-uline">공지 게시판
							</a></li>
							<li style="margin-left: 2em;"><a href="#" class="no-uline">메뉴2
							</a></li>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								class="no-uline">수강신청</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;"><a href="<%=request.getContextPath() %>/course/course_list" class="no-uline">수강신청 목록
							</a></li>
							<li style="margin-left: 2em;"><a href="#" class="no-uline">메뉴2
							</a></li>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								class="no-uline">강의</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;"><a href="#" class="no-uline">강의메뉴1
							</a></li>
							<li style="margin-left: 2em;"><a href="#" class="no-uline">메뉴2
							</a></li>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								class="no-uline">커뮤니티</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;"><a href="#" class="no-uline">커뮤니티메뉴1
							</a></li>
							<li style="margin-left: 2em;"><a href="#" class="no-uline">메뉴2
							</a></li>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								class="no-uline">관리자</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;"><a href="<%=request.getContextPath() %>/admin/step1_add" class="no-uline">레이아웃 설정
							</a></li>
							<li style="margin-left: 2em;"><a href="<%=request.getContextPath()%>/admin/main">관리자 페이지</a></li>
							<li style="margin-left: 2em;"><a href="#" class="no-uline">메뉴2
							</a></li>
						</ul>
					</li>



				</ul>

			</div>
			<!-- ////////////////// -->

			<div class="custom-col-sm-10 sidenav text-left">
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
</html>

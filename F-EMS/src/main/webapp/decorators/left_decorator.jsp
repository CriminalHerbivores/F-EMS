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
					<li data-extension="close">
						<div class="main-title">
							<span class="folder main_menu"></span><a href="#">직원</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;">
								<a href="<%=request.getContextPath() %>/sklstf/sklstfUpdate">직원 정보 수정
							</a></li>
							<li style="margin-left: 2em;"><a href="<%=request.getContextPath() %>/stdnt/stdntInsert">학생 등록
							</a></li>
							<li style="margin-left: 2em;"><a href="#">직원 메뉴1
							</a></li>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								>교수</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;"><a href="#">학생메뉴1
							</a></li>
							<li style="margin-left: 2em;"><a href="#">메뉴2
							</a></li>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								>학생</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;"><a href="<%=request.getContextPath() %>/stdnt/sknrgsList" class="no-uline">학생/학적관리</a></li>
							<li style="margin-left: 2em;"><a href="<%=request.getContextPath() %>/stdnt/atBrhs" class="no-uline">학생/기숙사신청</a></li>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								>학사</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;"><a href="<%=request.getContextPath() %>/notice_bbs/noticeList" >공지 게시판
							</a></li>
							<li style="margin-left: 2em;"><a href="<%=request.getContextPath() %>/schafs_schdul/schdulList" >학사 일정
							</a></li>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								>수강신청</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;"><a href="<%=request.getContextPath() %>/course/course_list" >수강신청 목록
							</a></li>
							<li style="margin-left: 2em;"><a href="#" >메뉴2
							</a></li>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								>강의</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;"><a href="#" >강의메뉴1
							</a></li>
							<li style="margin-left: 2em;"><a href="#" >메뉴2
							</a></li>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#"
								>커뮤니티</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;"><a href="#" >커뮤니티메뉴1
							</a></li>
							<li style="margin-left: 2em;"><a href="#" >메뉴2
							</a></li>
						</ul>
					</li>

					<li>
						<div class="main-title">
							<span class="folder main_menu"> </span><a href="#">관리자</a>
						</div>
						<ul class="sub sub_meun">
							<li style="margin-left: 2em;"><a href="<%=request.getContextPath() %>/admin/step1_add" >레이아웃 설정
							</a></li>
							<li style="margin-left: 2em;"><a href="<%=request.getContextPath()%>/admin/main">관리자 페이지</a></li>
							<li style="margin-left: 2em;"><a href="#" >메뉴2
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


</body>
</html>
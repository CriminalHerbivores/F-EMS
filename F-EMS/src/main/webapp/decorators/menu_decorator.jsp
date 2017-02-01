<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!-- <!DOCTYPE html>
<html lang="en">
<head>
<title>decorator</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 -->
 
 
 
 <style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px; /* 중앙 높이 */
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1; /* 좌측 메뉴 바탕 */
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555; /* Footer 바탕 */
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}

#topnav {
	background-color: white;
	height: 65px;
}

#secondnav {
	background-color: #363636;
	height: 50px;
}

#toptable {
	width: 100%
}

.dropdown{
 display:inline;
  position: relative;
    display: inline-block;
}

 #topnav-table{
 display:inline;
} 

#logo{
width: 150px;
margin-top: 10px
}

#category{
margin-left: 230px;
margin-top: 15px;
}

.float-r{
float:right;
}
/* .navbar-left > li > a:hover, .navbar-left > li > a:focus {
    background-color: #339955;
    color: #336799;
}  */

</style>


</head>
<body>

<!-- 상단바 시작 -->
	<nav class="navbar navbar-inverse" id="topnav">
		<div class="container-fluid" id="toptable">
			<div class="navbar-header" style="width: 100%;">
				<table id="topnav-table">
					<tr>
						<td><a href="#"><img src="resources/images/logo.png" id="logo"></a></td>
						<td></td>
					</tr>
				</table>
				
				<!-- 로그인한 사용자 정보 받아오는건 추후에 쿼리로 받아오거나 해야함 -->
				
				<button class="def-btn float-r" onclick="logout_go">Logout</button>
			</div>
		</div>
	</nav>
<!-- 상단바 끝 -->

<!-- 상단메뉴 시작 -->

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- <div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div> -->
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-left">
			
			
			<!-- 권한 관련 추후에 설정 -->	
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">직원 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">직원메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
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
						<li><a href="#">학사메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>	
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">수강신청 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">수강신청메뉴1 </a></li>
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
						<li><a href="#">관리자메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>
				
			</ul>

		</div>
	</div>
</nav>


<!-- 	<nav class="navbar navbar-inverse" id="secondnav">
		<div class="collapse navbar-collapse" id="category">
				
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					학생 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#">HTML</a></li>
					<li><a href="#">CSS</a></li>
					<li><a href="#">JavaScript</a></li>
				</ul>
			</div>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					학사 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#">HTML</a></li>
					<li><a href="#">CSS</a></li>
					<li><a href="#">JavaScript</a></li>
				</ul>
			</div>
		
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					수강신청 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#">HTML</a></li>
					<li><a href="#">CSS</a></li>
					<li><a href="#">JavaScript</a></li>
				</ul>
			</div>
	
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					강의 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#">HTML</a></li>
					<li><a href="#">CSS</a></li>
					<li><a href="#">JavaScript</a></li>
				</ul>
			</div>
		
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					커뮤니티 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#">HTML</a></li>
					<li><a href="#">CSS</a></li>
					<li><a href="#">JavaScript</a></li>
				</ul>
				
	<form class="navbar-form navbar-left">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
			
			</div>
		
	
		
		
			
			
		</div>
		<ul class="nav navbar-nav">
        <li style="margin-left: 300px;"><a href="#">학생</a></li>
        <li><a href="#">학사</a></li>
        <li><a href="#">수강신청</a></li>
        <li><a href="#">강의</a></li>
        <li><a href="#">커뮤니티</a></li>
        
      </ul>
		

	</nav> -->
<!-- 상단 메뉴 끝 -->	

<!-- 좌측메뉴 시작 -->
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<p>1</p>
				<p class="main_menu">
				<a href="#">상위메뉴</a></p>
				
				<p class="sub_meun">
				<a href="#">하위메뉴</a>
				</p>
				<p>2</p>
			</div>
			
			<div class="col-sm-10 text-left">
			
<decorator:body />
			</div>
			
			
		</div>
	</div>
<!-- 좌측메뉴 끝 -->




<!-- Footer 시작 -->
	<footer class="deco">
		<p>Footer Text</p>
		
		
		
	</footer>
<!-- Footer 끝 -->


</body>
</html>

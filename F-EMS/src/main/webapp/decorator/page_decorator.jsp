<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
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
width: 170px;
margin-top: 8px
}

#category{
margin-left: 230px;
margin-top: 15px;
}

</style>
</head>
<body>


	<nav class="navbar navbar-inverse" id="topnav">
		<div class="container-fluid" id="toptable">
			<div class="navbar-header" style="width: 100%;">
				<table id="topnav-table">
					<tr>
						<td><img src="resources/images/logo.png" id="logo"></td>
						<td></td>
					</tr>
				</table>
				<a href="#" style="float:right;"><span class="glyphicon glyphicon-log-in"></span>
								Logout</a>
			</div>
		</div>
	</nav>

	<nav class="navbar navbar-inverse" id="secondnav">
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
		<!-- </div>
		<div class="collapse navbar-collapse" id="myNavbar"> -->
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

			</div>
		</div>
		<!-- <ul class="nav navbar-nav">
        <li style="margin-left: 300px;"><a href="#">학생</a></li>
        <li><a href="#">학사</a></li>
        <li><a href="#">수강신청</a></li>
        <li><a href="#">강의</a></li>
        <li><a href="#">커뮤니티</a></li>
        
      </ul> -->
		

	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<h4>John's Blog</h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#section1">Home</a></li>
					<li><a href="#section2">Friends</a></li>
					<li><a href="#section3">Family</a></li>
					<li><a href="#section3">Photos</a></li>
				</ul>
				<br>
			</div>
		</div>
	</div>

	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>

</body>
</html>

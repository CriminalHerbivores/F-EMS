<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
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





<script>
	$(function() {
		$('.dropdown').click(function(event) {
			event.preventDefault();
			menu = $('.dropdown-toggle', this).text();
			submenu = $('.dropdown-menu li a', this).text();

			$.ajax({
				url : 'menu.jsp',
				type : 'post',
				data : {
					'menu' : menu,
					'submenu' : submenu
				},
				success : function(res) {
					$('.sidenav p#pmenu').text(menu);
					var code = "";
					$.each(res, function(i) {
						code += "<a href='#'>" + res[i].item + "</a><br>";

					})
					$('.sidenav .sidemeun').html(code);
				},
				dataType : 'json'
			})
		})
	})
</script>









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
			
			
			<!-- 시큐리트 추후에 설정 -->	
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">직원 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>
				
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">교수 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>
				
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">학생 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>
				<!-- 여기까지 -->
									
					
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">학사 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>	
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">수강신청 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">강의 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">커뮤니티 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>
				
				
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">관리자 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">메뉴1 </a></li>
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
				<ul class="nav nav-pills nav-stacked">
					<li><a href="#section2">Friends</a></li>
					<li><a href="#section3">Family</a></li>
					<li><a href="#section3">Photos</a></li>
				</ul>
				<br>
			</div>
		</div>
	</div>
<!-- 좌측메뉴 끝 -->


<decorator:body />


<!-- Footer 시작 -->
	<footer class="deco">
		<p>Footer Text</p>
	</footer>
<!-- Footer 끝 -->














<script src="<%=request.getContextPath()%>/js/answer.js"></script>
<script src="<%=request.getContextPath()%>/js/atrty.js"></script>
<script src="<%=request.getContextPath()%>/js/atrty.js"></script>
<script src="<%=request.getContextPath()%>/js/attendance.js"></script>
<script src="<%=request.getContextPath()%>/js/bbs_atrty.js"></script>
<script src="<%=request.getContextPath()%>/js/bbs_flpth.js"></script>
<script src="<%=request.getContextPath()%>/js/bbs_list.js"></script>
<script src="<%=request.getContextPath()%>/js/building.js"></script>
<script src="<%=request.getContextPath()%>/js/chatting.js"></script>
<script src="<%=request.getContextPath()%>/js/cnslt_bbs.js"></script>
<script src="<%=request.getContextPath()%>/js/colege.js"></script>
<script src="<%=request.getContextPath()%>/js/compl_pnt.js"></script>
<script src="<%=request.getContextPath()%>/js/consultation.js"></script>
<script src="<%=request.getContextPath()%>/js/faculty.js"></script>
<script src="<%=request.getContextPath()%>/js/files.js"></script>
<script src="<%=request.getContextPath()%>/js/grade.js"></script>
<script src="<%=request.getContextPath()%>/js/intrst_list.js"></script>
<script src="<%=request.getContextPath()%>/js/kind.js"></script>
<script src="<%=request.getContextPath()%>/js/lctre.js"></script>
<script src="<%=request.getContextPath()%>/js/lctre_actpln.js"></script>
<script src="<%=request.getContextPath()%>/js/lctre_flpth.js"></script>
<script src="<%=request.getContextPath()%>/js/lctre_unq_no.js"></script>
<script src="<%=request.getContextPath()%>/js/lctrum.js"></script>
<script src="<%=request.getContextPath()%>/js/manage.js"></script>
<script src="<%=request.getContextPath()%>/js/menu.js"></script>
<script src="<%=request.getContextPath()%>/js/menu_se.js"></script>
<script src="<%=request.getContextPath()%>/js/notice_bbs.js"></script>
<script src="<%=request.getContextPath()%>/js/profsr.js"></script>
<script src="<%=request.getContextPath()%>/js/profsr_schedl.js"></script>
<script src="<%=request.getContextPath()%>/js/profsr_subjct_asnm.js"></script>
<script src="<%=request.getContextPath()%>/js/pymnt.js"></script>
<script src="<%=request.getContextPath()%>/js/reqst.js"></script>
<script src="<%=request.getContextPath()%>/js/schafs_schdul.js"></script>
<script src="<%=request.getContextPath()%>/js/schlship.js"></script>
<script src="<%=request.getContextPath()%>/js/sklstf.js"></script>
<script src="<%=request.getContextPath()%>/js/sklstf_atrty.js"></script>
<script src="<%=request.getContextPath()%>/js/sknrgs.js"></script>
<script src="<%=request.getContextPath()%>/js/stdnt.js"></script>
<script src="<%=request.getContextPath()%>/js/subjct_info_table.js"></script>
<script src="<%=request.getContextPath()%>/js/test.js"></script>
<script src="<%=request.getContextPath()%>/js/test_paper.js"></script>
<script src="<%=request.getContextPath()%>/js/tuition.js"></script>
<script src="<%=request.getContextPath()%>/js/use.js"></script>
<script src="<%=request.getContextPath()%>/js/users.js"></script>
<script src="<%=request.getContextPath()%>/js/work.js"></script>

</body>
</html>
 --%>
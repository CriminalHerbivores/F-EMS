<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
 * <pre>
 * 개설강의목록, 수강신청완료목록, 관심강의목록, 수강신청가능학점 페이지를 한번에 확인가능한 JSP
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
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
function op_timeTable(){
 
	swal({
		title : "Are you sure?",
		text : "You will not be able to recover this imaginary file!",
		type : "warning",
		showCancelButton : true,
		confirmButtonColor : "#DD6B55",
		confirmButtonText : "닫기",
		closeOnConfirm : false
	}, function (){
		swal("Deleted!", "Your imaginary file has been deleted.", "success");
	}); 
}

/* modal 관련 3.jquery로 포함시키기 */
<%-- $(document).ready(function(){
    $("#course_able").load("<%=request.getContextPath()%>/course/course_able");
    $("#course_complete").load("<%=request.getContextPath()%>/course/course_complete");
    $("#course_interest").load("<%=request.getContextPath()%>/course/course_interest");
    $("#course_credit").load("<%=request.getContextPath()%>/course/course_credit");
}); --%>

</script>

</head>
<body>


	<!-- 상단바 시작 -->
	<nav class="navbar top-navbar-inverse" id="topnav">
		<div class="container-fluid" id="toptable">
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
					<button type="button" class="def-btn btn-md btn-color"
						id="openmodal" data-toggle="modal" data-target="#myModal" onclick="op_timeTable()">시간표</button>&nbsp;&nbsp;
					<input type="button" class="def-btn btn-md btn-gray" onclick="go.history(-1)" value="이전" >
				</div>
			</div>
		</div>
	</nav>
	<!-- 상단바 끝 --> 
				<!-- <hr class="margin-btm-0"></hr> -->



<!-- 
1. iframe : modal 영역이 프레임 내에만 적용되는 문제가 있었음 <<이걸로 하고싶긴 함
2. jsp include: 제대로 jsp페이지가 안 들어옴 (브라우저 F12 눌러보면 이상함)
3. jquery로 포함 : modal이 제대로 활용되지 않음


 -->

	<div class="div-course-list-left">
			<iframe src="<%=request.getContextPath()%>/course/courseAble"
				class="course-list-l-top"></iframe>
			<iframe src="<%=request.getContextPath()%>/course/courseComplete"
				class="course-list-l-bottom"></iframe>
				
			<!-- <div class="course-list-l-top" id="course_able"> -->
<%-- 				<jsp:include page="course_able.jsp"></jsp:include> --%>
			</div>
			<!-- <div class="course-list-l-bottom" id="course_complete"> -->
<%-- 				<jsp:include page="course_complete.jsp"></jsp:include> --%>
			<!-- </div>
		</div> -->
		
	
	<div class="div-course-list-right">
		<iframe src="<%=request.getContextPath()%>/course/courseInterest"
			class="course-list-r-top"></iframe>
		<iframe src="<%=request.getContextPath()%>/course/courseCredit"
			class="course-list-r-bottom"></iframe>
			
		<!-- <div class="course-list-r-top" id="course_interest"> -->
<%-- 			<jsp:include page="course_interest.jsp"></jsp:include> --%>
		</div>
		<!-- <div class="course-list-r-bottom" id="course_credit"> -->
<%-- 			<jsp:include page="course_credit.jsp"></jsp:include> --%>
		<!-- </div>
	</div> -->
	

</body>
</html>

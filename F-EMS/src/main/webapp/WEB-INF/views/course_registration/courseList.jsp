<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>
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

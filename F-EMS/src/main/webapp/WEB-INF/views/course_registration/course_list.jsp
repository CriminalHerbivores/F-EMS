<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
.div-course-list-left {
	folat: left;
	margin: 0;
	padding: 0;
	width: 75%;
	height: 100%;
	text-align: left;
	vertical-align: top;
	display: table-cell;
	background: #aaa;
}

/* .div-course-list-top {
	folat: left;
	margin: 0;
	padding: 0;
	width: 100%;
	height: 60%;
	text-align: left;
	vertical-align: top;
	display: table-cell;
	background: #aaa;
}

.div-course-list-bottom {
	folat: left;
	margin: 0;
	padding: 0;
	width: 100%;
	height: 40%;
	text-align: left;
	vertical-align: top;
	display: table-cell;
	background: #ccc;
} */

.div-course-list-right {
	folat: right;
	margin: 0;
	padding: 0;
	width: 25%;
	height: 100%;
	text-align: left;
	vertical-align: top;
	display: table-cell;
	background: #eee;
}

.course-list-top {
	width: 100%;
	height: 55%;
	border: 0px;
	overflow:auto;
	align:top;
}

.course-list-bottom {
	width: 100%;
	height: 45%;
	border: 0px;
	overflow:auto;
	align:middle;
}

.course-list-right {
	width: 100%;
	height: 100%;
	border: 0px;
	overflow:auto;
	align:right;
}
</style>
</head>
<body>
	<div class="div-course-list-left">
<!-- 		<div class="div-course-list-top"> -->
			<iframe src="<%=request.getContextPath()%>/course/course_able"
				class="course-list-top"></iframe>
<!-- 		</div> -->
<!-- 		<div class="div-course-list-bottom"> -->
			<iframe src="<%=request.getContextPath()%>/course/course_complete"
				class="course-list-bottom"></iframe>
		</div>
<!-- 	</div> -->
	
	<div class="div-course-list-right">
		<iframe src="<%=request.getContextPath()%>/course/course_interest"
			class="course-list-right"></iframe>
	</div>
</body>
</html>

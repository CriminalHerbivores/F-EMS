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

.course-list-l-top {
	width: 100%;
	height: 55%;
	border: 0px;
	overflow:auto;
	align:top;
}

.course-list-l-bottom {
	width: 100%;
	height: 45%;
	border: 0px;
	overflow:auto;
	align:middle;
}

.course-list-r-top {
	width: 100%;
	height: 55%;
	border: 0px;
	overflow:auto;
	align:right;
}

.course-list-r-bottom {
	width: 100%;
	height: 45%;
	border: 0px;
	overflow:auto;
	align:right;
}

</style>
</head>
<body>
	<div class="div-course-list-left">
			<iframe src="<%=request.getContextPath()%>/course/course_able"
				class="course-list-l-top"></iframe>
			<iframe src="<%=request.getContextPath()%>/course/course_complete"
				class="course-list-l-bottom"></iframe>
		</div>
	
	<div class="div-course-list-right">
		<iframe src="<%=request.getContextPath()%>/course/course_interest"
			class="course-list-r-top"></iframe>
		<iframe src="<%=request.getContextPath()%>/course/course_credit"
			class="course-list-r-bottom"></iframe>
	</div>
</body>
</html>

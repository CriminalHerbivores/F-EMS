<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
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

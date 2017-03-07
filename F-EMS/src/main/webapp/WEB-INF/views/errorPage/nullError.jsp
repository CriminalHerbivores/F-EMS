<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body style="text-align: center;">
<br><br><br><br><br>
<img src="<%=request.getContextPath() %>/resources/images/common-errorPage.jpg" style="width:40%;height:40%;">
<br>
<input type="button" class="def-btn btn-md btn-color" onclick="location.href='<%=request.getContextPath() %>/'" value="메인으로" style="text-align: center;" />
</body>
</html>
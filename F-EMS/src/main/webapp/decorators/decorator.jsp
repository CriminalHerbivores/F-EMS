<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 1L);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>
</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>  


<body>
<jsp:include page="menu_decorator.jsp"></jsp:include>
</body>

<!--  ============= css =============  -->
<%-- <script src="<%=request.getContextPath()%>/css/accordion.css"></script>
<script src="<%=request.getContextPath()%>/css/board.css"></script>
<script src="<%=request.getContextPath()%>/css/main.css"></script>
<script src="<%=request.getContextPath()%>/css/menu.css"></script> --%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/accordion.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/board.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/menu.css" />
<!--  ============= css =============  -->


<!--  ============= js =============  -->
<script src="<%=request.getContextPath()%>/js/jquery-1.11.0.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.easing.1.3.js"></script>
<script src="<%=request.getContextPath()%>/js/accordion.js"></script>
<!--  ============= js =============  -->


<!-- //////////////////////////////////// -->
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
<!-- //////////////////////////////////// -->


</html>
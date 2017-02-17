<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<%--
 * <pre>
 * 상단바, 상단메뉴, 좌측메뉴, Footer가 모두 포함되지 않고 js, css를 포함하는 JSP
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH        최초작성
 * 2017.01.30      KJH        추가작성 
 * 2017.02.10      KJH        추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 --%>

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
<decorator:title default="F-EMS"/>
</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<decorator:head />
</head>  


<body>
<decorator:body />
</body>

<!--  ============= css =============  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/accordion.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/board.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/course.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/layout_setup.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/main.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/menu.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/scheduler.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/w3.css">

<!-- Calendar -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/examples-offline.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/kendo.common.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/kendo.rtl.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/kendo.default.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/kendo.default.mobile.min.css">
<!--  ============= css =============  -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/dynamicCss/menu.do" />




<!--  ============= js =============  -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.easing.1.3.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/accordion.js"></script>
<!--  ============= js =============  -->


<!-- //////////////////////////////////// -->

<!-- ssh 추가 -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jszip.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/kendo.all.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/console.js"></script>


<script src="<%=request.getContextPath()%>/resources/js/answer.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/atrty.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/atrty.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/attendance.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bbs_atrty.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bbs_flpth.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bbs_list.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/building.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/chatting.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/cnslt_bbs.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/colege.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/compl_pnt.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/consultation.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/faculty.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/files.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/grade.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/intrst_list.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/kind.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/lctre.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/lctre_actpln.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/lctre_flpth.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/lctre_unq_no.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/lctrum.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/manage.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/menu.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/menu_se.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/notice_bbs.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/profsr.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/profsr_schedl.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/profsr_subjct_asnm.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/pymnt.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/reqst.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/schafs_schdul.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/schlship.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/sklstf.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/sklstf_atrty.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/sknrgs.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/stdnt.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/subjct_info_table.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/test.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/test_paper.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/tuition.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/use.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/users.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/work.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/member.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
<!-- //////////////////////////////////// -->

</html>

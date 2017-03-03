<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
 * <pre>
 * 상단바, 상단메뉴, 좌측메뉴, Footer, js, css를 포함하는 JSP
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH        최초작성
 * 2017.01.30      KJH        추가작성 
 * 2017.02.10      KJH        추가작성
 * 2017.02.16      KJH        dynamicCSS
 * Copyright (c) 2017 by DDIT All right reserved
 --%>

<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 1L);
%>

<!DOCTYPE html>
<html>
<head>
<title>${manageVO.mng_Univ_Nm}<decorator:title /></title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<decorator:head />

<script type="text/javascript">
$(function(){
	function lctreSelected(){
		var sel = location.protocol+"//"+location.host + location.pathname + "?table_Nm=";
		sel += $('#lctreList>option:selected').val();
		location.href=sel;
	}
	$('#lctreList').change(lctreSelected);
	$('#lctreList>option:selected').val();
})
</script>

</head>
<body>

<!-- 상단바 시작 -->
<jsp:include page="top_bar.jsp"/>
<!-- 상단바 끝 --> 

<!-- 상단 메뉴 -->
<jsp:include page="top_menu.jsp"/>
<!-- 상단 메뉴 끝 -->

<!-- 본문 -->
<div class="container-fluid-side-menu">
	<div class="row content">

<!-- 좌측 메뉴 -->
	<jsp:include page="lec_menu.jsp"/>
<!-- 좌측 메뉴 끝 -->

	<c:choose>
	<c:when test="${manageVO.mng_Left_Menu_Use_Ennc=='y'||'Y'}">
		<div class="custom-col-sm-8 sidenav text-left">
			<decorator:body />
		</div>
	</c:when>
	<c:otherwise>
		<div class="custom-col-sm-10 sidenav text-left">
		<decorator:body />
		</div>
	</c:otherwise>	
	</c:choose>	
	</div>
</div>
<!-- 본문 끝 -->

<!-- Footer 시작 -->
<!-- <footer class="footer container-fluid text-center"> -->
<footer class="footer text-center">
	<p>${manageVO.mng_Post_No}&nbsp;&nbsp;${manageVO.mng_Adres1}&nbsp;${manageVO.mng_Adres2}&nbsp;|&nbsp;Tel:${manageVO.mng_Tlphon_No}&nbsp;|&nbsp;Fax:${manageVO.mng_Fax_No}</p>
	<p>Copyright (C)&nbsp;${manageVO.mng_Cpyr }&nbsp;All Rights Reserved.</p>
</footer>
<!-- Footer 끝 -->

</body>

<!--  ============= css =============  -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/accordion.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/board.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/course.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/layout_setup.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/menu.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/scheduler.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/w3.css">

<!-- Calendar -->
<%-- <link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/examples-offline.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/kendo.common.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/kendo.rtl.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/kendo.default.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/kendo.default.mobile.min.css"> --%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/calendarstyle.css">
	
<!--  ============= css =============  -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/dynamicCss/menu.do" />

<!--alert css  -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/sweetalert.css">	

<!--  ============= js =============  -->
	
<script src="https://code.jquery.com/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/accordion.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.easing.1.3.js"></script>

<!-- //////////////////////////////////// -->

<!-- calendar js  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/calendarscript.js"></script>

<!--alert js  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/sweetalert.min.js"></script>

<!-- ssh 추가 -->	
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jszip.min.js"></script>
<%-- <script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/kendo.all.min.js"></script> --%>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/console.js"></script>

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
<script src="<%=request.getContextPath()%>/resources/js/profsr_schedl.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/profsr_subjct_asnm.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/pymnt.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/reqst.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/schafs_schdul.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/schlship.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/sklstf.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/sklstf_atrty.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/sknrgs.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/stdnt.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/subjct_info_table.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/test.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/test_paper.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/tuition.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/use.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/users.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/work.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/member.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bbs_gnt.js"></script>
<!-- //////////////////////////////////// -->

</html>

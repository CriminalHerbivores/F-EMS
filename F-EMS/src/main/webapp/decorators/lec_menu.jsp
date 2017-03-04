<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
* <pre>
* 좌측 메뉴
* </pre>
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 3. 3.      JAR      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!-- 좌측메뉴 시작 -->

<div class="custom-col-sm-2 sidenav">
	<div>
		<!-- ////////////////// -->
	<select id="lctreList" name="lctre" class="combobox-md custom-form-control">
		<c:forEach items="${lctreList}" var="lctre" varStatus="status">
			<option value="${lctre.lc_Lctre_No}">${lctre.lu_lctre_nm}</option>
		</c:forEach>
	</select>
		<ul class="accordion-menu" id="accordionMenu1">
			<li>
				<div class="main-title">
					<span class="folder main_menu"></span><a href="<%=request.getContextPath()%>/lctre/lctreList">강의목록</a>
				</div>
				<ul class="sub sub_meun">
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/lctreList">강의목록</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/noticeList?table_Nm=${table_Nm}">공지게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/dateList?table_Nm=${table_Nm}">자료게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/qnaList?table_Nm=${table_Nm}">질의응답게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/taskList?table_Nm=${table_Nm}">과제 게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/videoList?table_Nm=${table_Nm}">동영상게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/video_StdntList?table_Nm=${table_Nm}">시청여부 게시판</a></li></div>
<div class="inherit-size"><li class="sub-menu-li"><a href="<%=request.getContextPath()%>/lctre/testList?table_Nm=${table_Nm}">온라인 시험 게시판</a></li></div>
				</ul>
			</li>
		</ul>
	</div>
</div>
<!-- ////////////////// -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
* <pre>
* 상단 바
* </pre>
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 3. 3.      JAR      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<nav class="navbar top-navbar-inverse" id="topnav">
	<div id="toptable"><!-- class="container-fluid" -->
		<div class="navbar-header" style="width: 100%;">
			<table id="topnav-table" style="width: 100%;">
				<tr style="width: 900px;">
					<td><a href="<%=request.getContextPath()%>/"> <img src="<%=request.getContextPath()%>${manageVO.mng_Univ_Logo}" id="logo"></a></td>
				</tr>
			</table> 
			<div class="float-right">
				<c:choose>
					<c:when test="${empty loginUser}">
<input class="def-btn btn-sm btn-color" type="button" value="31" onclick="login_baskin();" />&nbsp;&nbsp;
<input class="def-btn btn-sm btn-color" type="button" value="관리자" onclick="login_admin();" />&nbsp;&nbsp;
<input class="def-btn btn-sm btn-color" type="button" value="직원" onclick="login_staff();" />&nbsp;&nbsp;
<input class="def-btn btn-sm btn-color" type="button" value="교수" onclick="login_professor();" />&nbsp;&nbsp;
<input class="def-btn btn-sm btn-color" type="button" value="학생" onclick="login_student();" />&nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/loginForm" class="no-uline"><button class="def-btn btn-sm btn-color">Login</button></a>&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
<input type="button" class="def-btn btn-sm btn-gray" value="${loginUser}" disabled>&nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/logout"><button class="def-btn btn-sm btn-color float-right">Logout</button></a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</nav>
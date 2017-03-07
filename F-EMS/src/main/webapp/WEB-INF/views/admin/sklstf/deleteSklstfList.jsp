<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 직원 목록을 조회할 수 있는 JSP
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.03.07      KJS        최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>
<h2>직원 조회</h2><br/>
<form name="formm" method="post">
	<!-- <div class="container out-border"> -->
	<!-- <table class="def-table-full tb-border"> -->
			<table class="def-table-full tb-border table-hover">
				<!-- <tr>
					<td colspan="12"  class="text-right">
					</td>
				</tr> -->
				<tr>
					<th>직원번호</th>
					<th>단과대학</th>
					<th>학부</th>
					<th>학과</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>연락처</th>
					<th>구분</th>
					<th>복귀</th>
				</tr>
				
				<c:forEach items="${sklstfList}" var="subjct">
				<tr>
				
					<td>${subjct.stf_Sklstf_No}</td>
					<td>${subjct.coleg_Nm}</td>
					<td>${subjct.fc_Faculty_Nm}</td>
					<td>${subjct.sit_Subjct }</td>
					<td>${subjct.stf_Nm}</td>
					<td>${subjct.stf_Ihidnum}</td>
					<td>${subjct.stf_Sklstf_Tlphon_No}</td>
					<%-- <td>${subjct.sa_Atrty}</td> --%>
					<td>
					<c:choose>
					<c:when test="${subjct.sa_Atrty=='ROLE_ADMIN'}">관리자</c:when>
					<c:otherwise>직원</c:otherwise>
					</c:choose>
					</td>
					<td><a href="returnSklstf?stf_Sklstf_No=${subjct.stf_Sklstf_No}&tpage=${tpage}"><input type="button" value="복귀" class="def-btn btn-sm btn-color"></a></td>
					
				</tr>
			</c:forEach>
				<tr>
      		<td colspan="9" style="text-align: center;">${paging }</td>
      	</tr>
</table>
<table class="def-table-full"><tr><td style="text-align: right;">
				<select name="key" class="combobox-md custom-form-control">
					<option value="stf_Sklstf_No">직원번호</option>
					<option value="stf_Nm">직원이름</option>
					<option value="sit_Subjct">학과</option>
					<option value="fc_Faculty_Nm">학부</option>
					<option value="coleg_Nm">단과대학</option>
				</select>&nbsp;&nbsp;
					<input type="text" class="def-input-text-md custom-form-control" name="value">&nbsp;&nbsp;
					<button class="def-btn btn-search btn-color" value="조회" onclick="submitForm(this.form)"><i class="glyphicon glyphicon-search"></i>&nbsp;조회</button>
</td></tr></table>
	</form>
</body>
</html>
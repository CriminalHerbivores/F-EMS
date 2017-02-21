<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 직원목록 및 직원의 관리자 권한여부 목록을 조회할 수 있는 JSP
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH        최초작성
 * 2017.02.15      KJH        추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
function update_Atrty(){
	
}
</script>
</head>
<body>

<form name="formm" mehtod="post">
	
<div class="text-center">
	<h2>관리자 설정</h2>
	<!-- <div class="container out-border"> -->
	<!-- <table class="def-table-full tb-border"> -->
	<table class="def-table-full">
	<tr><td class="text-right">
					<select name="선택" class="combobox-md custom-form-control">
					<option value="${subjct.sa_Atrty}">관리자</option>
					<option value="${subjct.stf_Sklstf_No}">직원번호</option>
					<option value="${subjct.stf_Nm}">직원이름</option>
					<option value="${subjct.sit_Subjct }">소속학과</option>
					<option value="${subjct.fc_Faculty_Nm}">소속학부</option>
					<option value="${subjct.coleg_Nm}">소속단과대학</option>
				</select>&nbsp;&nbsp;
					<input type="text" class="def-input-text-md custom-form-control">&nbsp;&nbsp;
					<button class="def-btn btn-search btn-color" value="조회"><i class="glyphicon glyphicon-search"></i>&nbsp;조회</button>
	</td></tr>
	</table>
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
					<th>관리자</th>
					<th><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="전체적용" onclick=""></th>
				</tr>
				
				<c:forEach items="${userSubjctVO}" var="subjct" begin="0" end="19">
				<tr>
				
					<td>${subjct.stf_Sklstf_No}</td>
					<td>${subjct.coleg_Nm}</td>
					<td>${subjct.fc_Faculty_Nm}</td>
					<td>${subjct.sit_Subjct }</td>
					<td>${subjct.stf_Nm}</td>
					<td>${subjct.stf_Ihidnum}</td>
					<td>${subjct.stf_Sklstf_Tlphon_No}</td>
					<td>
					<c:choose>
					<c:when test="${subjct.sa_Atrty=='ROLE_ADMIN'}"><input type="checkbox" name="sa_Atrty"  checked="checked"></c:when>
					<c:otherwise><input type="checkbox" name="sa_Atrty" ></c:otherwise>
					</c:choose>
					</td>
					<td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="적용" onclick="update_Atrty()"></td>
					
				</tr>
			</c:forEach>
				
			</table>
</div>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 수강신청을 할 수 있는 개설된 강의 목록을 보여주는 JSP
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
/* 수강 신청 */
function add_reqst(){
	alert("수강신청");
}
/* 수강 신청 취소 */
function del_reqst(){
	alert("수강취소");
}
/* 관심 추가 */
function add_intrst(){
	alert("관심추가");
}
/* 관심 삭제 */
function del_intrst(){
	alert("관심삭제");
}
</script>

<style>
body {
	/* background: #D4F4FA; */
}

</style>

</head>
<body class="course-list-l-top">
	<form>
	<div class="text-center">
	<!-- <div class="container out-border"> -->
	<!-- <table class="def-table-full tb-border"> -->
	<table class="def-table-full">
	
	<tr><td class="text-right">
	<input type="radio" name="lu_Compl_Se" value="">전공&nbsp;<input type="radio" name="lu_Compl_Se" value="">교양&nbsp;&nbsp;
	<input type="radio" name="knd_Lctre_Knd" value="">일반&nbsp;<input type="radio" name="knd_Lctre_Knd" value="">사이버&nbsp;&nbsp;
	
	<tr><td class="text-right">				<select name="key" class="combobox-md custom-form-control">
					<option value="lu_Lctre_Nm">강의명</option>
					<option value="pr_Nm">담당교수</option>
					<option value="sit_Subjct">개설학과</option>
					<option value="lu_Lctre_Code">강의코드</option>
				</select>&nbsp;&nbsp;
					<input type="text" class="def-input-text-md custom-form-control" name="value">&nbsp;&nbsp;
					<button class="def-btn btn-search btn-color" value="조회" onclick="submitForm(this.form)"><i class="glyphicon glyphicon-search"></i>&nbsp;조회</button>
					<input type="button" class="def-btn btn-search btn-color" value="상세검색">&nbsp;&nbsp;
	</td></tr>
	</table>
			<table class="def-table-full tb-border table-hover">
				<!-- <tr>
					<td colspan="12"  class="text-right">
					</td>
				</tr> -->
				<tr><th colspan="13"><h4>개설 강의 목록</h4></th></tr>
				<tr>
					<th>수강신청</th>
					<th>관심강의</th>
					<th>개설학과</th>
					<th>강의코드</th>
					<th>분반</th>
					<th>학년</th>
					<th>강의명</th>
					<th>이수구분</th>
					<th>학점/시수</th>
					<th>담당교수</th>
					<th>강의시간</th>
					<th>수강인원</th>
					<th>제한인원</th>
				</tr>
				
				<c:forEach items="${openLctreList}" var="lctre">
				<tr>
					<td>
					<c:choose>
					<c:when test="${lctre.re_Lctre_No==lctre.la_Lctre_No}">
					<!--해당라인의 lu_Lctre_No가 in_Lctre_No중에 일치하는 게 있을 경우-->
					
						<input type="button" class="def-ckbtn btn-sm ckbtn-color" value="수강" onclick="add_reqst()">
					 </c:when>
					<c:otherwise> 
						<input type="button" class="def-ckbtn btn-sm ckbtn-gray" value="취소" onclick="del_reqst()">				
					 </c:otherwise>
					</c:choose>	 				
						</td>
					<td>	
					<c:choose>
					<c:when test="${lctre.in_Lctre_No==lctre.la_Lctre_No}">
					<!--해당라인의 lu_Lctre_No가 in_Lctre_No중에 일치하는 게 있을 경우-->
					
					<input type="button" class="def-ckbtn btn-sm ckbtn-color" value="관심" onclick="add_intrst()">
					 </c:when>
					<c:otherwise> 
						<input type="button" class="def-ckbtn btn-sm ckbtn-gray" value="삭제" onclick="del_intrst()">				
					 </c:otherwise>
					</c:choose>	
					</td>
					<td>${lctre.sit_Subjct}</td>
					<td>${lctre.lu_Lctre_Code}</td>
					<td>${lctre.lc_Split}</td>
					<td>${lctre.lu_Grade }</td>
					<td>${lctre.lu_Lctre_Nm}</td>
					<td>${lctre.lu_Compl_Se}</td>
					<td>${lctre.lu_Pnt}</td>
					<td>${lctre.pr_Nm}</td>
					<td>${lctre.lc_Lctre_Time}</td>
					<td>${lctre.lc_Lctre_Nmpr}</td>
					<td>${lctre.lr_Accept_Nmpr}</td> 
				</tr>
			</c:forEach>
			<tr><td colspan="13" style="text-align: center;">${paging }</td></tr>				
					
			</table>
</div>
	</form>
</body>
</html>
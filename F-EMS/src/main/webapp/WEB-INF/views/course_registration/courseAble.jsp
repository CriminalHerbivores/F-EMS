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
function add_reqst(form){
	alert("수강신청");
	document.formm.submit();
}

function submitForm(form){
	
	document.forrm.submit();
}
</script>

<style>
body {
	/* background: #D4F4FA; */
}
/* .tb-border table {
  border-collapse:collapse;
}   */
/* .fix-top {
  position: fixed;
  top:0%;
}
.fix-mid {
  position: fixed;
  top:12%;
  
}
tbody .tb-border{
	position:relative;
}
.tbtb tbody{
	margin-top:23.3%;
} */
</style>

</head>
<body class="course-list-l-top">
	<div class="text-center">
	<!-- <div class="container out-border"> -->
	<!-- <table class="def-table-full tb-border"> -->
<form name="forrm" method="get">
	<table class="def-table-full">
	<thead class="def-table-full fix-top">
	<tr><td class="text-right">
	<label><input type="checkbox" name="lu_Compl_Se" value="전공" >전공</label>&nbsp;&nbsp;<label><input type="checkbox" name="lu_Compl_Se" value="교양" >교양</label>&nbsp;&nbsp;
	<label><input type="checkbox" name="knd_Lctre_Knd" value="일반" >일반</label>&nbsp;&nbsp;<label><input type="checkbox" name="knd_Lctre_Knd" value="사이버" >사이버</label>&nbsp;&nbsp;
	<!-- </td></tr>
	<tr><td class="text-right">	 -->			<select name="key" class="combobox-md custom-form-control">
					<option value="lu_Lctre_Nm">강의명</option>
					<option value="pr_Nm">담당교수</option>
					<option value="sit_Subjct">개설학과</option>
					<option value="lu_Lctre_Code">강의코드</option>
				</select>&nbsp;&nbsp;
					<input type="text" class="def-input-text-md custom-form-control" name="value">&nbsp;&nbsp;
					<button class="def-btn btn-search btn-color" value="조회" onclick="submitForm(this.form)"><i class="glyphicon glyphicon-search"></i>&nbsp;조회</button>
					<input type="button" class="def-btn btn-search btn-color" value="상세검색">&nbsp;&nbsp;
	</td></tr></thead>
	</table>
	</form>
	<form name="formm" method="post">
			<table class="def-table-full tb-border table-hover">
				<thead class="def-table-full fix-mid">
				<!-- <tr>
					<td colspan="12"  class="text-right">
					</td>
				</tr> -->
				<tr><th colspan="2" class="text-left"><input type="button" class="def-btn ckbtn-color" value="선택 추가" onclick="add_reqst(this.form)"></th>
				<th colspan="11"><h4>개설 강의 목록</h4></th></tr>
				<tr>
					<th><label><input type="checkbox" id="check_all_1" class="input_check_1" />관심강의</label></th>
					<th><label><input type="checkbox" id="check_all_3" class="input_check_2" />수강신청</label></th>
					<th>개설학과</th>
					<th>강의코드</th>
					<th>강의명</th>
					<th>학년</th>
					<th>구분</th>
					<th>학점/시수</th>
					<th>담당교수</th>
					<th>강의시간</th>
					<th>수강인원</th>
					<th>제한인원</th>
				</tr>
				</thead>
				<tbody>
				
				<c:forEach items="${openLctreList}" var="lctre">
				<tr>
					<td class="select_ckbox_1">	
						<label><input type="checkbox" class="input_check_1" id="ck_null" name="result_1" value="${lctre.lc_Lctre_No}" />관심
						<input type="hidden" name="in_Lctre_No" value="${lctre.lc_Lctre_No}"/><%-- <input type="hidden" value="${lctre.in_Stdnt_No}"/> --%></label></td>
					
					<td class="select_ckbox_2">
						<label><input type="checkbox" class="input_check_2" id="ck_null" name="result_2" value="${lctre.lc_Lctre_No}" />수강
						
						<input type="hidden" name="re_Lctre_No" value="${lctre.lc_Lctre_No}"/><%-- <input type="hidden" value="${lctre.re_Stdnt_No}"/> --%></label></td>
						
					<td>${lctre.sit_Subjct}</td>
					<td>${lctre.lu_Lctre_Code}-${lctre.lc_Split}</td>
					<td>${lctre.lu_Grade }</td>
					<td><a href="#" >${lctre.lu_Lctre_Nm}</a></td>
					<td>${lctre.lu_Compl_Se}/${lctre.knd_Lctre_Knd}</td>
					<td>${lctre.pr_Nm}</td>
					<td>${lctre.lu_Pnt}</td>
					<td>${lctre.lc_Lctre_Time}</td>
					<td>${lctre.lc_Lctre_Nmpr}</td>
					<td>${lctre.lr_Accept_Nmpr}</td> 
				</tr>
			</c:forEach>
			<tr><td colspan="13" style="text-align: center;">${paging }</td></tr>				
					</tbody>
			</table>
	</form>
</div>
</body>
</html>
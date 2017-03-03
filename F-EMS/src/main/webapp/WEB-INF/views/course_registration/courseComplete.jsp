<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 수강신청이 완료된 강의 목록을 보여주는 JSP
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
function del_reqst(form){
	document.formm.submit();
}

</script>
<style>
body {
	/* background: #D9E5FF; */
}
</style>

</head>
<body class="course-list-l-bottom">
	<form name="formm" method="post">
<div class="text-center">
			<table  class="def-table-full tb-border table-hover">
				<tr>
					<th colspan="2" class="text-left"><input type="button" class="def-btn ckbtn-color" value="선택 삭제" onclick="del_reqst(this.form)"></th>
					<th colspan="11"><h4>수강 신청 완료 목록</h4></th>
				</tr>
				<tr>
					<th><label><input type="checkbox" id="check_all_3" class="input_check_2" />관심삭제</label></th>
					<th><label><input type="checkbox" id="check_all_1" class="input_check_1" />수강취소</label></th>
					<th>번호</th>
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

	 			<c:forEach items="${lctre_SearchVO}" var="lctre" varStatus="status">
				<tr class="slt_ckbox_${status.index}">
					<td class="select_ckbox_2">
						<label><input type="checkbox" class="input_check_2" id="ck_all_${status.index}"  name="result_1" value="${lctre.in_Lctre_No}" />삭제</label>
						<input type="hidden" value="${lctre.in_Lctre_No}"/><input type="hidden" value="${lctre.in_Stdnt_No}"/></td>  <!-- ${status.count} -->
					
					<td class="select_ckbox_1">
						<label><input type="checkbox" class="input_check_1" name="result_2" value="${lctre.re_Lctre_No}" />취소</label>
						<input type="hidden" value="${lctre.re_Lctre_No}"/><input type="hidden" value="${lctre.in_Stdnt_No}"/></td>
					<td>${lctre.lc_Lctre_No}</td>
					<td>${lctre.sit_Subjct}</td>
					<td>${lctre.lu_Lctre_Code}-${lctre.lc_Split}</td>
					<td><a href="#" >${lctre.lu_Lctre_Nm }</a></td> <!-- 강의계획서 조회 넣을것 -->
					<td>${lctre.lu_Grade }</td>
					<td>${lctre.lu_Compl_Se}/${lctre.knd_Lctre_Knd}</td>
					<td>${lctre.pr_Nm}</td>
					<td>${lctre.lu_Pnt}</td>
					<td>${lctre.lc_Lctre_Time}</td>
					<td>${lctre.lc_Lctre_Nmpr}</td>
					<td>${lctre.lr_Accept_Nmpr}</td> 
				</tr>
			</c:forEach> 
			</table>

</div>
	</form>
</body>
</html>
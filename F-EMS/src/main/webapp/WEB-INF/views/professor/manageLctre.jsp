<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
* <pre>
* 
* </pre>
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 2. 27.      JAR      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('.mngLctre').keyup(function(){
		var id='#'+$(this).attr('id');
		var att = $(id+'>td>input[name="gd_Attd_Score"]').val()*1;
		var ate = $(id+'>td>input[name="gd_Atend_Score"]').val()*1;
		var tsk = $(id+'>td>input[name="gd_Task_Score"]').val()*1;
		var mid = $(id+'>td>input[name="gd_Midex_Score"]').val()*1;
		var fne = $(id+'>td>input[name="gd_Fnex_Score"]').val()*1;
		var min = $(id+'>td>input[name="gd_Mini_Score"]').val()*1;
		var total = att+ate+tsk+mid+fne+min;
		$(id+'>td>input[name="gd_Tot_Score"]').val(total);
	});
});
</script>
</head>
<body>
<table class="non-border margin-auto"><tr><td>
<h2>성적 관리</h2>
	<table class="def-table-full tb-border table-hover">
		<tr>
			<th>학생번호</th>
			<th>성적</th>
			<th>총점수</th>
			<th>태도 점수</th>
			<th>출석 점수</th>
			<th>과제 점수</th>
			<th>중간 점수</th>
			<th>기말 점수</th>
			<th>수시 점수</th>
			<th>등록</th>
		</tr>
		<c:forEach items="${lctreList}" var="lct" varStatus="status">
		<tr class="mngLctre" id="${status.count}">
			<td><input type="text" name="gd_Stdnt_No" readonly value="${lct.gd_Stdnt_No}" class="def-input-text-lg custom-form-control"/></td>
			<td><input type="number" name="gd_Grade" value="${lct.gd_Grade}" class="def-input-text-sm custom-form-control"/></td>
			<td><input type="number" name="gd_Tot_Score" readonly value="${lct.gd_Tot_Score}" class="def-input-text-sm custom-form-control"/></td>
			<td><input type="number" name="gd_Attd_Score" value="${lct.gd_Attd_Score}" class="def-input-text-sm custom-form-control"/></td>
			<td><input type="number" name="gd_Atend_Score" value="${lct.gd_Atend_Score}" class="def-input-text-sm custom-form-control"/></td>
			<td><input type="number" name="gd_Task_Score" value="${lct.gd_Task_Score}" class="def-input-text-sm custom-form-control"/></td>
			<td><input type="number" name="gd_Midex_Score" value="${lct.gd_Midex_Score}" class="def-input-text-sm custom-form-control"/></td>
			<td><input type="number" name="gd_Fnex_Score" value="${lct.gd_Fnex_Score}" class="def-input-text-sm custom-form-control"/></td>
			<td><input type="number" name="gd_Mini_Score" value="${lct.gd_Mini_Score}" class="def-input-text-sm custom-form-control"/></td>
			<td>
			<input type="hidden" name="gd_Lctre_No" value="${lct.gd_Lctre_No}"/>
			<button onclick="manageLctre(${status.count})" class="def-ckbtn btn-sm ckbtn-color">등록</button>
			</td>
		</tr>
		</c:forEach>
	</table>
<a href="<%=request.getContextPath()%>/profsr/ongoingLctreList?tpage=${tpage}"><button class="def-btn btn-sm ckbtn-color">진행 강의 목록</button></a>
</td></tr></table>
</body>
</html>
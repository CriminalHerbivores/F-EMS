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
<script src="https://code.jquery.com/jquery.min.js"></script>
<script>
function manageLctre(data){
	var result = "#"+data;
	$(result).find("td").each(function(i,item){
		console.log("i:"+i+"item:"+ $.trim($(item).html())); 
	})
}
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
		<c:forEach items="${lctreList}" var="lct">
		<tr id="${lct.gd_Stdnt_No}">
			<td><input type="text" name="gd_Stdnt_No" value="${lct.gd_Stdnt_No}" class="def-input-text-sm custom-form-control"/></td>
			<td><input type="text" name="gd_Grade" value="${lct.gd_Grade}" class="def-input-text-sm custom-form-control"/></td>
			<td><input type="text" name="gd_Tot_Score" value="${lct.gd_Tot_Score}" class="def-input-text-sm custom-form-control"/></td>
			<td><input type="text" name="gd_Attd_Score" value="${lct.gd_Attd_Score}" class="def-input-text-sm custom-form-control"/></td>
			<td><input type="text" name="gd_Atend_Score" value="${lct.gd_Atend_Score}" class="def-input-text-sm custom-form-control"/></td>
			<td><input type="text" name="gd_Task_Score" value="${lct.gd_Task_Score}" class="def-input-text-sm custom-form-control"/></td>
			<td><input type="text" name="gd_Midex_Score" value="${lct.gd_Midex_Score}" class="def-input-text-sm custom-form-control"/></td>
			<td><input type="text" name="gd_Fnex_Score" value="${lct.gd_Fnex_Score}" class="def-input-text-sm custom-form-control"/></td>
			<td><input type="text" name="gd_Mini_Score" value="${lct.gd_Mini_Score}" class="def-input-text-sm custom-form-control"/></td>
			<td><button onclick="manageLctre(${lct.gd_Stdnt_No})" class="def-ckbtn btn-sm ckbtn-color">등록</button></td>
		</tr>
		</c:forEach>
	</table>
</td></tr></table>
</body>
</html>
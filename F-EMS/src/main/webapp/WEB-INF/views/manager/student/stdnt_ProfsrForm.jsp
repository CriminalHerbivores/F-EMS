<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spting" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
* [[개정이력(Modification Information)]]
* 수정일      수정자      수정내용
* ----------  ---------  -----------------
* 2017.03.06.    KJS      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
function go_StdntList(){
	var key = $('#stdnrKey').val();
	var value = $('#stdntValue').val();
	alert(key+" , "+value);
	var data = { "key" : value,"aaa":'asdasd'};
	
	var head = "<tr><th>학번</th><th>이름</th><th>학과</th><th>담당교수</th></tr>";
	$.ajax({
	       url:'<%=request.getContextPath()%>/sklstf/stdnt_Profsr_stdntList',
	       contentType:'application/json; charset=utf-8',
	       dataType:'text',
	       data:JSON.stringify(data),
	       type:'post',
	       success : function(data){
	    	   $('#stdntListTable').val('');
		       $('#stdntListTable').empty();
	           $('#stdntListTable').append(head+data);
	     },
	       error:function(error){
	       alert("오류났음");   
	       }
	    });
}

</script>
</head>
<body>
	<h2>교수 배정</h2>
	<br />
	<form name="formm">
	<table class="def-table-full">
		<tr>
			<td style="text-align: left;">
			<select id="stdnrKey" class="combobox-md custom-form-control">
					<option value="st_Stdnt_No">학생 번호</option>
					<option value="st_Nm">이름</option>
					<option value="st_Subjct_Code">학과</option>
			</select>&nbsp;&nbsp; <input type="text" id="stdntValue"
				class="def-input-text-lg custom-form-control">&nbsp;&nbsp; <input
				type="button" onclick="go_StdntList()"
				class="def-btn btn-sm btn-color" value="조회"></td>
		</tr>
	</table>
	<table id="stdntListTable"class="def-table-full tb-border table-hover">
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>학과</th>
			<th>담당교수</th>
		</tr>

		<c:forEach var="stdnt" items="${stdntList }">
			<tr>
				<td>${stdnt.st_Stdnt_No}</td>
				<td>${stdnt.st_Nm}</td>
				<td>${stdnt.sit_Subjct}</td>
				<td>${stdnt.st_Profsr_No}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" style="text-align: center;">${paging }</td>
		</tr>
	</table>
	
	<table class="def-table-full">
		<tr>
			<td style="text-align: left;"><select name="key"
				class="combobox-md custom-form-control">
					<option value="st_Stdnt_No">교수 번호</option>
					<option value="st_Nm">이름</option>
					<option value="st_Subjct_Code">학과</option>
			</select>&nbsp;&nbsp; <input type="text" name="value"
				class="def-input-text-lg custom-form-control">&nbsp;&nbsp; <input
				type="button" onclick="searchMe(this.form)"
				class="def-btn btn-sm btn-color" value="조회"></td>
				<td></td> <td>학생 번호 : <input type="text" name="value"
				class="def-input-text-lg custom-form-control"></td>
		</tr>
	</table>
	
	<table class="def-table-full tb-border table-hover">
		<tr>
			<th>교수 번호</th>
			<th>이름</th>
			<th>학과</th>
			<th>선택</th>
		</tr>

		<c:forEach var="profsr" items="${profsrList }">
			<tr>
				<td>${profsr.pr_Profsr_No}</td>
				<td>${profsr.pr_Nm}</td>
				<td>${profsr.sit_Subjct}</td>
				<td>배정/철회</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" style="text-align: center;">${paging }</td>
		</tr>
	</table>
	</form>
</body>
</html>

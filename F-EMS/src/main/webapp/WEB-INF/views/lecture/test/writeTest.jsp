<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.25    송선호            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(function(){
	$('#addrow').click(function(){
		$('#testtable > tbody:last').append('<tr><td><input type="text" class="def-input-text-full custom-form-control" name="ques" ></td><td><input type="text" class="def-input-text-md custom-form-control" name="ca"> <input type="button" class="def-btn btn-sm btn-color" onclick="deltest(this);" value="삭제"></td></tr>');
	});
});
function deltest(obj){
	var tr = $(obj).parent().parent();
	tr.remove();
}

</script>
</head>
<body>

<table style="width:100%;" class="non-border margin-auto">
<tr><td>
  <form name="formm" method="post">
	<table class="def-table-auto tb-border table-hover" id="testtable">
		<tr>
			<td style="padding-top: 0;padding-bottom: 0">	
				<table class="def-table-auto tb-border table-hover"  style="width:100%;">
					<tr>
						<th>시험명</th>
						<td style="width:80%;"><input type="text" class="def-input-text-full custom-form-control" name="tp_Nm"></td>
					</tr>
				</table>
			</td>
			<td>
				<input type="button" id="addrow" class="def-btn btn-md btn-color" value="+추가">
			</td>
		</tr>
	
		<tr>
			<th style="width:80%;">문제</th>
			<th>정답</th>
		</tr>
		
		<tr>
			<td>
				<input type="text" class="def-input-text-full custom-form-control" name="ques" >
			</td>
			<td>
				<input type="text" class="def-input-text-md custom-form-control" name="ca">
				<input type="button" class="def-btn btn-sm btn-color" onclick="deltest(this);" value="삭제">
			</td>
		</tr>
		
			<tbody></tbody>
		
		
	</table>
		<input style="float:right;" type="button" class="def-btn btn-md btn-color" value="등록" onclick="submitForm(this.form);">
	</form>
</td></tr>
</table>
</body>
</html>
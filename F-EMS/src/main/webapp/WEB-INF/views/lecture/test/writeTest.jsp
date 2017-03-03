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
	$('#Jaddrow').click(function(){
		$('#testtable > tbody:last').append(
				'<tr><td><input type="text" class="def-input-text-full custom-form-control" name="ques" placeholder="주관식 문제를 입력하세요." ></td>'
				+'<input type="hidden" class="def-input-text-full custom-form-control" name="te_No1" value="" >'
				+'<input type="hidden" class="def-input-text-full custom-form-control" name="te_No2" value="" >'
				+'<input type="hidden" class="def-input-text-full custom-form-control" name="te_No3" value="" >'
				+'<input type="hidden" class="def-input-text-full custom-form-control" name="te_No4" value="" >'
				+'<td><input type="text" class="def-input-text-md custom-form-control" name="ca">'
				+'<input type="button" class="def-btn btn-sm btn-color" onclick="deltest(this);" value="삭제">'
				+'</td></tr>');
	});
	$('#Gaddrow').click(function(){
		$('#testtable > tbody:last').append(
				'<tr><td><input type="text" class="def-input-text-full custom-form-control" name="ques" placeholder="객관식 문제를 입력하세요.">'
				+'<input type="text" class="def-input-text-full custom-form-control" name="te_No1" value="1. " >'
				+'<input type="text" class="def-input-text-full custom-form-control" name="te_No2" value="2. " >'
				+'<input type="text" class="def-input-text-full custom-form-control" name="te_No3" value="3. " >'
				+'<input type="text" class="def-input-text-full custom-form-control" name="te_No4" value="4. " >'
				+'</td><td><select name="ca" class="combobox-sm custom-form-control">'
				+'<option value="1">1</option>'
				+'<option value="2">2</option>'
				+'<option value="3">3</option>'
				+'<option value="4">4</option>'
				+'</select>'
				+'<input type="button" class="def-btn btn-sm btn-color" onclick="deltest(this);" value="삭제"></td></tr>');
	});
});
function deltest(obj){
	var tr = $(obj).parent().parent();
	tr.remove();
}

</script>

<!-- datepicker 부분  -->
<script>
  
  $(function() {
    $("#Start_Dt, #End_Dt").datepicker();
  });
  
</script>
<!-- ---------------- -->


</head>
<body>
<h2>시험 출제</h2><br/>
  <form name="formm" method="post">
	<table class="def-table-full tb-border table-hover" id="testtable">
		<tr>
			<td style="padding-top: 0;padding-bottom: 0">	
				<table class="def-table-auto tb-border table-hover"  style="width:100%;">
					<tr>
						<th>시험명</th>
						<td style="width:80%;"><input type="text" class="def-input-text-full custom-form-control" name="tp_Nm"></td>
					</tr>
					<tr>
						<th>응시가능기간</th>
						<td>
						<input type="text" id="Start_Dt" name="start_Dt" class="def-input-text-md custom-form-control">
						<input type="time" id="Start_Dt2" name="start_Dt2" class="def-input-text-md custom-form-control">
						&nbsp; ~ &nbsp;
						<input type="text" id="End_Dt" name="end_Dt" class="def-input-text-md custom-form-control">
						<input type="time" id="End_Dt2" name="end_Dt2" class="def-input-text-md custom-form-control">
						</td>
					</tr>
				</table>
			</td>
			<td>
				<input type="button" id="Jaddrow" class="def-btn btn-md btn-color" value="+주관식">
				<input type="button" id="Gaddrow" class="def-btn btn-md btn-color" value="+객관식">
			</td>
		</tr>

		<tr>
			<th style="width:80%;">문제</th>
			<th>정답</th>
		</tr>
		
<!-- 		<tr>
			<td>
				<input type="text" class="def-input-text-full custom-form-control" name="ques" >
			</td>
			<td>
				<input type="text" class="def-input-text-md custom-form-control" name="ca">
				<input type="button" class="def-btn btn-sm btn-color" onclick="deltest(this);" value="삭제">
			</td>
		</tr> -->
		
			<tbody></tbody>
		
		
	</table>
	<table class="def-table-full"><tr><td style="text-align: right;">
		<input style="float:right;" type="button" class="def-btn btn-md btn-color" value="취소" onclick="history.go(-1);">
		<input style="float:right;" type="button" class="def-btn btn-md btn-color" value="등록" onclick="submitForm(this.form);">
	</td></tr></table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
		$('#testtable > tbody:last').append('<tr><td><input type="text" class="def-input-text-full custom-form-control" name="addQue" ></td><td><input type="text" class="def-input-text-md custom-form-control" name="addCa"> <input type="button" class="def-btn btn-sm btn-color" onclick="deltest(this);" value="삭제"></td></tr>');
	});
});

function deltest(obj){
	var tr = $(obj).parent().parent();
	tr.remove();
}

function deleteQues(qno){

	var data ={'queNo' : qno};
	
	$.ajax({
		url:'<%=request.getContextPath()%>/lctre/deleteQues',
		contentType: 'application/json; charset=utf-8',
		dataType:'text',
		data:JSON.stringify(data),
		type:'post',
		success : function(data){
			var result = "#"+data;
			$(result).remove();
		},
		error:function(request,status,error){
		  alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		  }
	});
};




</script>
</head>
<body>
<table style="width:100%;" class="non-border margin-auto">
<tr><td>
  <form name="formm" method="post">
	<table class="def-table-auto tb-border table-hover" id="testtable">
		<tr>
			<td style="padding-top: 0;padding-bottom: 0; width:700px; ">	
				<table class="def-table-auto tb-border table-hover"  style="width:100%;">
					<tr>
						<th>시험명</th>
							<td style="width:80%;">
							<input type="text" class="def-input-text-full custom-form-control" name="tp_Nm" value=" ${tpNm }"> 
							<input type="hidden" name="tp_No" value="${tpNo}">
							</td>
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
		

		<c:forEach var="Qlist" items="${Qlist }" >
		<form method="post">
		<tr id="${Qlist.te_Ques_No }">
			<td>
				<input type="text" class="def-input-text-full custom-form-control"  name="que" value="${Qlist.te_Ques }">
			</td>
			<td>
				<input type="text" class="def-input-text-md custom-form-control" name="ca" value="${Qlist.te_Ca }">
				<input type="hidden" id="queNo" name="queNo" value="${Qlist.te_Ques_No }">
				<input type="button" class="def-btn btn-sm btn-color" value="삭제" onclick="deleteQues(${Qlist.te_Ques_No });">
			</td>
		</tr>
		</form>

		</c:forEach>
			<tbody></tbody>
		
		
	</table>
		
		<sec:authorize access="hasRole('ROLE_PRO')">
		<div style="float:right;">
			<input type="button" class="def-btn btn-md btn-color" value="수정" onclick="submitForm(this.form);">
			<a href="deleteTest?tpNo=${tpNo }"><input type="button" class="def-btn btn-md btn-color" value="삭제"></a>
			<input type="button" class="def-btn btn-md btn-color" value="목록" onclick="history.back()">
		</div>
		</sec:authorize>
	</form>
</td></tr>
</table>
	
</body>
</html>

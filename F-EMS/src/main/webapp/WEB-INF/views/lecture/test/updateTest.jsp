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
	$('#Jaddrow').click(function(){
		$('#testtable > tbody:last').append(
				'<tr><td><input type="text" class="def-input-text-full custom-form-control" name="addques" placeholder="주관식 문제를 입력하세요." ></td>'
				+'<input type="hidden" class="def-input-text-full custom-form-control" name="te_No1" value="" >'
				+'<input type="hidden" class="def-input-text-full custom-form-control" name="te_No2" value="" >'
				+'<input type="hidden" class="def-input-text-full custom-form-control" name="te_No3" value="" >'
				+'<input type="hidden" class="def-input-text-full custom-form-control" name="te_No4" value="" >'
				+'<td><input type="text" class="def-input-text-md custom-form-control" name="addca">'
				+'<input type="button" class="def-btn btn-sm btn-color" onclick="deltest(this);" value="삭제">'
				+'</td></tr>');
	});
	$('#Gaddrow').click(function(){
		$('#testtable > tbody:last').append(
				'<tr><td><input type="text" class="def-input-text-full custom-form-control" name="addques" placeholder="객관식 문제를 입력하세요.">'
				+'<input type="text" class="def-input-text-full custom-form-control" name="te_No1" value="1. " >'
				+'<input type="text" class="def-input-text-full custom-form-control" name="te_No2" value="2. " >'
				+'<input type="text" class="def-input-text-full custom-form-control" name="te_No3" value="3. " >'
				+'<input type="text" class="def-input-text-full custom-form-control" name="te_No4" value="4. " >'
				+'</td><td><select name="addca" class="combobox-sm custom-form-control">'
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
<!-- datepicker 부분  -->
<script>
  
  $(function() {
    $("#Start_Dt, #End_Dt").datepicker();
  });
  
</script>
<!-- ---------------- -->
</head>
<body>
<h2>시험 수정</h2><br/>
  <form name="formm" method="post">
	<table class="def-table-full tb-border table-hover" id="testtable">
		<tr>
			<td style="padding-top: 0;padding-bottom: 0; width:700px; ">	
				<table class="def-table-auto tb-border table-hover"  style="width:100%;">
					<tr>
						<th>시험명</th>
							<td style="width:80%;">
							<input type="text" class="def-input-text-full custom-form-control" name="tp_Nm" value="${tpNm }"> 
							<input type="hidden" name="tp_No" value="${tpNo}">
							</td>
					</tr>
					<tr>
						<th>응시가능기간</th>
						<td><input type="text" id="Start_Dt" name="tp_Start_Dt" class="def-input-text-md custom-form-control" value="${tpVO.tp_Start_Dt}"> &nbsp; ~ &nbsp;
						<input type="text" id="End_Dt" name="tp_End_Dt" value="${tpVO.tp_End_Dt}"  class="def-input-text-md custom-form-control">
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

		<c:forEach var="Qlist" items="${Qlist }" >
		<tr id="${Qlist.te_Ques_No }">
		<c:choose>
			<c:when test="${empty Qlist.te_No1 }">
				<td>
					<input type="text" class="def-input-text-full custom-form-control" name="ques" value="${Qlist.te_Ques }">
				</td>
				<td>
					<input type="text" class="def-input-text-md custom-form-control" name="ca" value="${Qlist.te_Ca }">
					<input type="hidden" id="queNo" name="queNo" value="${Qlist.te_Ques_No }">
					<input type="button" class="def-btn btn-sm btn-color" value="삭제" onclick="deleteQues(${Qlist.te_Ques_No });">
						<input type="hidden" class="def-input-text-full custom-form-control" name="no1" value= "${Qlist.te_No1 }">
						<input type="hidden" class="def-input-text-full custom-form-control" name="no2" value= "${Qlist.te_No2 }">
						<input type="hidden" class="def-input-text-full custom-form-control" name="no3" value= "${Qlist.te_No3 }">
						<input type="hidden" class="def-input-text-full custom-form-control" name="no4" value= "${Qlist.te_No4 }">
				</td>
			</c:when>
			
			<c:otherwise>
				<td>
						<input type="text" class="def-input-text-full custom-form-control" name="ques" value="${Qlist.te_Ques }">
						<input type="text" class="def-input-text-full custom-form-control" name="no1" value= "${Qlist.te_No1 }">
						<input type="text" class="def-input-text-full custom-form-control" name="no2" value= "${Qlist.te_No2 }">
						<input type="text" class="def-input-text-full custom-form-control" name="no3" value= "${Qlist.te_No3 }">
						<input type="text" class="def-input-text-full custom-form-control" name="no4" value= "${Qlist.te_No4 }">
				</td>
				<td>
					<select name="ca" class="combobox-sm custom-form-control">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
					<input type="hidden" id="queNo" name="queNo" value="${Qlist.te_Ques_No }">
					<input type="button" class="def-btn btn-sm btn-color" value="삭제" onclick="deleteQues(${Qlist.te_Ques_No });">
				</td>
			</c:otherwise>
			
		</c:choose>
		</tr>
		</c:forEach>
			<tbody></tbody>
		
		
	</table>
		
		<sec:authorize access="hasRole('ROLE_PRO')">
<table class="def-table-full"><tr><td style="text-align: right;">
			<input type="button" class="def-btn btn-md btn-color" value="수정" onclick="submitForm(this.form);">
			<a href="deleteTest?tpNo=${tpNo }"><input type="button" class="def-btn btn-md btn-color" value="삭제"></a>
			<input type="button" class="def-btn btn-md btn-color" value="취소" onclick="history.back()">
</td></tr></table>
		</sec:authorize>
	</form>
	
</body>
</html>

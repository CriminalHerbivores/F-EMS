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
* 2017.03.07.    KJS      추가작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
function go_StdntList(num){
	var key = $('#stdnrKey').val();
	var value = $('#stdntValue').val();
	var data;
	if(key == "st_Stdnt_No"){
		data = {"st_Stdnt_No" : value , "tpage" : num};		
	}else if(key == "st_Nm"){
		data = {"st_Nm" : value, "tpage" : num};	
	}else{
		data = {"sit_Subjct" : value, "tpage" : num};
	}
	
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
	           $('#tpage').val(num);
	           
	     },
	       error:function(error){
	       alert("오류났음");   
	       }
	    });
}

function go_ProfsrList(num){
	var key = $('#profsrKey').val();
	var value = $('#ProfsrValue').val();
	var data;
	if(key == "pr_Profsr_No"){
		data = {"pr_Profsr_No" : value, "tpage" : num};		
	}else if(key == "pr_Nm"){
		data = {"pr_Nm" : value, "tpage" : num};	
	}else{
		data = {"sit_Subjct" : value, "tpage" : num};
	}
	
	var head = "<tr><th>교수 번호</th><th>이름</th><th>학과</th><th>선택</th></tr>";
	$.ajax({
	       url:'<%=request.getContextPath()%>/sklstf/stdnt_Profsr_ProfsrList',
	       contentType:'application/json; charset=utf-8',
	       dataType:'text',
	       data:JSON.stringify(data),
	       type:'post',
	       success : function(data){
	    	   $('#profsrListTable').val('');
		       $('#profsrListTable').empty();
	           $('#profsrListTable').append(head+data);
	     },
	       error:function(error){
	       alert("오류났음");   
	       }
	    });
}

function stdnt_No(nm){
	var name = nm+"";
	$("#Stdnt_No").val(name);
}

function stdnt_Profsr_no(pr_Profsr_No){
	var st_Stdnt_No = $("#Stdnt_No").val();
	var data ={"st_Stdnt_No" : st_Stdnt_No, "st_Profsr_No" : pr_Profsr_No};
	var tpage = $("#tpage").val();
	$.ajax({
	       url:'<%=request.getContextPath()%>/sklstf/insetSt_Profsr_No',
	       contentType:'application/json; charset=utf-8',
	       dataType:'text',
	       data:JSON.stringify(data),
	       type:'post',
	       success : function(data){
	    	   go_StdntList(tpage)
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
	<input type="hidden" id="tpage" name="tpage">
	<table class="def-table-full">
		<tr>
			<td style="text-align: left;">
			<select id="stdnrKey" class="combobox-md custom-form-control">
					<option value="st_Stdnt_No">학생 번호</option>
					<option value="st_Nm">이름</option>
					<option value="sit_Subjct">학과</option>
			</select>&nbsp;&nbsp; <input type="text" id="stdntValue"
				class="def-input-text-lg custom-form-control">&nbsp;&nbsp; <input
				type="button" onclick="go_StdntList('1')"
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
		<tr>
			<td colspan="5" style="text-align: center;">${paging }</td>
		</tr>
	</table>
	
	<table class="def-table-full">
		<tr>
			<td style="text-align: left;"><select id="profsrKey"
				class="combobox-md custom-form-control">
					<option value="pr_Profsr_No">교수 번호</option>
					<option value="pr_Nm">이름</option>
					<option value="sit_Subjct">학과</option>
			</select>&nbsp;&nbsp; <input type="text" id="ProfsrValue"
				class="def-input-text-lg custom-form-control">&nbsp;&nbsp; <input
				type="button" onclick="go_ProfsrList('1')"
				class="def-btn btn-sm btn-color" value="조회"></td>
				<td></td> <td>학생 번호 : <input type="text" id="Stdnt_No" name="st_Stdnt_No"
				class="def-input-text-lg custom-form-control"></td>
		</tr>
	</table>
	
	<table id="profsrListTable" class="def-table-full tb-border table-hover">
		<tr>
			<th>교수 번호</th>
			<th>이름</th>
			<th>학과</th>
			<th>선택</th>
		</tr>

		<tr>
			<td colspan="5" style="text-align: center;">${paging }</td>
		</tr>
	</table>
	</form>
</body>
</html>

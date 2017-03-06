<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<style>
body {
	/* background: #D4F4FA; */
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
<%-- 
$(document).ready(function(){
	
	// 체크박스로 체크하는 것에 따라 적용
	//http://zero-gravity.tistory.com/241
	$("#selectCkBox").click(function(){
		
		 //var userId = $("#userId").val();
		 
		    // name이 같은 체크박스의 값들을 배열에 담는다.
		    var arrLctre_Knd = [];
		    var arrCompl_Se = [];
		    
		    $("input[name='knd_Lctre_Knd']:checked").each(function(i) {
		    	arrLctre_Knd.push($(this).val());
		    });
		    
		    $("input[name='lu_Compl_Se']:checked").each(function(i) {
		    	arrCompl_Se.push($(this).val());
		    });
		    
		     
		    // 사용자 ID(문자열)와 체크박스 값들(배열)을 name/value 형태로 담는다.
		     
		    $.ajax({
		        url:'<%=request.getContextPath()%>/course/courseAble',
		        contentType:'application/json;',
		        type:'get',
		        data:{ "checkLctre_Knd": arrLctre_Knd, "checkCompl_Se": arrCompl_Se },
		        success:function(data){
		            alert("완료!");
		            window.opener.location.reload();
		            self.close();
		        },
		        error:function(jqXHR, textStatus, errorThrown){
		            alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
		            self.close();
		        }
		    });
		    
		    //---------------------------------------------------------------------
		    
	});	// click

}); --%>

function add_reqst(form){
	alert("수강신청");
	
	
	
	document.formm.submit();
	
	
}
/* function go_searchLctre(){
	 */
	
<%-- 	 var userId = $("#userId").val();
	 
    // name이 같은 체크박스의 값들을 배열에 담는다.
    var checkboxValues = [];
    $("input[name='hobby']:checked").each(function(i) {
        checkboxValues.push($(this).val());
    });
     
    // 사용자 ID(문자열)와 체크박스 값들(배열)을 name/value 형태로 담는다.
    var allData = { "userId": userId, "checkArray": checkboxValues };
     
    $.ajax({
        url:'<%=request.getContextPath()%>/course/courseList',
        type:'GET',
        data: allData,
        success:function(data){
            alert("완료!");
            window.opener.location.reload();
            self.close();
        },
        error:function(jqXHR, textStatus, errorThrown){
            alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
            self.close();
        }
    });
	 --%>
	
	
	
	
/* 	document.formm.submit();
} */



</script>



</head>
<body class="course-list-l-top">
<article>

	<div class="text-center">
	<table class="def-table-full">
	<thead class="def-table-full fix-top">
	<tr><td class="text-right">
<form name="forrm" method="get">
	<input type="hidden" id="userId" value="${loginUser}">
	<label><input type="checkbox" id="selectCkBox" name="lu_Compl_Se" value="전공" >전공</label>&nbsp;&nbsp;<label><input type="checkbox" id="selectCkBox" name="lu_Compl_Se" value="교양" >교양</label>&nbsp;&nbsp;
	<label><input type="checkbox" id="selectCkBox" name="knd_Lctre_Knd" value="일반" >일반</label>&nbsp;&nbsp;<label><input type="checkbox" id="selectCkBox" name="knd_Lctre_Knd" value="사이버" >사이버</label>&nbsp;&nbsp;
	
	<select name="key" class="combobox-md custom-form-control">
					<option value="lu_Lctre_Nm">강의명</option>
					<option value="pr_Nm">담당교수</option>
					<option value="sit_Subjct">개설학과</option>
					<option value="lu_Lctre_Code">강의코드</option>
				</select>&nbsp;&nbsp;
					<input type="text" class="def-input-text-md custom-form-control" name="value">&nbsp;&nbsp;
					<input type="button" class="def-btn btn-search btn-color" onclick="go_searchLctre()" value="조회"></form>
		<form name="forrrm" method="get">			
					<input type="button" class="def-btn btn-search btn-color" id="courseDetailBtn" value="상세검색" onClick="disp()">&nbsp;&nbsp;
      <div class="non-disp">
      	<jsp:include page="courseDetailSearch.jsp" />
      </div></form>
					
	</td></tr></thead>
	</table>
	
	
	
	<form name="formm" method="post">
			<table class="def-table-full tb-border table-hover">
				<thead class="def-table-full fix-mid">
				<tr><th colspan="2" class="text-left"><input type="button" class="def-btn ckbtn-color" value="선택 추가" onclick="add_reqst(this.form)"></th>
				<th colspan="11"><h4>개설 강의 목록</h4></th></tr>
				<tr>
					<th><label><input type="checkbox" id="check_all_1" class="input_check_1" />관심강의</label></th>
					<th><label><input type="checkbox" id="check_all_3" class="input_check_2" />수강신청</label></th>
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
				</thead>
				
				
				
<%-- 				<%
List commentList = new ArrayList();

for (int i = 0; i < 5; i++) {
Map commentsMap = new HashMap();
commentsMap.put("no", i + 1);
commentsMap.put("name", "이름" + (i + 1));
commentList.add(commentsMap);
}

request.setAttribute("comments", commentList);
%> --%>
				
				
				<tbody>
				<!-- 체크박스 forEach안에서 행마다 연결되게 가능할까? -->
				<c:forEach items="${openLctreList}" var="lctre" varStatus="status" >
				<tr class="slt_ckbox_${status.index}">
					<td class="select_ckbox_1 select_ckbox_5" id="lc_${status.index}">	
						<label><input type="checkbox" class="input_check_1 input_check_5 " name="result_1" value="${lctre.lc_Lctre_No}" />관심
						<input type="hidden" name="in_Lctre_No" value="${lctre.lc_Lctre_No}"/></label></td>
					
					<td class="select_ckbox_2 select_ckbox_5" id="re_${status.index}">
						<label><input type="checkbox" class="input_check_2 input_check_5 " id="ck_all_${status.index}" name="result_2" value="${lctre.lc_Lctre_No}" />수강
						<input type="hidden" name="re_Lctre_No" value="${lctre.lc_Lctre_No}"/></label></td>
					<td>${lctre.lc_Lctre_No}</td>	
					<td>${lctre.sit_Subjct}</td>
					<td>${lctre.lu_Lctre_Code}-${lctre.lc_Split}</td>
					<td><a href="<%=request.getContextPath() %>/course/lectrePlan?lc_Lctre_No=${lctre.lc_Lctre_No}&tpage=${tpage}">${lctre.lu_Lctre_Nm}</a></td>
					<td>${lctre.lu_Grade }</td>
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
</div></article>
</body>
</html>

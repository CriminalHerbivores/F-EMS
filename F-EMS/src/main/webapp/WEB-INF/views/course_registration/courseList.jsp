<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
 * <pre>
 * 개설강의목록, 수강신청완료목록, 관심강의목록, 수강신청가능학점 페이지를 한번에 확인가능한 JSP
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script>

/* 시간표 띄우기 */
function op_timeTable(){
 
	swal({
		title : "Are you sure?",
		text : "You will not be able to recover this imaginary file!",
		type : "warning",
		showCancelButton : true,
		confirmButtonColor : "#DD6B55",
		confirmButtonText : "닫기",
		closeOnConfirm : false
	}, function (){
		swal("Deleted!", "Your imaginary file has been deleted.", "success");
	}); 
}

/* 개설강의 목록에서 검색하기 */
function go_searchLctre(){
	searchForm
	document.searchForm.submit();
}





/* <1구역> 개설강의 목록에서 추가 */
function add_Intrst_reqst(){
	//var userId = $("#userId").val();
	
	// name이 같은 체크박스의 값들을 배열에 담는다.
//     var resultVal_1 = [];
//     $("input[name='result_1']:checked").each(function(i) {
//     	resultVal_1.push($(this).val());
//     });
//     var resultVal_2 = [];
//     $("input[name='result_2']:checked").each(function(i) {
//     	resultVal_2.push($(this).val());
//     });
	
    /* var opLctre = { 
    		"ckArray_1": resultVal_1, 
    		"ckArray_2": resultVal_2, 
    		"lc_Lctre_No" : lc_Lctre_No,
    		"sit_Subjct" : sit_Subjct,
    		"lu_Lctre_Code" : lu_Lctre_Code,
    		"lc_Split" : lc_Split,
    		"lu_Lctre_Nm" : lu_Lctre_Nm,
    		"lu_Grade" : lu_Grade,
    		"lu_Compl_Se" : lu_Compl_Se,
    		"knd_Lctre_Knd" : knd_Lctre_Knd,
    		"pr_Nm" : pr_Nm,
    		"lu_Pnt" : lu_Pnt,
    		"lc_Lctre_Time" : lc_Lctre_Time,
    		"lc_Lctre_Nmpr" : lc_Lctre_Nmpr,
    		"lr_Accept_Nmpr" : lr_Accept_Nmpr
    		}; */
	
    
    $.ajax({
        url:'<%=request.getContextPath()%>/course/courseList',
        type:'post',
        data: {
        	resultVal_1: $('#result_1').val(), 
    		resultVal_2: $('result_2').val(), 
    		lc_Lctre_No: $('#lc_Lctre_No').val(),
    		sit_Subjct: $('#sit_Subjct').val(),
    		lu_Lctre_Code: $('#lu_Lctre_Code').val(),
    		lc_Split: $('#lc_Split').val(),
    		lu_Lctre_Nm: $('#lu_Lctre_Nm').val(),
    		lu_Grade: $('#lu_Grade').val(),
    		lu_Compl_Se: $('#lu_Compl_Se').val(),
    		knd_Lctre_Knd: $('#knd_Lctre_Knd').val(),
    		pr_Nm: $('#pr_Nm').val(),
    		lu_Pnt: $('#lu_Pnt').val(),
    		lc_Lctre_Time: $('#lc_Lctre_Time').val(),
    		lc_Lctre_Nmpr: $('#lc_Lctre_Nmpr').val(),
    		lr_Accept_Nmpr: $('#lr_Accept_Nmpr').val()
        },
        success:function(res){
            $('#openList_tr').remove();	/* 모든 <tr>요로 삭제 후 새로 리스트 불러오는걸로... */
            /* 개설강의목록 */
            
            $('#openList table > tbody:first').append(data);
            $.each(res, function(index){
            	
            	var row="";
            	row+= '<tr class="slt_ckbox_${status.index}">'
            		+'<td class="select_ckbox_1 select_ckbox_5" id="lc_${status.index}"><label><input type="checkbox" class="input_check_1 input_check_5 " name="result_1" value="'+res.lc_Lctre_No+'" />관심</label></td>'
					+'<td class="select_ckbox_2 select_ckbox_5" id="re_${status.index}"><label><input type="checkbox" class="input_check_2 input_check_5 " id="ck_all_${status.index}" name="result_2" value="'+res.lc_Lctre_No+'" />수강</label></td>'
            		+'<td>'+res.lc_Lctre_No+'</td>'	
            		+'<td>'+res.sit_Subjct+'</td>'
		            +'<td>'+res.lu_Lctre_Code+'-'+res.lc_Split+'</td>'
            		+'<td>'
            		+'<a href="'+<%=request.getContextPath() %>+'/course/lectrePlan?lc_Lctre_No='+res.lc_Lctre_No+'&tpage=${tpage}">'
            		+res.lu_Lctre_Nm+'</a></td>' 	
            		+'<td>'+res.lu_Grade+'</td>'
		            +'<td>'+res.lu_Compl_Se+'/'+res.knd_Lctre_Knd+'</td>'
            		+'<td>'+res.pr_Nm+'</td>'
            		+'<td>'+res.lu_Pnt+'</td>'
            		+'<td>'+res.lc_Lctre_Time+'</td>'
            		+'<td>'+res.lc_Lctre_Nmpr+'</td>'
            		+'<td>'+res.lr_Accept_Nmpr+'</td></tr>';
            });
        },
        
        error:function(jqXHR, textStatus, errorThrown){
            alert("실패 \n" + textStatus + " : " + errorThrown);
            self.close();
        }
    });
	
	alert("수강신청");
}



/* 기존에 하던거... */
<%-- 
/* 개설강의 목록에서 추가 */
function add_Intrst_reqst(){
	var userId = $("#userId").val();
	
	// name이 같은 체크박스의 값들을 배열에 담는다.
    var resultVal_1 = [];
    $("input[name='result_1']:checked").each(function(i) {
    	resultVal_1.push($(this).val());
    });
    var resultVal_2 = [];
    $("input[name='result_2']:checked").each(function(i) {
    	resultVal_2.push($(this).val());
    });
	
    var allData = { "userId": userId, "ckArray_1": resultVal_1, "ckArray_2": resultVal_2, "lc_Lctre_Nmpr":lc_Lctre_Nmpr};
	
    
    $.ajax({
        url:"<%=request.getContextPath()%>/course/insertCourse",
        type:'post',
        data: allData,
        success:function(res){
/*             alert("성공");
            window.opener.location.reload();
            self.close(); */
            
            /* 개설강의목록 */
            var row='';
            $.each(openLctre, function(i){
            	
            	row+= '<tr class="slt_ckbox_${status.index}"><td class="select_ckbox_1 select_ckbox_5" id="lc_${status.index}">	<label><input type="checkbox" class="input_check_1 input_check_5 " name="result_1" value="${openLctre.lc_Lctre_No'
            		+'}" />관심<input type="hidden" name="in_Lctre_No" value="${openLctre.lc_Lctre_No}"/></label></td>'
					+'<td class="select_ckbox_2 select_ckbox_5" id="re_${status.index}"><label><input type="checkbox" class="input_check_2 input_check_5 " id="ck_all_${status.index}" name="result_2" value="${openLctre.lc_Lctre_No}" />수강'
            		+'<input type="hidden" name="re_Lctre_No" value="${openLctre.lc_Lctre_No}"/></label></td>'
            		+'<td>${openLctre.lc_Lctre_No}</td>'	
            		+'<td>${openLctre.sit_Subjct}</td>'
		            +'<td>${openLctre.lu_Lctre_Code}-${openLctre.lc_Split}</td>'
            		+'<td><a href="<%=request.getContextPath() %>/course/lectrePlan?lc_Lctre_No=${openLctre[i].lc_Lctre_No}&tpage=${tpage}">${openLctre.lu_Lctre_Nm}</a></td>'
            		+'<td>${openLctre.lu_Grade}</td>'
		            +'<td>${openLctre.lu_Compl_Se}/${openLctre[i].knd_Lctre_Knd}</td>'
            		+'<td>${openLctre.pr_Nm}</td>'
            		+'<td>${openLctre.lu_Pnt}</td>'
            		+'<td>${openLctre.lc_Lctre_Time}</td>'
            		+'<td>${'+openLctre[i].lc_Lctre_Nmpr+'}</td>'
            		+'<td>${openLctre.lr_Accept_Nmpr}</td></tr>';
      
            		
            		
            		
            		
            	row+= '<tr class="slt_ckbox_${status.index}"><td class="select_ckbox_1 select_ckbox_5" id="lc_${status.index}">	<label><input type="checkbox" class="input_check_1 input_check_5 " name="result_1" value="${'+openLctre.lc_Lctre_No
        		+'}" />관심<input type="hidden" name="in_Lctre_No" value="${'+openLctre.lc_Lctre_No+'}"/></label></td>'
				+'<td class="select_ckbox_2 select_ckbox_5" id="re_${'+status.index+'}"><label><input type="checkbox" class="input_check_2 input_check_5 " id="ck_all_${status.index}" name="result_2" value="${'+openLctre.lc_Lctre_No+'}" />수강'
        		+'<input type="hidden" name="re_Lctre_No" value="${'+openLctre.lc_Lctre_No+'}"/></label></td>'
        		+'<td>${'+openLctre[i].lc_Lctre_No+'}</td>'	
        		+'<td>${'+openLctre[i].sit_Subjct+'}</td>'
	            +'<td>${'+openLctre[i].lu_Lctre_Code+'}-${'+openLctre[i].lc_Split+'}</td>'
        		+'<td><a href="<%=request.getContextPath() %>/course/lectrePlan?lc_Lctre_No=${'+openLctre[i].lc_Lctre_No+'}&tpage=${'+tpage+'}">${'+openLctre[i].lu_Lctre_Nm+'}</a></td>'
        		+'<td>${'+openLctre[i].lu_Grade+'}</td>'
	            +'<td>${'+openLctre[i].lu_Compl_Se+'}/${'+openLctre[i].knd_Lctre_Knd+'}</td>'
        		+'<td>${'+openLctre[i].pr_Nm+'}</td>'
        		+'<td>${'+openLctre[i].lu_Pnt+'}</td>'
        		+'<td>${'+openLctre[i].lc_Lctre_Time+'}</td>'
        		+'<td>${'+openLctre[i].lc_Lctre_Nmpr+'}</td>'
        		+'<td>${'+openLctre[i].lr_Accept_Nmpr+'}</td></tr>';
            		
            		
            });
            
            $("#insertCourse").append(row);

            /*  for (var i=0; i<res.length; i++){
        	col+='<td>'+allData[i]+'</td>';
        } */
            
            // 체크박스 항목이 null이 아닌걸 가져오고
            //일단 행에 있는 항목 하나하나 가져와서 변수에 담고..?
            // 거기에 새로운 값(컨트롤러에서 거쳐온)을 넣어준다
            
            //$('#insertCourse table > tbody').prepend(data);
			
           // $('#insertCourse table > tbody:last').find('tr:first').before(data); 
            
            
            
           // $('#insertCourse tr:first').after('<tr><td>first</td></tr>');
         },
        error:function(jqXHR, textStatus, errorThrown){
            alert("실패 \n" + textStatus + " : " + errorThrown);
            self.close();
        }
    });
    
    
	<td class="select_ckbox_1 select_ckbox_5" id="lc_${status.index}">	
	<label><input type="checkbox" class="input_check_1 input_check_5 " name="result_1" value="${openLctre.lc_Lctre_No}" />관심
	<input type="hidden" name="in_Lctre_No" value="${openLctre.lc_Lctre_No}"/></label></td>

<td class="select_ckbox_2 select_ckbox_5" id="re_${status.index}">
	<label><input type="checkbox" class="input_check_2 input_check_5 " id="ck_all_${status.index}" name="result_2" value="${openLctre.lc_Lctre_No}" />수강
	<input type="hidden" name="re_Lctre_No" value="${openLctre.lc_Lctre_No}"/></label></td>
<td>${openLctre.lc_Lctre_No}</td>	
<td>${openLctre.sit_Subjct}</td>
<td>${openLctre.lu_Lctre_Code}-${openLctre.lc_Split}</td>
<td><a href="<%=request.getContextPath() %>/course/lectrePlan?lc_Lctre_No=${openLctre.lc_Lctre_No}&tpage=${tpage}">${openLctre.lu_Lctre_Nm}</a></td>
<td>${openLctre.lu_Grade }</td>
<td>${openLctre.lu_Compl_Se}/${openLctre.knd_Lctre_Knd}</td>
<td>${openLctre.pr_Nm}</td>
<td>${openLctre.lu_Pnt}</td>
<td>${openLctre.lc_Lctre_Time}</td>
<td>${openLctre.lc_Lctre_Nmpr}</td>
<td>${openLctre.lr_Accept_Nmpr}</td> 
    
    
    
    
    
	
/* 
	var intrstLctre = document.openLctreListForm.getElementsByName("result_1").val();
	var reqstLctre = document.openLctreListForm.getElementsByName("result_2").val();
	if(intrstLctre=="" && reqstLctre==""){
		//document.getElementById("click_false").innerHTML = " 선택된 항목 없음<br>";
		setInterval(function(){ 
			document.getElementById("click_false").innerHTML = " 선택된 항목 없음<br>";
		}, 5000);
		return;
	}
	
	// re_Lctre_No_1 in_Lctre_No_1
	var add_reqstLctre = $('#re_Lctre_No_1').val();
	var add_intrstLctre = $('#in_Lctre_No_1').val();
	
	 */
	
	alert("수강신청");
} --%>

/* 수강완료 목록 */
function del_intrst_reqst(){
	//courseComplete
	
	
	alert("수강취소");
	document.completeForm.submit();
}

/* 관심목록에서 수강신청 */
function add_reqst(){
	
	
	//courseInterest
	
	
	
	
	
	
	alert(document.intrstLctreForm.value);
	document.getElementById("click_rst").innerHTML = "수강신청 좀 제발<br>";
	document.intrstLctreForm.submit();
}

/* 관심목록에서 관심 삭제 */
function del_intrst(){
	
	
	
/*     var a="이것도 테스트!<br>";
    var b="선택 항목 없음!<br>"
    
	//alert("테스트");
	if(document.getElementById("ck_null").ckeched){
		var c=document.getElementById("click_rst").innerHTML = "선택 항목 없음<br>";
	}else{
	
	document.formm.submit();
		var c=document.getElementById("click_rst").innerHTML = "if값 왜 못가져오나<br>";
	}
    document.getElementById("click_rst").innerHTML = a+b+c; */
    alert(document.formm.value);
    document.getElementById("click_rst").innerHTML = "관심삭제 좀 제발<br>";
    document.intrstLctreForm.submit();
    
   
}





</script>

</head>
<body>


	<!-- 상단바 시작 -->
	<nav class="navbar top-navbar-inverse" id="topnav">
		<div class="container-fluid" id="toptable">
			<div class="navbar-header" style="width: 100%;">
				<table id="topnav-table" style="width: 100%;">
					<tr style="width: 900px;">
					
						<td><a href="<%=request.getContextPath()%>/"> <img
								src="<%=request.getContextPath()%>${manageVO.mng_Univ_Logo}"
								id="logo"></a></td>
				</table> 
				
				<div class="float-right">
				
				
				
					<c:choose>
						<c:when test="${empty loginUser}">
							
		<input class="def-btn btn-sm btn-color" type="button" value="학생"
								onclick="login_student();" />&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/loginForm" class="no-uline"><button
									class="def-btn">Login</button></a>&nbsp;&nbsp;
				</c:when>
						<c:otherwise>
							<span>${loginUser}</span>&nbsp;&nbsp;
				<a href="<%=request.getContextPath()%>/logout"><button
									class="def-btn float-right">Logout</button></a>
						</c:otherwise>
					</c:choose>
					<a href="<%=request.getContextPath()%>/course/courseTimetable">
					<button type="button" class="def-btn btn-md btn-color"
						id="openmodal" data-toggle="modal" data-target="#myModal" onclick="op_timeTable()">시간표</button></a>&nbsp;&nbsp;
					<input type="button" class="def-btn btn-md btn-gray" onclick="go.history(-1)" value="이전" >
				</div>
			</div>
		</div>
	</nav>
	<!-- 상단바 끝 -->
	
	<div class="div-course-list-left">
			
			<!-- //////////////////////////////////////////////////////////// < 개설강의목록 > ////////////////////////////////////////////////////////////////////////// -->
			<div class="course-list-l-top">
<article>

	<div class="text-center">
	<table class="def-table-full">
	<thead class="def-table-full fix-top">
	<tr><td class="text-right">
<form name="searchForm" method="get">
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
		<form name="detailSearchForm" method="get">			
					<input type="button" class="def-btn btn-search btn-color" id="courseDetailBtn" value="상세검색" onClick="disp()">&nbsp;&nbsp;
      <div class="non-disp">
      	<jsp:include page="courseDetailSearch.jsp" />
      </div></form>
					
	</td></tr></thead>
	</table>
	
	
	
	<form name="openLctreListForm" method="post">
		<div id="openList">
			<p id="click_false">&nbsp;</p>
			<table class="def-table-full tb-border table-hover" >
				<thead class="def-table-full fix-mid">
				<tr><th colspan="2" class="text-left"><input type="button" class="def-btn ckbtn-color" value="선택 추가" onclick="add_Intrst_reqst()"></th>
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
				
				<tbody>  
				<c:forEach items="${openLctreList}" var="openLctre" varStatus="status" >
				<tr class="slt_ckbox_${status.index}" id="openList_tr">
					<td class="select_ckbox_1 select_ckbox_5" id="lc_${status.index}">	
						<label><input type="checkbox" class="input_check_1 input_check_5 " name="result_1" value="${openLctre.lc_Lctre_No}" id="result_1"/>관심
						<input type="hidden" name="in_Lctre_No" value="${openLctre.lc_Lctre_No}"/></label></td>
					
					<td class="select_ckbox_2 select_ckbox_5" id="re_${status.index}">
						<label><input type="checkbox" class="input_check_2 input_check_5 " id="ck_all_${status.index}" name="result_2" value="${openLctre.lc_Lctre_No}" id="result_2"/>수강
						<input type="hidden" name="re_Lctre_No" value="${openLctre.lc_Lctre_No}"/></label></td>
					<td>${openLctre.lc_Lctre_No}</td>	
					<td>${openLctre.sit_Subjct}</td>
					<td>${openLctre.lu_Lctre_Code}-${openLctre.lc_Split}</td>
					<td><a href="<%=request.getContextPath() %>/course/lectrePlan?lc_Lctre_No=${openLctre.lc_Lctre_No}&tpage=${tpage}">${openLctre.lu_Lctre_Nm}</a></td>
					<td>${openLctre.lu_Grade }</td>
					<td>${openLctre.lu_Compl_Se}/${openLctre.knd_Lctre_Knd}</td>
					<td>${openLctre.pr_Nm}</td>
					<td>${openLctre.lu_Pnt}</td>
					<td>${openLctre.lc_Lctre_Time}</td>
					<td>${openLctre.lc_Lctre_Nmpr}<input type="hidden" id="lc_Lctre_Nmpr" value="${openLctre.lc_Lctre_Nmpr}"/></td>
					<td>${openLctre.lr_Accept_Nmpr}</td> 
				</tr>
			</c:forEach>
			<tr><td colspan="13" style="text-align: center;">${paging }</td></tr>				
					</tbody>
			</table></div>
	</form>
</div></article>
</div>


			<!-- //////////////////////////////////////////////////////////// < 수강완료목록 > ////////////////////////////////////////////////////////////////////////// -->

<div class="course-list-l-bottom">
	<form name="completeForm" method="post">
<div class="text-center">
			<table  class="def-table-full tb-border table-hover">
				<tr>
					<th colspan="2" class="text-left"><input type="button" class="def-btn ckbtn-color" value="선택 삭제" onclick="del_intrst_reqst()"></th>
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
						<label><input type="checkbox" class="input_check_2" id="ck_all_${status.index}"  name="result_3" value="${lctre.in_Lctre_No}" />삭제</label>
						<input type="hidden" value="${lctre.in_Lctre_No}"/><input type="hidden" value="${lctre.in_Stdnt_No}"/></td>  <!-- ${status.count} -->
					
					<td class="select_ckbox_1">
						<label><input type="checkbox" class="input_check_1" name="result_4" value="${lctre.re_Lctre_No}" />취소</label>
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
</div>
				
	</div>
	
	<div class="div-course-list-right">
		
			
			<!-- //////////////////////////////////////////////////////////// < 관심등록목록 > ////////////////////////////////////////////////////////////////////////// -->
		
		<div class="course-list-r-bottom">
	<form name="intrstLctreForm" method="post">

		<div class="text-center" id="checkboxArea">
			<table class="def-table-full tb-border table-hover">
				<tr><th colspan="3">관심 강의 목록</th></tr>
				<tr><th><label><input type="checkbox" id="check_all_1" class="input_check_1" />전체 선택</label></th>
					<th>번호</th>
					<th>강의명</th>
				</tr>
				<c:forEach items="${intrstLctreList}" var="intrst">
					<tr><td>${intrst.in_Lctre_No}</td>
					<td class="select_ckbox_1">
						<label><input type="checkbox" class="input_check_1" id="ck_null" name="result" value="${intrst.in_Lctre_No}" />
						${intrst.lu_Lctre_Code }-${intrst.lc_Split }
						<input type="hidden" value="${intrst.in_Lctre_No}"/></label></td>
						<td><a href="#" >${intrst.lu_Lctre_Nm }</a></td> <!-- 강의계획서 조회 넣을것 -->
					</tr>
				</c:forEach>
		</table>
		<button class="def-btn ckbtn-color" value="addReqst" name="btn_result" onclick="add_reqst()">수강신청</button>&nbsp;&nbsp;
		<button class="def-btn ckbtn-gray" value="delIntrst" name="btn_result" onclick="del_intrst()">관심삭제</button>

		</div>
<p id="click_rst">&nbsp;</p>


	</form>
</div>
		<!-- //////////////////////////////////////////////////////////// < 신청학점확인 > ////////////////////////////////////////////////////////////////////////// -->


		<div class="course-list-r-top">
<form name="courseCredit">
<div class="text-center"><table  class="def-table-full tb-border">
	<tr><th>신청 가능 학점
	</th></tr>
	<tr><td><h3>18 - ${sumOfReqst} = ${ableOfReqst}</h3>
	</td></tr>
</table>
<br/>
<table  class="def-table-full tb-border">
	<tr><th>수강 신청 학점
	</th></tr>
	<tr><td><h3>${sumOfReqst}</h3>
	</td></tr>
</table>

</div>
</form>
</div>
		
<!-- //////////////////////////////////////////////////////////// < 끝 > ////////////////////////////////////////////////////////////////////////// -->		
			
			
	</div>

</body>
</html>

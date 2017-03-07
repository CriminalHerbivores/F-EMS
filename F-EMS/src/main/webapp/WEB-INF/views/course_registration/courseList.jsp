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
	
	/* document.topLctreForm.submit(); */
/* 	swal({   title: "<small>시간표</small>!",   
		text: "A custom <span style="color:#F8BB86">html<span> message.",   
		html: true });
}
 */

 }

/* 개설강의 목록에서 검색하기 */
function go_searchLctre(){
	searchForm
	document.searchForm.submit();
}


/* 관심추가 */
function add_IntrstLctre(){
	alert("관심추가 시작");
	// 체크를 한 tr 태그들을 목록화
	var array_1 = [];
	var array_2 = [];
	
	
	var row_1 = new Array();
	
	$(".result_1:checked").each(function(){
		var tr = $(this).closest("tr");
		
		var in_Stdnt_No= "${loginUser}";
		var temp=$(tr).find('.lc_Lctre_No');
		var in_Lctre_No= $(temp).text();
	// 한건의 tr 태그가 하나의 javascript 객체 형성
	// 여러건의 tr 태그, 즉 javascript 객체들이 하나의 배열 형성
		row_1= { "in_Stdnt_No" : in_Stdnt_No, "in_Lctre_No" : in_Lctre_No };
		array_1.push(row_1);
		});	// result_1:checked
		console.log(array_1);
	
	
	

	// 만들어진 배열을 json 형태로 변환
	var data = JSON.stringify(array_1);

	  $.ajax({
	        url:'insertInterest',
	        contentType:'application/json; charset=utf-8',
	        type:'post',
	        dataType: 'json',
	        data: data,
	        success:function(res){
	   			// 관심강의 목록
	            var tr_row_1="";
	            tr_row_1 += '<table class="def-table-full tb-border table-hover">'
				+'<thead><tr><th colspan="3">관심 강의 목록</th></tr>'
				+'<tr><th><label><input type="checkbox" id="check_all_6" class="input_check_6" />전체 선택</label></th>'
				+'<th>번호</th><th>강의명</th></tr></thead><tbody>';
	            $.each(res, function(index,intrst){
	            	tr_row_1 += '<tr id="intrstList_tr"><td class="select_ckbox_1">'
	            	    +'<label><input type="checkbox" class="input_check_6" name="result" value="'+res.in_Lctre_No+'" />'
	            		+intrst.lu_Lctre_Code+'-'+intrst.lc_Split+'</label></td>'
	            		+'<td>'+intrst.in_Lctre_No+'</td>'
	            		+'<td>'+intrst.lu_Lctre_Nm+'</td></tr>';
	            console.log("success : "+index);
	            });
	            tr_row_1+='</tbody></table>';
	            $("#intrstList").empty();
	            $("#intrstList").html(tr_row_1);
	            
	            // 수강완료 , 학점 - 변화 없음
	        },	// success
	        
	        error:function(jqXHR, textStatus, errorThrown){
	            alert("실패 \n" + textStatus + " : " + errorThrown);
	        }
	    });
}// function op_timeTable() 


/* 관심삭제 */
function del_IntrstLctre(){
	alert("관심삭제 시작");
	// 체크를 한 tr 태그들을 목록화
	var array = [];
	
	var row = new Array();
	
	$(".result:checked").each(function(){
		var tr = $(this).closest("tr");
		
		var in_Stdnt_No= "${loginUser}";
		var temp=$(tr).find('.lctre_No');
		var in_Lctre_No= $(temp).text();
	// 한건의 tr 태그가 하나의 javascript 객체 형성
	// 여러건의 tr 태그, 즉 javascript 객체들이 하나의 배열 형성
		row= { "in_Stdnt_No" : in_Stdnt_No, "in_Lctre_No" : in_Lctre_No };
		array.push(row);
		});	// result_1:checked
		console.log(array);

	// 만들어진 배열을 json 형태로 변환
	var data = JSON.stringify(array);

	  $.ajax({
	        url:'deleteInterest',
	        contentType:'application/json; charset=utf-8',
	        type:'post',
	        dataType: 'json',
	        data: data,
	        success:function(res){
	   			// 관심강의 목록
	            var row2="";
	            row2 += '<table class="def-table-full tb-border table-hover">'
				+'<thead><tr><th colspan="3">관심 강의 목록</th></tr>'
				+'<tr><th><label><input type="checkbox" id="check_all_6" class="input_check_6" />전체 선택</label></th>'
				+'<th>번호</th><th>강의명</th></tr></thead><tbody>';
	            $.each(res, function(index,intrst){
	            	row2 += '<tr id="intrstList_tr"><td class="select_ckbox_1">'
	            	    +'<label><input type="checkbox" class="input_check_6" name="result" value="'+res.in_Lctre_No+'" />'
	            		+intrst.lu_Lctre_Code+'-'+intrst.lc_Split+'</label></td>'
	            		+'<td>'+intrst.in_Lctre_No+'</td>'
	            		+'<td>'+intrst.lu_Lctre_Nm+'</td></tr>';
	            console.log("success : "+index);
	            });
	            row2+='</tbody></table>';
	            $("#intrstList").empty();
	            $("#intrstList").html(row2);
	            
	            // 수강완료 , 학점 - 변화 없음
	        },	// success
	        
	        error:function(jqXHR, textStatus, errorThrown){
	            alert("실패 \n" + textStatus + " : " + errorThrown);
	        }
	    });
}	// function del_IntrstLctre()

/* 수강신청 */
function add_reqstLctre(){
	
	alert("수강신청 시작");
	// 체크를 한 tr 태그들을 목록화
	var array = [];
	var row = new Array();
	
	$(".result:checked").each(function(){
		var tr = $(this).closest("tr");
		var re_Stdnt_No= "${loginUser}";
		var temp=$(tr).find('.lctre_No');
		var re_Lctre_No= $(temp).text();
	// 한건의 tr 태그가 하나의 javascript 객체 형성
	// 여러건의 tr 태그, 즉 javascript 객체들이 하나의 배열 형성
		row= { "re_Stdnt_No" : re_Stdnt_No, "re_Lctre_No" : re_Lctre_No };
		array.push(row);
	});	// result_1:checked
	
		console.log(array);
	// 만들어진 배열을 json 형태로 변환
	var data = JSON.stringify(array);
	
	  $.ajax({ 
	        url:'insertReqst',
	        contentType:'application/json; charset=utf-8',
	        type:'post',
	        dataType: 'json',
	        data: data,
	        success:function(res){
	        	
	        	
	        	// 관심목록
// 	        	var row2="";
// 	            row2 += '<table class="def-table-full tb-border table-hover">'
// 				+'<thead><tr><th colspan="3">관심 강의 목록</th></tr>'
// 				+'<tr><th><label><input type="checkbox" id="check_all_6" class="input_check_6" />전체 선택</label></th>'
// 				+'<th>번호</th><th>강의명</th></tr></thead><tbody>';
// 	            $.each(res, function(index,intrst){
// 	            	row2 += '<tr id="intrstList_tr"><td class="select_ckbox_1">'
// 	            	    +'<label><input type="checkbox" class="input_check_6" name="result" value="'+res.in_Lctre_No+'" />'
// 	            		+intrst.lu_Lctre_Code+'-'+intrst.lc_Split+'</label></td>'
// 	            		+'<td>'+intrst.in_Lctre_No+'</td>'
// 	            		+'<td>'+intrst.lu_Lctre_Nm+'</td></tr>';
// 	            console.log("success : "+index);
// 	            });
// 	            row2+='</tbody></table>';
// 	            $("#intrstList").empty();
// 	            $("#intrstList").html(row2);
	        	
	        	
	        	
	            // 수강완료 
	            var row3="";
	            /* row3 += '<table  class="def-table-full tb-border table-hover"><tr>'
	            		+'<th colspan="2" class="text-left"><input type="button" class="def-btn ckbtn-color" value="선택 삭제" onclick="del_intrst_reqst()"></th>'
	            		+'<th colspan="11"><h4>수강 신청 완료 목록</h4></th></tr>'
	            		+'<tr><th><label><input type="checkbox" id="all_ckeck_3" class="input_ck_2" />관심삭제</label></th>'
	            		+'<th><label><input type="checkbox" id="all_ckeck_1" class="input_ck_1" />수강취소</label></th>'
	            		+'<th>번호</th><th>개설학과</th><th>강의코드</th><th>강의명</th>
				<th>학년</th>
				<th>구분</th>
				<th>학점/시수</th>
				<th>담당교수</th>
				<th>강의시간</th>
				<th>수강인원</th>
				<th>제한인원</th>
			</tr>' */
			
	            
			$.each(res, function(index,lctre){
	            row3 += '<tr class="slt_ck_${status.index}"><td class="select_ck_2">'
	            		+'<label><input type="checkbox" class="input_ck_2 result_3" id="all_ck_${status.index}"  name="result_3" value="'+lctre.in_Lctre_No+'" />삭제</label></td>'
	            		+'<td class="select_ck_1"><label><input type="checkbox" class="input_ck_1 result_4" name="result_4" value="'+lctre.re_Lctre_No+'" />취소</label></td>'
	            		+'<td class="lc_Lctre_No">'+lctre.lc_Lctre_No+'</td>'
	            		+'<td>'+lctre.sit_Subjct+'</td>'
	            		+'<td>'+lctre.lu_Lctre_Code+'-'+lctre.lc_Split+'</td>'
	            		+'<td><a href="#" >'+lctre.lu_Lctre_Nm+'</a></td> <!-- 강의계획서 조회 넣을것 -->'
	            		+'<td>'+lctre.lu_Grade+'</td>'
	            		+'<td>'+lctre.lu_Compl_Se+'/'+lctre.knd_Lctre_Knd+'</td>'
	            		+'<td>'+lctre.pr_Nm+'</td>'
	            		+'<td>'+lctre.lu_Pnt+'</td>'
	            		+'<td>'+lctre.lc_Lctre_Time+'</td>'
	            		+'<td>'+lctre.lc_Lctre_Nmpr+'</td>'
	            		+'<td>'+lctre.lr_Accept_Nmpr+'</td></tr>';
			});
	            $("#reqstList").empty();
	            $("#reqstList").html(row3);
	            
	            //학점
	            
	        },	// success
	        
	        error:function(jqXHR, textStatus, errorThrown){
	            alert("실패 \n" + textStatus + " : " + errorThrown);
	        }
	    });
	
	
}



</script>

</head>
<body>


	<!-- 상단바 시작 -->
	<nav class="navbar top-navbar-inverse" id="topnav">
	<form name="topLctreForm" method="get">
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
				<button class="def-btn float-right">Logout</button></a>
						</c:otherwise>
					</c:choose>
					<a href="<%=request.getContextPath()%>/course/courseTimetable"><input type="button" class="def-btn btn-md btn-color"
						id="openmodal" data-toggle="modal" data-target="#myModal" onclick="op_timeTable()" value="시간표"></a>&nbsp;&nbsp;
					<input type="button" class="def-btn btn-md btn-gray" onclick="go.history(-1)" value="이전" >
				</div>
			</div>
		</div></form>
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
	<label><input type="checkbox" id="selectCkBox" name="lu_Compl_Se" value="전공" >전공</label>&nbsp;&nbsp;<label><input type="checkbox" id="selectCkBox" name="lu_Compl_Se" value="교양" >교양</label>&nbsp;&nbsp;
	<label><input type="checkbox" id="selectCkBox" name="knd_Lctre_Knd" value="일반" >일반</label>&nbsp;&nbsp;<label><input type="checkbox" id="selectCkBox" name="knd_Lctre_Knd" value="사이버" >사이버</label>&nbsp;&nbsp;
	
	<select name="key" class="combobox-md custom-form-control">
					<option value="lu_Lctre_Nm">강의명</option>
					<option value="pr_Nm">담당교수</option>
					<option value="sit_Subjct">개설학과</option>
					<option value="lu_Lctre_Code">강의코드</option>
				</select>&nbsp;&nbsp;
					<input type="text" class="def-input-text-md custom-form-control" name="value">&nbsp;&nbsp;
					<input type="button" class="def-btn btn-search btn-color" onclick="go_searchLctre()" value="조회"></form></td>
		<td><form name="detailSearchForm" method="get">			
					<input type="button" class="def-btn btn-search btn-color" id="courseDetailBtn" value="상세검색" onClick="disp()">&nbsp;&nbsp;
      <span class="non-disp">
      	<jsp:include page="courseDetailSearch.jsp" />
      </span></form>
					
	</td></tr></thead>
	</table>
	
	
	
	<!-- <form name="openLctreListForm" method="post"> -->
		<div id="openList">
			<p id="click_false">&nbsp;</p>
			<table class="def-table-full tb-border table-hover" >
				<thead class="def-table-full fix-mid">
				<tr><th colspan="2" class="text-left"><input type="button" class="def-btn ckbtn-color" value="선택 추가" onclick="add_IntrstLctre()"></th>
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
				<tr class="slt_ckbox_${status.index}">
					<td class="select_ckbox_1" id="lc_${status.index}">	
						<label><input type="checkbox" class="input_check_1 result_1" name="result_1" value="${openLctre.lc_Lctre_No}"/>관심</label></td>
					
					<td class="select_ckbox_2" id="re_${status.index}">
						<label><input type="checkbox" class="input_check_2 result_2" id="ck_all_${status.index}" name="
_2" value="${openLctre.lc_Lctre_No}" />수강
						<input type="hidden" name="re_Lctre_No" class="re_Lctre_No" value="${openLctre.lc_Lctre_No}"/></label>
						<input type="hidden" id="userId" class="re_Stdnt_No" value="${loginUser}"></td>
					<td class="lc_Lctre_No">${openLctre.lc_Lctre_No}</td>	
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
				</tr>
			</c:forEach>
			<tr><td colspan="13" style="text-align: center;">${paging}</td></tr>				
					</tbody>
			</table></div>
	<!-- </form> -->
</div></article>
</div>


			<!-- //////////////////////////////////////////////////////////// < 수강완료목록 > ////////////////////////////////////////////////////////////////////////// -->

<div class="course-list-l-bottom">
	<!-- <form name="completeForm" method="post"> -->
<div class="text-center" >
			<table  class="def-table-full tb-border table-hover">
			<thead>
				<tr>
					<th colspan="2" class="text-left"><input type="button" class="def-btn ckbtn-color" value="선택 삭제" onclick="del_intrst_reqst()"></th>
					<th colspan="11"><h4>수강 신청 완료 목록</h4></th>
				</tr>
				<tr>
					<th><label><input type="checkbox" id="all_ckeck_3" class="input_ck_2" />관심삭제</label></th>
					<th><label><input type="checkbox" id="all_ckeck_1" class="input_ck_1" />수강취소</label></th>
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
				<tbody id="reqstList">
	 			<c:forEach items="${lctre_SearchVO}" var="lctre" varStatus="status">
				<tr class="slt_ck_${status.index}">
					<td class="select_ck_2">
						<label><input type="checkbox" class="input_ck_2 result_3" id="all_ck_${status.index}"  name="result_3" value="${lctre.in_Lctre_No}" />삭제</label>
						<%-- <input type="hidden" value="${lctre.in_Lctre_No}"/><input type="hidden" value="${lctre.in_Stdnt_No}"/> --%></td>  <!-- ${status.count} -->
					<td class="select_ck_1">
						<label><input type="checkbox" class="input_ck_1 result_4" name="result_4" value="${lctre.re_Lctre_No}" />취소</label>
						<%-- <input type="hidden" value="${lctre.re_Lctre_No}"/><input type="hidden" value="${lctre.in_Stdnt_No}"/> --%></td>
					<td class="lc_Lctre_No">${lctre.lc_Lctre_No}</td>
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
			</tbody> 
			</table>

</div>
	<!-- </form> -->
</div>
				
	</div>
	
	<div class="div-course-list-right">
		
			
			<!-- //////////////////////////////////////////////////////////// < 관심등록목록 > ////////////////////////////////////////////////////////////////////////// -->
		
		<div class="course-list-r-bottom">
	<!-- <form name="intrstLctreForm" method="post"> -->

		<div class="text-center" id="intrstList">
			<table class="def-table-full tb-border table-hover" >
				<thead>
				<tr><th colspan="3">관심 강의 목록</th></tr>
				<tr><th><label><input type="checkbox" id="check_all_6" class="input_check_6" />전체 선택</label></th>
					<th>번호</th>
					<th>강의명</th>
				</tr></thead>
				<tbody>
				<c:forEach items="${intrstLctreList}" var="intrst">
					<tr id="intrstList_tr" >
						<td class="select_ckbox_6">
							<label><input type="checkbox" class="input_check_6 result" name="result" value="${intrst.in_Lctre_No}" />
							${intrst.lu_Lctre_Code }-${intrst.lc_Split }</label></td>
						<td class="lctre_No">${intrst.in_Lctre_No}</td>
						<td><a href="#" >${intrst.lu_Lctre_Nm }</a></td> <!-- 강의계획서 조회 넣을것 -->
					</tr>
				</c:forEach>
				</tbody>
		</table>
		</div>
		<button class="def-btn ckbtn-color" value="addReqst" name="btn_result" onclick="add_reqstLctre()">수강신청</button>&nbsp;&nbsp;
		<button class="def-btn ckbtn-gray" value="delIntrst" name="btn_result" onclick="del_IntrstLctre()">관심삭제</button>

<p id="click_rst">&nbsp;</p>


	<!-- </form> -->
</div>
		<!-- //////////////////////////////////////////////////////////// < 신청학점확인 > ////////////////////////////////////////////////////////////////////////// -->


		<div class="course-list-r-top">
<!-- <form name="courseCredit"> -->
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
<!-- </form> -->
</div>
		
<!-- //////////////////////////////////////////////////////////// < 끝 > ////////////////////////////////////////////////////////////////////////// -->		
			
			
	</div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 개설된 강의 중 관심목록에 추가한 강의들을 확인 가능한 JSP
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH        최초작성
 * 2017.02.15      KJH        추가작성
 * 2017.02.25      KJH        추가작성 
 * Copyright (c) 2017 by DDIT All right reserved
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
function op_timeTable(){
	alert("시간표");
/* 
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
	}); */
}

/* 수강 신청 */
/* function add_reqst(){
	alert("수강신청");
}
 */
 /* 수강 신청 취소 */
/* function del_reqst(){
	alert("수강취소");
} */
/* 관심 추가 */
/* function add_intrst(){
	alert("관심추가");
} */
/* 관심 삭제 */
function del_intrst(form){
    var a="이것도 테스트!<br>";
    var b="선택 항목 없음!<br>"
    
	//alert("테스트");
	if(document.getElementById("ck_null").ckeched){
		var c=document.getElementById("click_rst").innerHTML = "선택 항목 없음<br>";
	}else{
	document.formm.submit();
		var c=document.getElementById("click_rst").innerHTML = "if값 왜 못가져오나<br>";
	}
    document.getElementById("click_rst").innerHTML = a+b+c;
	
    
    
    
    
/*     var obj = document.getElementsByName('aa[]');

    if(obj.length) { 
        for(var i=0;i<obj.length;i++) { 
            tmpObj        = document.createElement("input"); 
            tmpObj.type    = "hidden"; 
            tmpObj.name    = "re_aa[]"; 

            if(obj[i].checked) { 
                tmpObj.value= obj[i].value; 
            } 

            document.formm[0].appendChild(tmpObj); 
        } 
    }  */
    
    
    
    
    
    
	
}

/* $(document).ready(function(){

    $("#check_all").click(function(){
        var chk = $(this).is(":checked");//.attr('checked');
        if(chk) $(".select_ckbox input").prop('checked', true);
        else  $(".select_ckbox input").prop('checked', false);
    });
 
	전체선택 체크박스사용법 : 
	<tr><th><input type="checkbox" id="check_all" class="input_check" />전체선택</th></tr>
	<tr><td class="select_subject">
		<input type="checkbox" class="input_check" /></td></tr>
 

}); */

</script>

<style>
body {
	/* background:#CEFBC9; */
	
}
</style>

</head>
<body class="course-list-r-bottom">
	<form name="formm" method="post">

		<div class="text-center" id="checkboxArea">
			<table class="def-table-full tb-border table-hover">
				<h4>관심 강의 목록&nbsp;&nbsp;
					<button type="button" class="def-btn btn-md btn-color"
						id="openmodal" data-toggle="modal" data-target="#myModal" onclick="op_timeTable()">시간표</button>
				</h4>
				<tr>
					<th><input type="checkbox" id="check_all" class="input_check" />전체 선택</th>
					<th>강의명</th>
				</tr>
				<c:forEach items="${lctre_SearchVO}" var="intrst">
					<tr><td class="select_ckbox">
					<c:choose>
						<c:when test="{intrst.result}">
						<input type="checkbox" class="input_check" id="ck_null" name="result" checked="checked" value="${intrst.in_Lctre_No}" />
						</c:when>
						<c:otherwise>
						<input type="checkbox" class="input_check" id="ck_null" name="result" value="${intrst.in_Lctre_No}" />
						</c:otherwise>
					</c:choose>
						
						${intrst.lu_Lctre_Code }-${intrst.lc_Split }
						<input type="hidden" value="${intrst.in_Lctre_No}"/></td>
						<td><a href="#" >${intrst.lu_Lctre_Nm }</a></td> <!-- 강의계획서 조회 넣을것 -->
					</tr>
				</c:forEach>
		</table>
		<input type="button" class="def-btn ckbtn-color" value="선택 삭제" onclick="del_intrst(this.form)">

		</div>
<p id="click_rst">&nbsp;</p>


	</form>
</body>
</html>




			<%-- 
<a href="<%=request.getContextPath() %>/course/course_timetable" class="openMask"><input type="button" class="def-btn" value="시간표"></a><br/>
 --%>




			<!-- Trigger the modal with a button -->
			<!-- <button type="button" class="def-btn btn-md btn-color" id="openmodal" data-toggle="modal" data-target="#myModal">시간표</button> -->

			<!-- Modal -->
			<!--   <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      Modal content
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          
          
          <p>Some text in the modal.</p>
          
          
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div> -->
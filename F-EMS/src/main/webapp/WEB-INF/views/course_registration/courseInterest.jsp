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

/* 관심 삭제 */
function add_reqst(form){
	alert(document.formm.value);
	document.getElementById("click_rst").innerHTML = "수강신청 좀 제발<br>";
	document.formm.submit();
}
function del_intrst(form){
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
    document.formm.submit();
    
   
}
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
				<tr><th colspan="3">관심 강의 목록</th></tr>
				<tr><th><label><input type="checkbox" id="check_all_1" class="input_check_1" />전체 선택</label></th>
					<th>번호</th>
					<th>강의명</th>
				</tr>
				<c:forEach items="${lctre_SearchVO}" var="intrst">
					<tr><td>${intrst.in_Lctre_No}</td>
					<td class="select_ckbox_1">
						<label><input type="checkbox" class="input_check_1" id="ck_null" name="result" value="${intrst.in_Lctre_No}" />
						${intrst.lu_Lctre_Code }-${intrst.lc_Split }
						<input type="hidden" value="${intrst.in_Lctre_No}"/></label></td>
						<td><a href="#" >${intrst.lu_Lctre_Nm }</a></td> <!-- 강의계획서 조회 넣을것 -->
					</tr>
				</c:forEach>
		</table>
		<button class="def-btn ckbtn-color" value="addReqst" name="btn_result" onclick="add_reqst(this.form)">수강신청</button>&nbsp;&nbsp;
		<button class="def-btn ckbtn-gray" value="delIntrst" name="btn_result" onclick="del_intrst(this.form)">관심삭제</button>

		</div>
<p id="click_rst">&nbsp;</p>


	</form>
</body>
</html>
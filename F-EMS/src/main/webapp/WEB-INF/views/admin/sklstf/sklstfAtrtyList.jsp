<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 직원목록 및 직원의 관리자 권한여부 목록을 조회할 수 있는 JSP
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
<script type="text/javascript">

function go_atrty_update() {
	 var count = 0;
	 
	 for (var i = 0; i < document.formm.sa_Sklstf_No.length; i++) {
	  if (document.formm.sa_Sklstf_No[i].checked == true) {
	   
		  sa_Atrty[i]="ROLE_ADMIN";
	  }else{
		  sa_Atrty[i]="ROLE_STF";
		  
	  }
	 }
	 
	  document.formm.submit();
	 
	}


</script>
</head>
<body>

<form name="formm" mehtod="post">
<table class="non-border margin-auto">	
<tr><td>	
<div class="text-left">
	<h2>관리자 설정</h2>
	<!-- <div class="container out-border"> -->
	<!-- <table class="def-table-full tb-border"> -->
	<table class="def-table-auto">
	<tr><td class="text-right">
					<select name="key" class="combobox-md custom-form-control">
					<option value="stf_Sklstf_No">직원번호</option>
					<option value="stf_Nm">직원이름</option>
					<option value="sit_Subjct">학과</option>
					<option value="fc_Faculty_Nm">학부</option>
					<option value="coleg_Nm">단과대학</option>
				</select>&nbsp;&nbsp;
					<input type="text" class="def-input-text-md custom-form-control" name="value">&nbsp;&nbsp;
					<button class="def-btn btn-search btn-color" value="조회" onclick="submitForm(this.form)"><i class="glyphicon glyphicon-search"></i>&nbsp;조회</button>
					&nbsp;&nbsp;<label><input type="checkbox" id="check_all_1" class="input_check_1" name="sa_Atrty" value="ROLE_STF"/>
					전체선택</label>
	</td></tr>
	</table>
			<table class="def-table-full tb-border table-hover">
				<!-- <tr>
					<td colspan="12"  class="text-right">
					</td>
				</tr> -->
				<tr>
					<th>직원번호</th>
					<th>단과대학</th>
					<th>학부</th>
					<th>학과</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>연락처</th>
					<th>관리자</th>
					<th><!-- <input type="button" class="def-ckbtn btn-sm ckbtn-color" value="전체적용" onclick=""> --></th>
				</tr>
				
				<c:forEach items="${sklstfAtrtyList}" var="subjct">
				<tr>
				
					<td>${subjct.stf_Sklstf_No}</td>
					<td>${subjct.coleg_Nm}</td>
					<td>${subjct.fc_Faculty_Nm}</td>
					<td>${subjct.sit_Subjct }</td>
					<td><a href="detailSklstf?no=${subjct.stf_Sklstf_No}&tpage=${tpage}">${subjct.stf_Nm}</a></td>
					<td>${subjct.stf_Ihidnum}</td>
					<td>${subjct.stf_Sklstf_Tlphon_No}</td>
					<td class="select_ckbox_1">
					<form method="post">
					<c:choose>
					<c:when test="${subjct.sa_Atrty=='ROLE_ADMIN'}"><label><input type="checkbox" class="input_check_1" name="result" value="${subjct.sa_Sklstf_No}" checked="checked">관리자</label></c:when>
					<c:otherwise><label><input type="checkbox" class="input_check_1" name="result" value="${subjct.sa_Sklstf_No}">직원</label></c:otherwise>
					</c:choose>
					<input type="hidden" name="sa_Sklstf_No"> <!-- 선택한 것의 직원번호 가져오고 싶음 -->
					</td>
					<td>
					
					
					<%-- <c:choose>
					<c:when test="${subjct.sa_Atrty=='ROLE_ADMIN'}">
					<input type="submit" class="def-ckbtn btn-sm ckbtn-gray" value="적용">
					<input type="hidden" name="sa_Atrty" value="ROLE_STF"></c:when><c:otherwise>
					<input type="submit" class="def-ckbtn btn-sm ckbtn-color" value="적용">
					<input type="hidden" name="sa_Atrty" value="ROLE_ADMIN">
					</c:otherwise>
					</c:choose> --%>
					</td>
					
					</form>
				</tr>
			</c:forEach>
				<tr>
      		<td colspan="9" style="text-align: center;">${paging }</td>
      	</tr>
			</table>
					<input type="submit" class="def-ckbtn btn-md ckbtn-color" value="적용" onclick="go_atrty_update()">
</div>
</td></tr></table>
	</form>
</body>
</html>
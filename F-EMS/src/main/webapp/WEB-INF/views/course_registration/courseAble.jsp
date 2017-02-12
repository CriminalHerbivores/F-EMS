<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

</head>
<body>
	<form>
	<div class="text-center">
	<!-- <div class="container out-border"> -->
	<!-- <table class="def-table-full tb-border"> -->
	<table class="def-table-full">
	<tr><td class="text-right">
					<select name="선택" class="combobox-md custom-form-control">
					<option value="032">전공</option>
					<option value="033">교양</option>
					<option value="02">강의</option>
					<option value="031">학과</option>
					<option value="041">담당교수</option>
				</select>&nbsp;&nbsp;
					<input type="text" class="def-input-text-md custom-form-control">&nbsp;&nbsp;
					<button class="def-btn btn-search btn-color" value="조회"><i class="glyphicon glyphicon-search"></i>&nbsp;조회</button>&nbsp;&nbsp;
					<input type="button" class="def-btn btn-search btn-color" value="상세검색">&nbsp;&nbsp;
	</td></tr>
	</table>
			<table class="def-table-full tb-border table-hover">
				<!-- <tr>
					<td colspan="12"  class="text-right">
					</td>
				</tr> -->
				<tr><th colspan="12"><h4>개설 강의 목록</h4></th></tr>
				<tr>
					<th>수강신청</th>
					<th>관심강의</th>
					<th>개설학과</th>
					<th>강의코드</th>
					<th>분반</th>
					<th>학년</th>
					<th>강의명</th>
					<th>이수구분</th>
					<th>학점/시수</th>
					<th>담당교수</th>
					<th>강의시간</th>
					<th>수강인원</th>
					<th>제한인원</th>
				</tr>
				
				<%-- <c:forEach items="${listLctre}" var="lctre_SearchVO">
				<tr>
					<td><input type="button" class="" value="수강신청"></td>
					<td><input type="button" class="" value="관심추가"></td>
					<td>${lctre_SearchVO.lu_Lctre_Code}-${lctre_SearchVO.lc_Split}</td>
					<td>${lctre_SearchVO.Lu_Lctre_Nm}</td>
					<td>${lctre_SearchVO.Lu_Pnt}</td>
					<td>${lctre_SearchVO.pr_Nm}</td>
					<td>${lctreVO.lc_Lctre_Time}</td>
					<td>${lctreVO.lc_Lctre_Nmpr}</td>
					<td>${lctre_SearchVO.lr_Accept_Nmpr}</td> 
					<td>암거나</td>
					<td>비고</td>
				</tr>
			</c:forEach> --%>
				
				<tr>
					<td>값</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				
				
			</table>
</div>
	</form>
</body>
</html>
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
	background: #D4F4FA;
}
</style>

</head>
<body>
	<form>
		<article>
			<table class="def-table tb-border">
				<tr>
					<td colspan="12"  class="text-right">
					<select name="선택" class="combobox-sm">
					<option value="032">전공</option>
					<option value="033">교양</option>
					<option value="02">강의</option>
					<option value="031">학과</option>
					<option value="041">담당교수</option>
				</select>&nbsp;&nbsp;
					<input type="text" class="def-input-text-sm">&nbsp;&nbsp;
					<input type="button" class="def-btn" value="조회">&nbsp;&nbsp;
					<input type="button" class="def-btn" value="상세검색">&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td>수강신청</td>
					<td>관심삭제</td>
					<td>강의코드</td>
					<td>강의명</td>
					<td>시수학점</td>
					<td>이수구분</td>
					<td>담당교수</td>
					<td>강의시간</td>
					<td>수강인원</td>
					<td>정원</td>
					<td>암거나</td>
					<td>비고</td>
				</tr>
<%-- 				
				<c:forEach items="${lctreList}" var="lctreVO">
				<tr>
					<td><input type="button" class="" value="수강신청"></td>
					<td><input type="button" class="" value="관심추가"></td>
					<td><%-- ${lctre_SearchVO.lu_Lctre_Code} --%>-${lctre_SearchVO.lc_Split}</td>
<%-- 					<td>${lctre_SearchVO.Lu_Lctre_Nm}</td> --%>
<%-- 					<td>${lctre_SearchVO.Lu_Pnt}</td> --%>
<%-- 					<td>${lctre_SearchVO.pr_Nm}</td> --%>
<%-- 					<td>${lctreVO.lc_Lctre_Time}</td> --%>
<%-- 					<td>${lctreVO.lc_Lctre_Nmpr}</td> --%>
<%-- 					<td>${lctre_SearchVO.lr_Accept_Nmpr}</td> 
					<td>암거나</td>
					<td>비고</td>
				</tr>
			</c:forEach>
--%>				
				
				
				
			</table>

	
		</article>
	</form>
</body>
</html>
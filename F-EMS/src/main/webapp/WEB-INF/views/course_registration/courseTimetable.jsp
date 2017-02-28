<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 관심강의 혹은 수강신청완료한 강의들을 시간표로 보여주는 JSP
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
function resultLctre(lc_Wik_Lctre_Dayweek,lc_Lctre_Time,lc_Lctrum_No) {
	   

var str=lc_Wik_Lctre_Dayweek;
var arr = str.split("/");
var arr1 = arr[0];
var arr2 = arr[1];

document.formm.getElementById("demo1").innerHTML = arr[0];

document.formm.getElementById("demo2").innerHTML=arr[1];
}


	
</script>


</head>
<body>
<c:forEach items="${lctre_SearchVO}" var="lctre">
	<input type="button" value="${lctre_SearchVO.lc_Lctre_Nm }" onclick="return resultLctre('${lctre_SearchVO.lc_Wik_Lctre_Dayweek}','${lctre_SearchVO.lc_Lctre_Time}', '${lctre_SearchVO.lc_Lctrum_No}')" ><br/>
	</c:forEach>
	
	<h1>시간표 (${loginUser})</h1>
	<table class="def-table-full tb-border table-hover">
		<tr>
			<th>시간</th>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
		</tr>
		<tr>
			<td>1교시</td>
			<td rowspan="2"><p id="demo1"></p></td>
			<td rowspan="2"><p id="demo2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
		</tr>
		<tr>
			<td>09:00</td>
		</tr>
		<tr>
			<td>2교시</td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
		</tr>
		<tr>
			<td>10:00</td>
		</tr>
		<tr>
			<td>3교시</td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
		</tr>
		<tr>
			<td>11:00</td>
		</tr>
		<tr>
		<td>4교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>12:00</td>
	</tr>
	<tr>
		<td>5교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>13:00</td>
	</tr>
	<tr>
		<td>6교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>14:00</td>
	</tr>
	<tr>
		<td>7교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>15:00</td>
	</tr>
	<tr>
		<td>8교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>16:00</td>
	</tr>
	<tr>
		<td>9교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>17:00</td>
	</tr>
	<tr>
		<td>10교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>18:00</td>
	</tr>
	<tr>
		<td>11교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>19:00</td>
	</tr>
	<tr>
		<td>12교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>20:00</td>
	</tr>
	<tr>
		<td>13교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>21:00</td>
	</tr>
	</table>


</body>
</html>
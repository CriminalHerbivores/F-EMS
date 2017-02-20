<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

</head>
<body class="course-list-l-top">
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
				<tr><th colspan="13"><h4>개설 강의 목록</h4></th></tr>
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
				
				<c:forEach items="${lctre_SearchVO}" var="lctre" begin="0" end="9">
				<tr>
					<td>
						<input type="button" class="def-ckbtn btn-sm ckbtn-color" value="수강신청">
						</td>
					
					<td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="관심추가"></td>
					<td>${lctre.sit_Subjct}</td>
					<td>${lctre.lu_Lctre_Code}</td>
					<td>${lctre.lc_Split}</td>
					<td>${lctre.lu_Grade }</td>
					<td>${lctre.lu_Lctre_Nm}</td>
					<td>${lctre.lu_Compl_Se}</td>
					<td>${lctre.lu_Pnt}</td>
					<td>${lctre.pr_Nm}</td>
					<td>${lctre.lc_Lctre_Time}</td>
					<td>${lctre.lc_Lctre_Nmpr}</td>
					<td>${lctre.lr_Accept_Nmpr}</td> 
				</tr>
			</c:forEach>
				
				<!-- <tr>
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
				</tr> -->
				
				<!-- ////////////////////////////////////////////////////////// -->
				
				
				
<!-- <tr><td><input type="button" class="def-ckbtn btn-sm ckbtn-gray" value="해제"></td><td><input type="button" class="def-ckbtn btn-sm ckbtn-gray" value="해제"></td><td>컴퓨터공학과</td><td>10473</td><td>00</td><td>1</td><td>컴퓨터 입문</td><td>교양</td><td>3/2/2</td><td>유관종</td><td>월(8~9교시), 수(5~6교시)</td><td>1</td><td>40</td></tr>
<tr><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="신청"></td><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="관심"></td><td>컴퓨터공학과</td><td>10473</td><td>01</td><td>1</td><td>컴퓨터 입문</td><td>교양</td><td>3/2/2</td><td>김상형</td><td>월(6~7교시), 수(7~8교시)</td><td>0</td><td>40</td></tr>
<tr><td><input type="button" class="def-ckbtn btn-sm ckbtn-gray" value="해제"></td><td><input type="button" class="def-ckbtn btn-sm ckbtn-gray" value="해제"></td><td>컴퓨터공학과</td><td>14773</td><td>01</td><td>3</td><td>데이터통신</td><td>전공</td><td>3/3/0</td><td>김상하</td><td>수(1교시), 수(6~7교시)</td><td>1</td><td>40</td></tr>
<tr><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="신청"></td><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="관심"></td><td>컴퓨터공학과</td><td>14773</td><td>00</td><td>3</td><td>데이터통신</td><td>전공</td><td>3/3/0</td><td>김상하</td><td>수(2~3교시), 수(~교시)</td><td>0</td><td>40</td></tr>
<tr><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="신청"></td><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="관심"></td><td>컴퓨터공학과</td><td>14773</td><td>02</td><td>3</td><td>데이터통신</td><td>전공</td><td>3/3/0</td><td>이영석</td><td>수(1교시), 수(6~7교시)</td><td>0</td><td>40</td></tr>
<tr><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="신청"></td><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="관심"></td><td>컴퓨터공학과</td><td>18129</td><td>02</td><td>2</td><td>논리회로및실험</td><td>전공</td><td>3/2/2</td><td>김형신</td><td>월(2~3교시), 수(6~7교시)</td><td>0</td><td>40</td></tr>
<tr><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="신청"></td><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="관심"></td><td>컴퓨터공학과</td><td>18129</td><td>00</td><td>2</td><td>논리회로및실험</td><td>전공</td><td>3/2/2</td><td>김형식</td><td>월(2~3교시), 수(6~7교시)</td><td>0</td><td>40</td></tr>
<tr><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="신청"></td><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="관심"></td><td>컴퓨터공학과</td><td>18129</td><td>03</td><td>2</td><td>논리회로및실험</td><td>전공</td><td>3/2/2</td><td>김형신</td><td>월(5~6교시), 목(2~3교시)</td><td>0</td><td>40</td></tr>
<tr><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="신청"></td><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="관심"></td><td>컴퓨터공학과</td><td>22132</td><td>01</td><td>1</td><td>이산수학</td><td>전공</td><td>3/3/0</td><td>황치정</td><td>월(9교시), 화(7~8교시)</td><td>0</td><td>40</td></tr>
 -->				
				
				
				
				<!-- ///////////////////////////////////////////////////////////// -->
				
			</table>
</div>
	</form>
</body>
</html>
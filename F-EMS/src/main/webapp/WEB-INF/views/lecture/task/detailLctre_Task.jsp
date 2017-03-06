<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.24    KJS            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
		<h2>강의 과제 게시판</h2><br/>
	<form name="formm" method="post" action="detailBbs_Gnt">
		<table class="def-table-full tb-border" style="text-align:left;">
			<tr>
				<th width="170px">제목</th>
				<td colspan="3" style="text-align: left;">${lctre_Task_Gnt.lt_Sj}</td>
			</tr>
			<tr>
				<th>작성날짜</th>
				<td style="text-align: left;">${lctre_Task_Gnt.lt_Writng_Dt}</td>
				<th width="100">작성자</th>
				<td style="text-align: left;">${lctre_Task_Gnt.lt_Stdnt_No}</td>
			</tr>
				<tr>
					<th>파일첨부</th>
					<td colspan="3" style="text-align: left;"><a href="<%=request.getContextPath() %>/download/file/list?filename=${lctre_Flpth.lf_Flpth}">${lctre_Flpth.lf_Flpth}</a></td>
				</tr>
			<tr>
				<th>내용</th>
				<td colspan="3" style="text-align: left;"><textarea rows="8" cols="65" name="ld_Cn" readonly="readonly" style="width:100%;" class="text-non-border">${lctre_Task_Gnt.lt_Cn }</textarea><br></td>
			</tr>
			<tr>
				<td colspan="4" class="text-right">
				<a href="updateLctre_Task?lt_Bbs_No=${lctre_Task_Gnt.lt_Bbs_No}&table_Nm=${lctre_Task_Gnt.table_Nm}&tpage=${tpage}"> <input
					type="button" value="수정" class="def-btn btn-md btn-color">
				</a> <input type="button" class="def-btn btn-md btn-color" data-target="#layerpop"
					data-toggle="modal" value="삭제"> <a
					href="taskList?tpage=${tpage}&table_Nm=${lctre_Task_Gnt.table_Nm }"> <input
					type="button" class="def-btn btn-md btn-color" value="목록">
				</a>
				</td>
			</tr>
		</table>
		<br>
	</form>
	<!--모달부분  -->
	<div class="modal fade" id="layerpop">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<!-- 닫기(x) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- header title -->
					<h4 class="modal-title" style="text-align: center">삭제확인</h4>
				</div>
				<!-- body -->
				<div class="modal-body" style="text-align: center">삭제하시겠습니까?</div>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					<a href="deleteLctre_Task?lt_Bbs_No=${lctre_Task_Gnt.lt_Bbs_No}&tpage=${tpage}&table_Nm=${lctre_Task_Gnt.table_Nm}"> <!--삭제 모달  -->
						<input type="button" class="btn btn-default" value="예">
					</a> <input type="button" class="btn btn-default" data-dismiss="modal" value="아니오">
				</div>
			</div>
		</div>
	</div>

</body>
</html>

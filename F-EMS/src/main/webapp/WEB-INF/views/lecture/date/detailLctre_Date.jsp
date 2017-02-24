<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.23    KJS            최초작성               -->
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
<div id="detailBbs_Gnt" style="float:left;">
	<form name="formm" method="post" action="detailBbs_Gnt">
		<h2>강의 자료 게시판</h2>
		<hr>
		<table class="def-table-full tb-border table-hover" style="width:750px; text-align:left;">
			<tr>
				<th>제목</th>
				<td colspan="3" style="text-align: left;">${lctre_Date_Gnt.ld_Sj}</td>
			</tr>
			<tr>
				<th>작성날짜</th>
				<td style="text-align: left;">${lctre_Date_Gnt.ld_Writng_Dt}</td>
				<th>조회수</th>
				<td style="text-align: left;">${lctre_Date_Gnt.ld_Rdcnt}</td>
			</tr>
				<tr>
					<th>파일첨부</th>
					<td colspan="3" style="text-align: left;"><a href="<%=request.getContextPath() %>/download/file/list?filename=${lctre_Flpth.lf_Flpth}">${lctre_Flpth.lf_Flpth}</a></td>
				</tr>
			<tr>
				<th>내용</th>
				<td colspan="3" style="text-align: left;"><textarea rows="8" cols="65" name="ld_Cn" readonly="readonly">${lctre_Date_Gnt.ld_Cn }</textarea><br></td>
			</tr>

		</table>
		<br>
		<!-- 댓글부분 -->
	</form>

	<!--버튼들  -->
	<div id="buttons" style="float: right">
		<a href="updateLctre_Date?ld_Bbs_No=${lctre_Date_Gnt.ld_Bbs_No}&table_Nm=${lctre_Date_Gnt.table_Nm}&tpage=${tpage}"> <input
			type="button" value="수정" class="def-btn btn-md btn-color">
		</a> <input type="button" class="def-btn btn-md btn-color" data-target="#layerpop"
			data-toggle="modal" value="삭제"> <a
			href="dateList?tpage=${tpage}&table_Nm=${lctre_Date_Gnt.table_Nm }"> <input
			type="button" class="def-btn btn-md btn-color" value="목록">
		</a>
	</div>
</div>
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
					<a href="deleteLctre_Date?tpage=${tpage}&table_Nm=${lctre_Date_Gnt.table_Nm }&ln_Bbs_No=${lctre_Date_Gnt.ln_Bbs_No}"> <!--삭제 모달  -->
						<input type="button" class="btn btn-default" value="예">
					</a> <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>




</body>
</html>

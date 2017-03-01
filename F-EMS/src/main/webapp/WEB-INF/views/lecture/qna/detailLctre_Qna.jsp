<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.26    KJS            최초작성               -->
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
		<h2>강의 질의응답 게시판</h2>
		<hr>
		<table class="def-table-full tb-border table-hover" style="width:750px; text-align:left;">
			<tr>
				<th>제목</th>
				<td style="text-align: left;">${lctre_Qna_Gnt.lq_Sj}</td>
				<th>작성자</th>
				<td style="text-align: left;">${lctre_Qna_Gnt.lq_Stdnt_No}</td>
			</tr>
			<tr>
				<th>작성날짜</th>
				<td style="text-align: left;">${lctre_Qna_Gnt.lq_Writng_Dt}</td>
				<th>조회수</th>
				<td style="text-align: left;">${lctre_Qna_Gnt.lq_Rdcnt}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3" style="text-align: left;"><textarea rows="8" cols="65" name="ln_Cn" readonly="readonly">${lctre_Qna_Gnt.lq_Cn }</textarea><br></td>
			</tr>
			<tr>
				<th>답변</th>
				<td colspan="3" style="text-align: left;"><textarea rows="8" cols="65" name="lq_Reply" readonly="readonly">${lctre_Qna_Gnt.lq_Reply }</textarea><br></td>
			</tr>
				<sec:authorize access="hasRole('ROLE_PRO')">
			<tr>
				<td colspan="4" style="text-align: center;">
				<a href="updateLctre_Qna_Reply?lq_Bbs_No=${lctre_Qna_Gnt.lq_Bbs_No}&table_Nm=${lctre_Qna_Gnt.table_Nm}&tpage=${tpage}"> 
				<button class="def-btn btn-color">
				<c:choose>
					<c:when test="${empty lctre_Qna_Gnt.lq_Reply}">
						답변 작성
					</c:when>
					<c:otherwise>
						답변 수정
					</c:otherwise>
				</c:choose>
				</button>
				</a>
				</td>
			</tr>
				</sec:authorize>

		</table>
		<br>
	</form>

	<!--버튼들  -->
	<div id="buttons" style="float: right">
	<sec:authorize access="hasRole('ROLE_STD')">
		<a href="updateLctre_Qna?lq_Bbs_No=${lctre_Qna_Gnt.lq_Bbs_No}&table_Nm=${lctre_Qna_Gnt.table_Nm}&tpage=${tpage}"> <input
			type="button" value="수정" class="def-btn btn-md btn-color">
		</a> <input type="button" class="def-btn btn-md btn-color" data-target="#layerpop"
			data-toggle="modal" value="삭제"> 
			</sec:authorize>
			<a
			href="qnaList?tpage=${tpage}&table_Nm=${lctre_Qna_Gnt.table_Nm }"> 
			
			<input
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
					<a href="deleteLctre_Qna?tpage=${tpage}&table_Nm=${lctre_Qna_Gnt.table_Nm }&lq_Bbs_No=${lctre_Qna_Gnt.lq_Bbs_No}"> <!--삭제 모달  -->
						<input type="button" class="btn btn-default" value="예">
					</a> <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>




</body>
</html>

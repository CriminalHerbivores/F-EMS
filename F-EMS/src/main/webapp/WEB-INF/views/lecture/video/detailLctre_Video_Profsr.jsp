<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<table class="def-table-full tb-border table-hover">
			<tr>
				<th>제목</th>
				<td colspan="3" style="text-align: left;">${lctre_Video_Gnt.lv_Sj}</td>
			</tr>
			<tr>
				<th>기간</th>
				<td style="text-align: left;">
					<fmt:formatDate value="${lctre_Video_Gnt.lv_Start_Dt}"/>
		      		~
		      		<fmt:formatDate value="${lctre_Video_Gnt.lv_End_Dt}"/> </td>
				<th>시간</th>
				<td style="text-align: left;"><fmt:parseNumber var="i" integerOnly="true" 
                       type="number" value="${lctre_Video_Gnt.lv_Time/60}" />
				<c:out value="${i}" />:${lctre_Video_Gnt.lv_Time%60}</td>
			</tr>
			<tr>
				<th>동영상</th>
				<td colspan="3" style="text-align: left;">
					<video id="myVideo" src="<%=request.getContextPath() %>/resources/files/${lctre_Flpth.lf_Flpth}" controls width="600pt" height="500pt" ></video>
				</td>
			</tr>
		</table>
		<br>
		<!-- 댓글부분 -->
	</form>
<br/><br/><br/>
	<!--버튼들  -->
<table class="def-table-full"><tr><td style="text-align: right;">
		<a href="updateLctre_Video?lv_Bbs_No=${lctre_Video_Gnt.lv_Bbs_No}&table_Nm=${lctre_Video_Gnt.table_Nm}&tpage=${tpage}"> <input
			type="button" value="수정" class="def-btn btn-md btn-color">
		</a> <input type="button" class="def-btn btn-md btn-color" data-target="#layerpop"
			data-toggle="modal" value="삭제"> <a
			href="videoList?tpage=${tpage}&table_Nm=${lctre_Video_Gnt.table_Nm }"> <input
			type="button" class="def-btn btn-md btn-color" value="목록">
		</a>
</td></tr></table>
<br/><br/><br/>
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
					<a href="deleteLctre_Video?lv_Bbs_No=${lctre_Video_Gnt.lv_Bbs_No}&tpage=${tpage}&table_Nm=${lctre_Video_Gnt.table_Nm }"> <!--삭제 모달  -->
						<input type="button" class="btn btn-default" value="예">
					</a> <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>




</body>
</html>

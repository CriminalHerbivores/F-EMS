<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--
 * <pre>
 * F-EMS로 대학 웹페이지를 개설할 때 제안되는 메인 레이아웃을 선택하는 JSP
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
<script src="https://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('select').change(function(){
		var v = $(this).val();
		var path = "";
		var p = $(this).closest("tr");
		var c = $(p).find('.mnCours');
		if(v=="noticeList"){
			$(c).html('공지사항<input type="hidden" value="notice_bbs/noticeList" name="mn_Cours">');
		}else if(v=="schdulList"){
			$(c).html('학사일정<input type="hidden" value="schafs_schdul/schdulList" name="mn_Cours">');
		}else if(v=="lct"){
			$(c).html('강의<input type="hidden" value="lctreList" name="mn_Cours">');
		}else if(v=="notice"){
			var temp = $("#noticeB").html();
			$(c).html(temp);
		}else if(v=="bbs"){
			var temp = $("#bbsB").html();
			$(c).html(temp);
		}else if(v=="etc"){
			$(c).html('<input type="text" name="mn_Cours" class="def-input-text-full custom-form-control">');
		}else{
			$(c).html("");
		}
	});
})
</script>
</head>
<body>
<table class="def-table-full"><tr><td>
<form id="step3Add" method="post" enctype="multipart/form-data" name="formm">
	<table class="def-table-full tb-border table-hover tr-child-color">
	<tr>
		<td><a href="step1Add">STEP 1</a></td>
		<td><a href="step2Add">STEP 2</a></td>
		<td><a href="step3Add">STEP 3</a></td>
		<td><a href="<%=request.getContextPath()%>/">INDEX</a></td>
	</tr>
	</table>
	<br/>
<h2>메뉴 관리</h2><br/>
	<table class="def-table-full tb-border table-hover tr-child-color">
		<tr>
			<th width="50%">레이아웃 형태</th>
			<td>
				<input type="hidden" name="mng_Layout_Knd" value="${manageVO.mng_Layout_Knd}">
				<c:choose>
				<c:when test="${manageVO.mng_Layout_Knd eq 1}">
				로그인형
				</c:when>
				<c:when test="${manageVO.mng_Layout_Knd eq 2}">
				복합형
				</c:when>
				<c:when test="${manageVO.mng_Layout_Knd eq 3}">
				게시판형
				</c:when>
				<c:when test="${manageVO.mng_Layout_Knd eq 4}">
				메뉴형
				</c:when>
				<c:otherwise>
				</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
	
	<div class="menuSe">
	
	<table class="def-table-full tb-border table-hover tr-child-color">
	<tr>
		<th width="50px">No</th>
		<th width="300px">구분코드</th>
		<th>경로</th>
	</tr>
	<c:forEach items="${menuList}" var="mL" varStatus="status">
	<tr>
		<td>${status.count}<input type="hidden" name="mn_No" value="${status.count}"></td>
		<td><input type="text" name="mn_Nm" value="${mL.mn_Nm}" class="def-input-text-lg custom-form-control"></td>
		<td>
			<select name="mn_Se_Code" class="combobox-lg custom-form-control">
				<option value="">사용안함</option>
				<c:forEach items="${menuSe}" var="mns">
				<c:choose>
				<c:when test="${mns.ms_Se_Code == mL.mn_Se_Code}">
				<option value="${mns.ms_Se_Code}" selected>${mns.ms_Type}</option>
				</c:when>
				<c:otherwise>
				<option value="${mns.ms_Se_Code}">${mns.ms_Type}</option>
				</c:otherwise>
				</c:choose>
				</c:forEach>
			</select>
		</td>
		<td class="mnCours">${mL.mn_Cours}</td>
	</tr>
	</c:forEach>
	</table>
	</div>
	
<table class="def-table-full"><tr><td style="text-align: right;">
	<input type="submit" value="등록" class="def-btn btn-md btn-color">
</td></tr></table>
</form>
	
	<div id="noticeB" class="non-disp">
	<select name="mn_Cours" class="combobox-lg custom-form-control">
		<c:forEach items="${noticeBBS}" var="bbs">
		<option value="bbs_gnt/bbsList?bl_Bbs_No=${bbs.bl_Bbs_No}">${bbs.bl_Bbs_Nm}</option>
		</c:forEach>
	</select>
	</div>
	<div id="bbsB" class="non-disp">
	<select name="mn_Cours" class="combobox-lg custom-form-control">
		<c:forEach items="${bbsList}" var="bbs">
		<option value="bbs_gnt/bbsList?bl_Bbs_No=${bbs.bl_Bbs_No}">${bbs.bl_Bbs_Nm}</option>
		</c:forEach>
	</select>
	</div>
</td></tr></table>
<br/><br/><br/>
</body>
</html>
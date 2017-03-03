<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.02    송선호            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h2> 공지 게시판 </h2><br/>
<form name="formm" method="post" enctype="multipart/form-data">
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>제목</th>
		<td><input type="text" name="nb_Sj" value="${notice.nb_Sj}"
		 class="def-input-text-full custom-form-control"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="8" cols="65" name="nb_Cn"
		 class="def-input-text-full custom-form-control">${notice.nb_Cn }</textarea></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td>
		   <c:forEach var="flpth" items="${flpthList }">
		   <input type="hidden" name="bf_No" value=${flpth.bf_No }>
		   </c:forEach>
		   <input type="file" name="uploadfile">
		</td>
	</tr>
</table>
<table class="def-table-full"><tr><td style="text-align: right;">
	 <input type="hidden" name="tpage" value=${tpage }>
	 <input type="hidden" name="nb_Bbs_No" value=${notice.nb_Bbs_No }>
	 <input type="button" class="def-btn btn-md btn-color" value="수정" onclick="submitForm(this.form);">
	 <a href="noticeList?tpage=${tpage}"> <input type="button" class="def-btn btn-md btn-color" value="목록"> </a>
</td></tr></table>
</form>
</body>
</html>
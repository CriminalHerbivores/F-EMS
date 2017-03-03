<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.22    KJS            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	    <h2> ${bbs_List_Gnt.bl_Bbs_Nm } </h2><br/>
	    
<form name="formm" method="post" enctype="multipart/form-data">
	 <input type="hidden" name="tpage" value=${tpage }>
	 <input type="hidden" name="bb_Bbs_No" value=${bbs_List_Gnt.bb_Bbs_No }>
	 <input type="hidden" name="bl_Bbs_No" value=${bbs_List_Gnt.bl_Bbs_No }>
	 <input type="hidden" name="bl_Bbs_Nm" value=${bbs_List_Gnt.bl_Bbs_Nm }>
	 <input type="hidden" name="bl_Table_Nm" value=${bbs_List_Gnt.bl_Table_Nm }>
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>제목</th>
		<td><input type="text" name="bb_Sj" value="${bbs_List_Gnt.bb_Sj }" class="def-input-text-full custom-form-control"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="8" cols="65" name="bb_Cn" class="def-input-text-full custom-form-control">${bbs_List_Gnt.bb_Cn }</textarea></td>
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
	<input type="button" class="def-btn btn-md btn-color" value="수정" onclick="submitForm(this.form);">
	<a href="bbsList?bl_Bbs_No=${bbs_List_Gnt.bl_Bbs_No}&tpage=${tpage}"> <input type="button" class="def-btn btn-md btn-color" value="목록"></a>
</td></tr></table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	    <h2> 공지 게시판 </h2>
		<form name="formm" method="post" enctype="multipart/form-data">
			<fieldset>	
			    <label>제목</label>
			    <input type="text" name="nb_Sj" value=${notice.nb_Sj }  size="64" ><br>
				<label>내용</label>
			    <textarea rows="8" cols="65" name="nb_Cn">${notice.nb_Cn }</textarea><br>
			   <c:forEach var="flpth" items="${flpthList }">
			   <input type="hidden" name="bf_No" value=${flpth.bf_No }>
			   </c:forEach>
			   <input type="file" name="uploadfile">
			</fieldset>   
		<div class="clear"></div>
			 <div id="buttons" style="float:right">
			 <input type="hidden" name="tpage" value=${tpage }>
			 <input type="hidden" name="nb_Bbs_No" value=${notice.nb_Bbs_No }>
			 <input type="button" class="def-btn btn-md btn-color" value="수정" onclick="updateNotice();">
			 <a href="noticeList?tpage=${tpage}"> <input type="button" class="def-btn btn-md btn-color" value="목록"> </a>
		  </div>
		  
		</form>
</body>
</html>
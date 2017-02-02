<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>
	    <h2> 공지 게시판 </h2>
		<form name="formm" method="post">
			<fieldset>	
			    <label>제목</label>
			    <input type="text" name="nb_Sj" value=${notice.nb_Sj }  size="64" ><br>
				<label>내용</label>
			    <textarea rows="8" cols="65" name="nb_Cn">${notice.nb_Cn }</textarea><br>
			</fieldset>   
		<div class="clear"></div>
		 <div id="buttons" style="float:right">
		 <input type="hidden" name="tpage" value=${tpage }>
		 <input type="hidden" name="nb_Bbs_No" value=${notice.nb_Bbs_No }>
		 <input type="button" value="수정" onclick="updateNotice();">
		 <a href="noticeList?tpage=${tpage}"> <input type="button" value="목록"> </a>
			<!-- <input type="submit"  value="수정" class="submit"> 
			<input type="button"  value="목록"  class="submit"  onclick="goNoticeList();">	 -->
		  </div>
		  
		</form>
</body>
</html>
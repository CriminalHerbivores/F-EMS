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
		<form name="formm" method="post">
			<fieldset>	
			    <label>제목</label>
			    <input type="text" name="nb_Sj"  size="64" ><br>
				<label>내용</label>
			    <textarea rows="8" cols="65" name="nb_Cn"></textarea><br>
			    <input type="file" name="uploadfile">
			</fieldset>   
		<div class="clear"></div>
		 <div id="buttons" style="float:right">
			<input type="button"  value="등록" class="def-btn" onclick="writeNotice();" > 
			<input type="button"  value="목록"  class="def-btn"  onclick="goNoticeList();">	
		  </div>
		  
		</form>
		
</body>
</html>
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

<table>
	<tr>
		<th>제목</th>
		<td>${notice.nb_Sj} </td>
	 </tr>
	 <tr>
	 	<th>작성날짜</th>
	 	<td>${notice.nb_Writng_Dt}</td>
	 </tr>
	 <tr>
	 	<th>내용</th>
	 	<td>${notice.nb_Cn}</td>
	 </tr>
</table>
<div id="buttons" style="float:right">
	<a href="updateNotice?no=${notice.nb_Bbs_No}&tpage=${tpage}"> <input type="button" value="수정"> </a>
	<a href="deleteNotice?no=${notice.nb_Bbs_No}&tpage=${tpage}"> <input type="button" value="삭제"> </a>
	<a href="noticeList?no=${notice.nb_Bbs_No}&tpage=${tpage}"> <input type="button" value="목록"> </a>
</div>	

</body>
</html>
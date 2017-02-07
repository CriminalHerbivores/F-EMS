<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<script>



</script>



</head>
<body>
<form name="formm" method="post" action="notice_bbs">
<h2> 공지 게시판 </h2>

<table>
	<tr>
		<th>제목</th>
		<td>${notice.nb_Sj} </td>
	 </tr>
	 <tr>
	 	<th>작성날짜</th>
	 	<td>${notice.nb_Writng_Dt}</td>
	 	<th>조회수</th>
	 	<td>${notice.nb_Rdcnt} </td> 
	 </tr>
	<c:forEach var="flpth" items="${flpthList }">
	 <tr>
	 	<th>파일첨부</th>
	 	<td><a href="file/notice?filename=${flpth.bf_File_Nm }">${flpth.bf_File_Nm}</a></td>
	 </tr>
	</c:forEach>
	 <tr>
	 	<th>내용</th>
	 	<td>${notice.nb_Cn}</td>
	 </tr>

</table>

<div> <!-- 댓글부분 --> 
	<textarea rows="3" cols="60" id="comment_content" name="comment_content"></textarea></td>
	<input type="button" vlaue="확인" id="btnSave"></td>
</div>

</form>

<!--버튼들  -->
<div id="buttons" style="float:right">
	<%-- <a href="deleteNotice?no=${notice.nb_Bbs_No}&tpage=${tpage}"> <input type="button" class="def-btn" value="삭제"> </a> --%>
	<a href="updateNotice?no=${notice.nb_Bbs_No}&tpage=${tpage}"> <input type="button" value="수정" class="def-btn"> </a>
	<input type="button" class="def-btn" data-target="#layerpop" data-toggle="modal" value="삭제">
	<a href="noticeList?no=${notice.nb_Bbs_No}&tpage=${tpage}"> <input type="button" class="def-btn" value="목록"> </a>
</div>

<!--모달부분  -->
<div class="modal fade" id="layerpop" >
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
      <div class="modal-body" style="text-align: center">
            삭제하시겠습니까?
      </div>
      <!-- Footer -->
      <div class="modal-footer" style="text-align:center;">
        <a href="deleteNotice?no=${notice.nb_Bbs_No}&tpage=${tpage}"> <!--삭제 모달  -->
        <input type="button" class="btn btn-default" value="예">
        </a>
        <input type="button" class="btn btn-default" data-dismiss="modal" value="아니오">
      </div>
    </div>
  </div>
</div>




</body>
</html>
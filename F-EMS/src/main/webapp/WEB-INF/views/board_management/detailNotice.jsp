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
$(document).ready(function() {
	var bbs_no = $('#bbs_no').val();
    var data ={'bbs_no' : bbs_no};
    
    $.ajax({
       url:'<%=request.getContextPath()%>/notice_bbs/commentList',
       contentType:'application/json',
       dataType:'json',
       data:JSON.stringify(data),
       type:'post',
       success : function(data){
          $.each(data, function(i) {
             var date = new Date(
                   data[i].bc_Writng_Dt);
             var year = date.getFullYear();
             var month = (1 + date.getMonth());
             month = month >= 10 ? month : '0'
                   + month;
             var day = date.getDate();
             day = day >= 10 ? day : '0' + day;
             var fullD = year + '년' + month
                   + '월' + day + '일';
             var commentList = '<div id="'
                 + data[i].bc_Comnt_No   
                 + '">아이디 : '
                 + data[i].bc_User_Id
                 + '  /  ' + '작성 날짜 : '
              + fullD
              +'<a href="" id="'
                 +data[i].bc_Comnt_No
                 +'" ' 
                 +'class="deleteComment" name="deleteComment">삭제</a>'
              + '<div>  ->'
                 + data[i].bc_Comnt_Content
                 +'</div></div><br><br>';
           $('div #comment').append(commentList);
        });
     },
       error:function(error){
       alert(error);   
       }
    });
});




function commm_go(){
	var bbs_no = $('#bbs_no').val();
	var comment_content = $('#comment_content').val();
	var dataWrite={
			'bbs_no' : bbs_no,
			'comment_content' : comment_content
	};
	$.ajax({
		url : '<%=request.getContextPath()%>/notice_bbs/insertComment',
		data : JSON.stringify(dataWrite),
		type : 'post',
		contentType : 'application/json',
		success : function(data){
			  $('#comment_content').val('');
		       $('div #comment').empty();
	          $.each(data, function(i) {
	             var date = new Date(
	                   data[i].bc_Writng_Dt);
	             var year = date.getFullYear();
	             var month = (1 + date.getMonth());
	             month = month >= 10 ? month : '0'
	                   + month;
	             var day = date.getDate();
	             day = day >= 10 ? day : '0' + day;
	             var fullD = year + '년' + month
	                   + '월' + day + '일';
	             var commentList = '<div id="'
	                 + data[i].bc_Comnt_No   
	                 + '">아이디 : '
	                 + data[i].bc_User_Id
	                 + '  /  ' + '작성 날짜 : '
	              + fullD
	              +'<a href="" id="'
	                 +data[i].bc_Comnt_No
	                 +'" ' 
	                 +'class="deleteComment" name="deleteComment">삭제</a>'
	              + '<div>  ->'
	                 + data[i].bc_Comnt_Content
	                 +'</div></div><br><br>';
	           $('div #comment').append(commentList);
	        });
	     },
	      error : function() {
	         alert('댓글 등록 실패');
	      }
	   });
	}


$(document).on('click','.deleteComment',function(e){
    e.preventDefault();
    var result = $(this).attr('id');
    $.ajax({
       url:"<%=request.getContextPath()%>/notice_bbs/deleteComment",
       data: {"result" : result},
       dataType:'json',
       type:'post',
       
       success:function(map1){
          freeMap = jQuery.map(map1 , function(a){
             return a;
          })
          $('#'+freeMap).remove();
       }
    });
 });





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

<div id="comment"></div> <!-- 댓글부분 --> 


	<input type="hidden" value="${notice.nb_Bbs_No }" id="bbs_no" name="bbs_no">
	<textarea rows="3" cols="60" id="comment_content" name="comment_content"></textarea></td>
	<input type="button" value="확인" id="btnSave" onclick="commm_go();"></td>


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